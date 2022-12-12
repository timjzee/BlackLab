package org.ivdnt.blacklab.solr;

import java.io.InputStream;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.lucene.index.IndexReader;
import org.apache.solr.common.params.SolrParams;
import org.apache.solr.common.util.ContentStream;
import org.apache.solr.common.util.ContentStreamBase;
import org.apache.solr.handler.loader.ContentStreamLoader;
import org.apache.solr.request.SolrQueryRequest;
import org.apache.solr.response.SolrQueryResponse;
import org.apache.solr.update.processor.UpdateRequestProcessor;

import nl.inl.blacklab.index.BLIndexObjectFactorySolr;
import nl.inl.blacklab.index.DocumentFormats;
import nl.inl.blacklab.index.Indexer;
import nl.inl.blacklab.indexers.config.ConfigInputFormat;
import nl.inl.blacklab.search.BlackLab;
import nl.inl.blacklab.search.BlackLabIndexWriter;

public class BLSolrXMLLoader extends ContentStreamLoader {

    @Override
    public void load(SolrQueryRequest req, SolrQueryResponse rsp, ContentStream stream, UpdateRequestProcessor processor) throws Exception {
        BlackLab.implicitInstance().setIndexObjectFactory(BLIndexObjectFactorySolr.INSTANCE);

        final String charset = ContentStreamBase.getCharsetFromContentType(stream.getContentType());


        // find the directory
        SolrParams params = req.getParams();
        IndexReader reader = req.getSearcher().getIndexReader();

//        BlackLabIndexWriter index = BlackLab.openForWriting(new File(req.getCore().getIndexDir()), false, params.get("bl.format"), null,
//                BlackLabIndex.IndexType.INTEGRATED);

        // register input format from test directory
        // TODO find another way to do this.
        // perhaps move this test?
        DocumentFormats.registerFormatsInDirectories(List.of(Paths.get("..", "test", "data").toFile()));
        ConfigInputFormat format = DocumentFormats.getConfigInputFormat(params.get("bl.format"));
        BlackLabIndexWriter index = BlackLab.implicitInstance().openForWriting(reader, format);
        Indexer indexer = Indexer.get(index, params.get("bl.format"));
        index.getUserObjectMap().put("solrqueryrequest", req);
        index.getUserObjectMap().put("updaterequestprocessor", processor);


        InputStream is = stream.getStream();
        indexer.index(stream.getName(), is);
        IOUtils.closeQuietly(is);
    }
}
