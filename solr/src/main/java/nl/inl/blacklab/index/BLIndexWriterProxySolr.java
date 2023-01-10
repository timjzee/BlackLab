package nl.inl.blacklab.index;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.index.Term;
import org.apache.lucene.search.Query;
import org.apache.solr.update.AddUpdateCommand;
import org.apache.solr.update.DeleteUpdateCommand;

import nl.inl.blacklab.search.BlackLabIndexWriter;

/**
 * Simple proxy for Solr IndexWriter.
 */
public class BLIndexWriterProxySolr implements BLIndexWriterProxy, Closeable {
//    SolrQueryRequest request;
//    UpdateRequestProcessor next;
    BlackLabIndexWriter writer;

    List<BLInputDocument> pendingAddDocuments = new ArrayList<>();
//    List<BLInputDocument> pendingDeleteDocuments = new ArrayList<>();


    BLIndexWriterProxySolr(BlackLabIndexWriter writer) {
        this.writer = writer;
    }


    @Override
    synchronized public void addDocument(BLInputDocument document) throws IOException {
//        ensureInitialized();
        pendingAddDocuments.add(document);

//        AddUpdateCommand cmd = new AddUpdateCommand(null);
//        cmd.solrDoc = ((BLInputDocumentSolr) document).getDocument();
//        cmd.overwrite = true;
//        cmd.setReq(request);
//
//        next.processAdd(cmd);
    }

    @Override
    public void close() throws IOException {
//        next.close();
    }

    @Override
    public void commit() throws IOException {
//        next.processCommit(new CommitUpdateCommand(request, true));
    }

    @Override
    public void rollback() throws IOException {
//        next.processRollback(new RollbackUpdateCommand(request));
    }

    @Override
    public boolean isOpen() {
        return true;
    }

    @Override
    public void deleteDocuments(Query q) throws IOException {
//        ensureInitialized();

        DeleteUpdateCommand cmd = new DeleteUpdateCommand(request);
//        next.processDelete(cmd);
    }

    @Override
    public long updateDocument(Term term, BLInputDocument document) throws IOException {
//        ensureInitialized();
//
//        AddUpdateCommand cmd = new AddUpdateCommand(null);
//        cmd.solrDoc = ((BLInputDocumentSolr) document).getDocument();
//        cmd.overwrite = true;
//        next.processAdd(cmd);
//        return -1;
    }

    @Override
    public int getNumberOfDocs() {
        // TODO
        return 0;
    }
}
