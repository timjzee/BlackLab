package nl.inl.blacklab.index;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.document.Field;
import org.apache.solr.common.SolrInputDocument;

/**
 * Class for a BlackLab document being indexed directly into Lucene.
 */
public class BLInputDocumentSolr implements BLInputDocument {

    private final SolrInputDocument document;
    
    public BLInputDocumentSolr() {
        document = new SolrInputDocument();
    }

    public void addField(String name, String value, BLFieldType fieldType) {
        document.addField(name, value);
    }

    @Override
    public void addAnnotationField(String name, TokenStream tokenStream, BLFieldType fieldType) {
        Field f = new Field(name, tokenStream, fieldType.luceneType());
        document.addField(name, f);
    }

    public void addStoredNumericField(String name, int value, boolean addDocValue) {
        document.addField(name, value);
    }

    public void addStoredField(String name, String value) {
        document.addField(name, value);
    }

    public SolrInputDocument getDocument() {
        return document;
    }

    @Override
    public String get(String name) {
        return document.getField(name).getValue().toString();
    }

    @Override
    public void addTextualMetadataField(String name, String value, BLFieldType type) {
        // If a value is too long (more than 32K), just truncate it a bit.
        // This should be very rare and would generally only affect sorting/grouping, if anything.
        value = BLInputDocument.truncateValue(value);
        // docvalues for efficient sorting/grouping
        document.addField(name, value);
    }

    @Override
    public BLIndexObjectFactory indexObjectFactory() {
        return BLIndexObjectFactoryLucene.INSTANCE;
    }

}
