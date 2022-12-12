package org.ivdnt.blacklab.solr;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.FSDirectory;
import org.apache.solr.common.params.SolrParams;
import org.apache.solr.common.util.ContentStream;
import org.apache.solr.common.util.ContentStreamBase;
import org.apache.solr.handler.loader.ContentStreamLoader;
import org.apache.solr.request.SolrQueryRequest;
import org.apache.solr.response.SolrQueryResponse;
import org.apache.solr.update.AddUpdateCommand;
import org.apache.solr.update.processor.UpdateRequestProcessor;

import nl.inl.blacklab.index.BLIndexObjectFactorySolr;
import nl.inl.blacklab.index.Indexer;
import nl.inl.blacklab.indexers.config.ConfigInputFormat;
import nl.inl.blacklab.indexers.config.DocIndexerXPath;
import nl.inl.blacklab.search.BlackLab;
import nl.inl.blacklab.search.BlackLabIndexWriter;

public class BLSolrXMLLoader extends ContentStreamLoader {

    @Override
    public void load(SolrQueryRequest req, SolrQueryResponse rsp, ContentStream stream, UpdateRequestProcessor processor) throws Exception {
        BlackLab.implicitInstance().setIndexObjectFactory(BLIndexObjectFactorySolr.INSTANCE);

        final String charset = ContentStreamBase.getCharsetFromContentType(stream.getContentType());


        SolrParams params = req.getParams();
        IndexReader reader = req.getSearcher().getIndexReader();

        processor.processAdd(new AddUpdateCommand(req));
        BlackLabIndexWriter index = BlackLab.openForWriting(reader);

        Indexer indexer = Indexer.get(index, params.get("bl.format"));

        InputStream is = stream.getStream();
        indexer.index(stream.getName(), is);
        IOUtils.closeQuietly(is);
    }

    private IndexWriter getLuceneIndexWriter(String indexPath) throws IOException {
        FSDirectory directory = FSDirectory.open(new File(indexPath).toPath());
        Analyzer analyzer = new StandardAnalyzer();
        IndexWriterConfig iwc = new IndexWriterConfig(analyzer);
        return new IndexWriter(directory, iwc);
    }

    private void test(IndexReader reader, SolrQueryRequest req, UpdateRequestProcessor proc) throws IOException {
        DocIndexerXPath di = new DocIndexerXPath();
        di.setConfigInputFormat(new ConfigInputFormat(null, null));



    }
}
