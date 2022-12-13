package nl.inl.blacklab.index;

import org.apache.lucene.index.IndexWriter;

import nl.inl.blacklab.index.annotated.AnnotatedFieldWriter;
import nl.inl.blacklab.index.annotated.AnnotationSensitivities;
import nl.inl.blacklab.search.indexmetadata.AnnotationSensitivity;

/**
 * Factory object for objects related to indexing.
 * This interface is mainly responsible for supplying those objects that need to be aware of the type of index this is (solr or lucene), but do not need details specific to the shape and data in the index.
 * Examples are: the forward index system, the metadata system, the content store.
 *
 * are tied to a specific type of index implementation (solr/lucene), but do not otherwise depend on details in the specific index instance. * For example,
 */
public interface BLIndexObjectFactory {
    static BLIndexObjectFactory get(boolean runningFromSolr) {
         return runningFromSolr ? null/*BLIndexObjectFactorySolr.INSTANCE*/ : BLIndexObjectFactoryLucene.INSTANCE;
    }

    BLInputDocument createInputDocument();

    BLFieldType fieldTypeMetadata(boolean tokenized);

    BLFieldType fieldTypeContentStore();

    BLFieldType fieldTypeAnnotationSensitivity(boolean offsets, boolean forwardIndex);

    BLFieldType fieldTypeIndexMetadataMarker();

    BLIndexWriterProxy indexWriterProxy(IndexWriter luceneIndexWriter);
}
