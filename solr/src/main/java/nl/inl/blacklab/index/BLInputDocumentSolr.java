package nl.inl.blacklab.index;

import java.nio.charset.StandardCharsets;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexableFieldType;
import org.apache.solr.common.SolrInputDocument;

/**
 * Class for a BlackLab document being indexed directly into Lucene.
 */
public class BLInputDocumentSolr implements BLInputDocument {

    private final SolrInputDocument document;
    
    public BLInputDocumentSolr() {
        document = new SolrInputDocument();
    }

    IndexableFieldType luceneType(BLFieldType type) {
        return ((BLFieldTypeLucene)type).getLuceneFieldType();
    }

    public void addField(String name, String value, BLFieldType fieldType) {
        document.addField(name, value);
    }

    public void addAnnotationField(String name, TokenStream tokenStream, BLFieldTypeLucene fieldType) {
        Field f = new Field(name, tokenStream, fieldType.getLuceneFieldType());
        document.addField(name, f);
    }

    public void addStoredNumericField(String name, int value, boolean addDocValue) {
        document.addField(name, value);
    }

    public void addStoredField(String name, String value) {
        document.addField(name, value);
    }

    @Override
    public void addAnnotationField(String name, TokenStream tokenStream, BLFieldType fieldType) {

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
        addField(name, value, type);
        // If a value is too long (more than 32K), just truncate it a bit.
        // This should be very rare and would generally only affect sorting/grouping, if anything.
        if (value.length() > MAX_DOCVALUES_LENGTH / 6) { // only when it might be too large...
            // While it's really too large
            byte[] utf8 = value.getBytes(StandardCharsets.UTF_8);
            while (utf8.length > MAX_DOCVALUES_LENGTH) {
                // assume all characters take two bytes, truncate and try again
                int overshoot = utf8.length - MAX_DOCVALUES_LENGTH;
                int truncateAt = value.length() - 2 * overshoot;
                if (truncateAt < 1)
                    truncateAt = 1;
                value = value.substring(0, truncateAt);
                utf8 = value.getBytes(StandardCharsets.UTF_8);
            }
        }
        // docvalues for efficient sorting/grouping
        document.addField(name, value);
    }

    @Override
    public BLIndexObjectFactory indexObjectFactory() {
        return BLIndexObjectFactoryLucene.INSTANCE;
    }

}
