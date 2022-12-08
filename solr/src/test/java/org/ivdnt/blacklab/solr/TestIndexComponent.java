/**
 * Embedded Solr test.
 *
 * Inspired by code from Mtas, https://github.com/meertensinstituut/mtas/
 */

package org.ivdnt.blacklab.solr;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.solr.client.solrj.SolrRequest;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.request.GenericSolrRequest;
import org.apache.solr.client.solrj.request.RequestWriter;
import org.apache.solr.common.params.CommonParams;
import org.apache.solr.common.params.ModifiableSolrParams;
import org.apache.solr.common.util.NamedList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class TestIndexComponent {

    static final String CORE_NAME = "testcore";

    public static final String DOCUMENT_FORMAT = "voice-tei";



    @BeforeClass
    public static void prepareClass() throws Exception
    {
        Path resourcePath = Paths.get("src", "test", "resources", "solrDir");
        Path confTemplatePath = resourcePath.resolve("conf");

        // Create srver, core and add document
        SolrTestServer.createEmbeddedServer(CORE_NAME, resourcePath);
        SolrTestServer.setLogLevel("WARN"); // show log messages
        SolrTestServer.createCore(CORE_NAME, confTemplatePath);

        // (component is already added in solrconfig.xml, so this call is not needed,
        //  and the method unfortunately doesn't work yet anyway, see comment. we'll look at it later)
        //SolrTestServer.addSearchComponent(CORE_NAME, "apply-xslt", ApplyXsltComponent.class.getCanonicalName());
    }


    @AfterClass
    public static void cleanUpClass() {
        SolrTestServer.close();
    }



    @Test
    public void testAddData() throws SolrServerException, IOException {
        ModifiableSolrParams solrParams = new ModifiableSolrParams();
        solrParams.add(CommonParams.Q, "*:*");
        solrParams.add("bl", "true"); // activate our component
        solrParams.add("bl.format", DOCUMENT_FORMAT); // activate our component


        String urlPath = "/update";
        GenericSolrRequest r = new GenericSolrRequest(SolrRequest.METHOD.POST, urlPath, solrParams);



        Path path = Paths.get("..", "test", "data", "input", "PBsve430.xml");
        path = path.toAbsolutePath();
        String content = Files.readString(path);
        r.setContentWriter(new RequestWriter.StringPayloadContentWriter(content, "application/xml"));

        NamedList<Object> response = SolrTestServer.client().request(r);
        System.err.println("Add file response\n" + response.toString());
    }
}
