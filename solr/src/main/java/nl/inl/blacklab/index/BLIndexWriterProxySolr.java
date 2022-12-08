package nl.inl.blacklab.index;

import java.io.Closeable;
import java.io.IOException;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.Query;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.update.SolrIndexWriter;

/**
 * Simple proxy for Lucene IndexWriter.
 */
public class BLIndexWriterProxySolr implements BLIndexWriterProxy, Closeable {

    private final SolrIndexWriter indexWriter;

    public BLIndexWriterProxySolr(IndexWriter indexWriter) {
        this.indexWriter = indexWriter;
    }

    @Override
    public void addDocument(BLInputDocumentSolr document) throws IOException {
        SolrInputDocument doc = document.getDocument();
        doc.iterator()

        indexWriter.addDocument(document.getDocument());
    }

    @Override
    public void close() throws IOException {
        indexWriter.close();
    }

    @Override
    public void commit() throws IOException {
        indexWriter.commit();
    }

    @Override
    public void rollback() throws IOException {
        indexWriter.rollback();
    }

    @Override
    public boolean isOpen() {
        return indexWriter.isOpen();
    }

    public IndexWriter getWriter() {
        return indexWriter;
    }

    @Override
    public void deleteDocuments(Query q) throws IOException {
        indexWriter.deleteDocuments(q);
    }

    @Override
    public long updateDocument(Term term, BLInputDocument document) throws IOException {
        return indexWriter.updateDocument(term, luceneDoc(document));
    }

    @Override
    public int getNumberOfDocs() {
        return indexWriter.getDocStats().numDocs;
    }
}
