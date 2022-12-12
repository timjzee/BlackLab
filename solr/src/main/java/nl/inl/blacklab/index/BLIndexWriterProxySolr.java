package nl.inl.blacklab.index;

import java.io.Closeable;
import java.io.IOException;

import org.apache.lucene.index.Term;
import org.apache.lucene.search.Query;
import org.apache.solr.request.SolrQueryRequest;
import org.apache.solr.update.AddUpdateCommand;
import org.apache.solr.update.CommitUpdateCommand;
import org.apache.solr.update.DeleteUpdateCommand;
import org.apache.solr.update.RollbackUpdateCommand;
import org.apache.solr.update.processor.UpdateRequestProcessor;

import nl.inl.blacklab.search.BlackLabIndexWriter;

/**
 * Simple proxy for Lucene IndexWriter.
 */
public class BLIndexWriterProxySolr implements BLIndexWriterProxy, Closeable {
    SolrQueryRequest request;
    UpdateRequestProcessor next;
    BlackLabIndexWriter writer;

    BLIndexWriterProxySolr(BlackLabIndexWriter writer) {
        this.request = (SolrQueryRequest) writer.getUserObjectMap().get("solrqueryrequest");
        this.next = (UpdateRequestProcessor) writer.getUserObjectMap().get("updaterequestprocessor");
        this.writer = writer;
    }

    @Override
    public void addDocument(BLInputDocument document) throws IOException {
        AddUpdateCommand cmd = new AddUpdateCommand(null);
        cmd.solrDoc = ((BLInputDocumentSolr) document).getDocument();
        cmd.overwrite = true;
        next.processAdd(cmd);
    }

    @Override
    public void close() throws IOException {
        next.close();
    }

    @Override
    public void commit() throws IOException {
        next.processCommit(new CommitUpdateCommand(request, true));
    }

    @Override
    public void rollback() throws IOException {
        next.processRollback(new RollbackUpdateCommand(request));
    }

    @Override
    public boolean isOpen() {
        return true;
    }

    @Override
    public void deleteDocuments(Query q) throws IOException {
        DeleteUpdateCommand cmd = new DeleteUpdateCommand(request);
        next.processDelete(cmd);
    }

    @Override
    public long updateDocument(Term term, BLInputDocument document) throws IOException {
        AddUpdateCommand cmd = new AddUpdateCommand(null);
        cmd.solrDoc = ((BLInputDocumentSolr) document).getDocument();
        cmd.overwrite = true;
        next.processAdd(cmd);
        return -1;
    }

    @Override
    public int getNumberOfDocs() {
        // TODO
        return 0;
    }
}
