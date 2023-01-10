package org.ivdnt.blacklab.solr;

import java.io.InputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.xml.validation.SchemaFactory;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.AnnotationUtils;
import org.apache.lucene.index.IndexOptions;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.solr.client.solrj.SolrRequest;
import org.apache.solr.client.solrj.request.schema.SchemaRequest;
import org.apache.solr.common.SolrException;
import org.apache.solr.common.SolrInputField;
import org.apache.solr.common.params.SolrParams;
import org.apache.solr.common.util.ContentStream;
import org.apache.solr.common.util.ContentStreamBase;
import org.apache.solr.core.SolrCore;
import org.apache.solr.handler.loader.ContentStreamLoader;
import org.apache.solr.request.SolrQueryRequest;
import org.apache.solr.response.SolrQueryResponse;
import org.apache.solr.schema.IndexSchema;
import org.apache.solr.schema.ManagedIndexSchema;
import org.apache.solr.schema.ManagedIndexSchemaFactory;
import org.apache.solr.schema.SchemaField;
import org.apache.solr.schema.SchemaManager;
import org.apache.solr.update.processor.AddSchemaFieldsUpdateProcessorFactory;
import org.apache.solr.update.processor.FieldMutatingUpdateProcessor;
import org.apache.solr.update.processor.UpdateRequestProcessor;

import nl.inl.blacklab.index.BLFieldTypeLucene;
import nl.inl.blacklab.index.BLIndexObjectFactorySolr;
import nl.inl.blacklab.index.BLIndexWriterProxySolr;
import nl.inl.blacklab.index.DocumentFormats;
import nl.inl.blacklab.index.Indexer;
import nl.inl.blacklab.indexers.config.ConfigInputFormat;
import nl.inl.blacklab.search.BlackLab;
import nl.inl.blacklab.search.BlackLabIndexWriter;
import nl.inl.blacklab.search.indexmetadata.AnnotatedFieldNameUtil;
import nl.inl.blacklab.search.indexmetadata.FieldType;
import nl.inl.blacklab.search.indexmetadata.IndexMetadata;
import nl.inl.blacklab.search.indexmetadata.MetadataField;
import nl.inl.util.LuceneUtil;

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



        String indexName = req.getCore().getName();
        try (BlackLabIndexWriter index = BlackLab.implicitInstance().openForWriting(indexName, reader, format)) {
            Indexer indexer = Indexer.get(index, params.get("bl.format"));
            InputStream is = stream.getStream();
            indexer.index(stream.getName(), is);


            BLIndexWriterProxySolr blSolrWriter = (BLIndexWriterProxySolr) indexer.indexWriter();
            synchronizeSolrSchema(index.metadata(), req.getCore(), req);

            // get metadata and update solr schema
            // commit docs



            IOUtils.closeQuietly(is);
        }
    }

    // Code adapted from AddSchemaFieldsUpdateProcessor
    void synchronizeSolrSchema(BlackLabIndexWriter w, IndexMetadata metadata, SolrCore core, SolrQueryRequest r, UpdateRequestProcessor proc) {
        IndexSchema oldSchema = r.getSchema();
        SchemaRequest req = new SchemaRequest();

        synchronized (oldSchema.getSchemaUpdateLock()) {
            List<SchemaField> newFields = metadata.metadataFields().stream().filter(mf -> oldSchema.hasExplicitField(mf.name())).map(mf ->
                oldSchema.newField(mf.name(),
                        mf.equals(metadata.metadataFields().pidField()) ? "metadata_pid" :
                        mf.type() == FieldType.UNTOKENIZED ? "metadata_untokenized" :
                        mf.type() == FieldType.TOKENIZED ? "metadata_tokenized" :
                                "metadata_numeric"
                        ,
                        Collections.emptyMap())
            ).collect(Collectors.toList());

            metadata.annotatedFields().stream()
                    .flatMap(af -> af.annotations().stream())
                    .flatMap(annot -> annot.sensitivities().stream())
                    .filter(annotSensitivity -> oldSchema.hasExplicitField(annotSensitivity.luceneField()))
                    .forEach(missingAnnot -> {
//                         see FieldProperties for supported options.
//                        "indexed", "tokenized", "stored",
//                        "binary", "omitNorms", "omitTermFreqAndPositions",
//                        "termVectors", "termPositions", "termOffsets",
//                        "multiValued",
//                        "sortMissingFirst","sortMissingLast","required", "omitPositions",
//                        "storeOffsetsWithPositions", "docValues", "termPayloads", "useDocValuesAsStored", "large",
//                        "uninvertible"

                        Map<String, Object> fieldAttributes = new HashMap<>();
//                        fieldAttributes.put("indexed", missingAnnot.annotation().)

                        boolean indexed = true; // only false for contentstore field, which won't show up here
                        boolean tokenized = indexed;
                        boolean stored = false; // only true for contentstore
                        boolean binary = false;
                        boolean omitNorms = true; // always true
                        boolean omitTermFreqAndPositions = !(indexed || tokenized);
                        boolean termVectors = indexed;
                        boolean termPositions = indexed;
                        boolean termOffsets = indexed && offsets; // TODO where does offsets come from?
                        boolean multiValued = true; // I suppose this is always true for annotations
                        // skip sortMissingFirst, sortMissingLast, required, omitPositions
                        boolean omitPositions = !(indexed)


                        boolean offsets = missingAnnot.annotation().field().mainAnnotation() == missingAnnot.annotation();
                        boolean stored =
                        BLFieldTypeLucene.annotationSensitivity()



                        return oldSchema.newField(missingAnnot.luceneField(), "annotation", fieldAttributes);
                    });







                return Stream.empty();
            }).collect(Collectors.toList());


            for (final Map.Entry<String,List<SolrInputField>> entry : unknownFields.entrySet()) {
                String fieldName = entry.getKey();
                String fieldTypeName = defaultFieldType;
                AddSchemaFieldsUpdateProcessorFactory.TypeMapping typeMapping = mapValueClassesToFieldType(entry.getValue());
                if (typeMapping != null) {
                    fieldTypeName = typeMapping.fieldTypeName;
                    if (!typeMapping.copyFieldDefs.isEmpty()) {
                        newCopyFields.put(fieldName,
                                typeMapping.copyFieldDefs.stream().collect(Collectors.groupingBy(
                                        AddSchemaFieldsUpdateProcessorFactory.CopyFieldDef::getMaxChars)));
                    }
                }
                newFields.add(oldSchema.newField(fieldName, fieldTypeName, Collections.<String,Object>emptyMap()));
            }


            Collection<SchemaField> newFields = new ArrayList<>();
            IndexSchema newSchema = oldSchema.addFields(newFields, Collections.emptyMap(), false);
            // Add copyFields
    //                    for (Map.Entry<String, Map<Integer, List<AddSchemaFieldsUpdateProcessorFactory.CopyFieldDef>>> entry : newCopyFields.entrySet()) {
    //                        String srcField = entry.getKey();
    //                        for (Integer maxChars : entry.getValue().keySet()) {
    //                            newSchema = newSchema.addCopyFields(srcField,
    //                                    entry.getValue().get(maxChars).stream().map(f -> f.getDest(srcField)).collect(Collectors.toList()),
    //                                    maxChars);
    //                        }
    //                    }
            if (null != newSchema) {
                ((ManagedIndexSchema)newSchema).persistManagedSchema(false);
                core.setLatestSchema(newSchema);
                cmd.getReq().updateSchemaToLatest();
                log.debug("Successfully added field(s) and copyField(s) to the schema.");
                break; // success - exit from the retry loop
            } else {
                throw new SolrException(SolrException.ErrorCode.SERVER_ERROR, "Failed to add fields and/or copyFields.");
            }
        } catch (ManagedIndexSchema.FieldExistsException e) {
            log.error("At least one field to be added already exists in the schema - retrying.");
            oldSchema = core.getLatestSchema();
            cmd.getReq().updateSchemaToLatest();
        } catch (ManagedIndexSchema.SchemaChangedInZkException e) {
            log.debug("Schema changed while processing request - retrying.");
            oldSchema = core.getLatestSchema();
            cmd.getReq().updateSchemaToLatest();
        }
    }

    }
}
