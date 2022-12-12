package nl.inl.blacklab.index;

import org.apache.lucene.document.FieldType;
import org.apache.lucene.index.IndexOptions;
import org.apache.lucene.index.IndexWriter;

import nl.inl.blacklab.search.BlackLabIndexWriter;

/**
 * Factory for objects related to indexing directly to Lucene.
 *
 * Specifically, returns instances of BLInputDocumentLucene and BLFieldTypeLucene.
 */
public class BLIndexObjectFactorySolr implements BLIndexObjectFactory {
    public static BLIndexObjectFactorySolr INSTANCE = new BLIndexObjectFactorySolr();

    private static BLFieldTypeLucene indexMetadataMarkerFieldType;

    static {
        FieldType marker = new FieldType();
        marker.setIndexOptions(IndexOptions.DOCS);
        marker.setTokenized(false);
        marker.setOmitNorms(true);
        marker.setStored(false);
        marker.setStoreTermVectors(false);
        marker.setStoreTermVectorPositions(false);
        marker.setStoreTermVectorOffsets(false);
        marker.freeze();
        indexMetadataMarkerFieldType = new BLFieldTypeLucene(marker);
    }

    private BLIndexObjectFactorySolr() {}

    @Override
    public BLInputDocument createInputDocument() {
        return new BLInputDocumentSolr();
    }

    @Override
    public BLFieldType fieldTypeMetadata(boolean tokenized) {
        return BLFieldTypeLucene.metadata(tokenized);
    }

    @Override
    public BLFieldType fieldTypeContentStore() {
        return BLFieldTypeLucene.contentStore();
    }

    @Override
    public BLFieldType fieldTypeAnnotationSensitivity(boolean offsets, boolean forwardIndex) {
        return BLFieldTypeLucene.annotationSensitivity(offsets, forwardIndex);
    }

    public BLFieldType fieldTypeIndexMetadataMarker() {
        return indexMetadataMarkerFieldType;
    }

    @Override
    public BLIndexWriterProxy indexWriterProxy(IndexWriter luceneIndexWriter, BlackLabIndexWriter indexWriter) {
        return new BLIndexWriterProxySolr(indexWriter);
    }
}
