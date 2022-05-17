package org.ivdnt.blacklab.aggregator.resources;

import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.tuple.Pair;
import org.ivdnt.blacklab.aggregator.logic.Aggregation;
import org.ivdnt.blacklab.aggregator.logic.Requests;
import org.ivdnt.blacklab.aggregator.logic.Requests.BlsRequestException;
import org.ivdnt.blacklab.aggregator.representation.Corpus;
import org.ivdnt.blacklab.aggregator.representation.DocOverview;
import org.ivdnt.blacklab.aggregator.representation.ErrorResponse;
import org.ivdnt.blacklab.aggregator.representation.InputFormats;

@Path("/{corpusName}")
public class CorpusResource {

    private static Response resourceNotImplemented(String resource) {
        ErrorResponse error = new ErrorResponse("NOT_IMPLEMENTED",
                "The " + resource + " resource hasn't been implemented on the aggregator.");
        return Response.status(Response.Status.NOT_IMPLEMENTED).entity(error).build();
    }

    /** REST client */
    private final Client client;

    @Inject
    public CorpusResource(Client client) {
        this.client = client;
    }

    /**
     * Get information about a corpus.
     *
     * @param corpusName corpus name
     * @return corpus information
     */
    @GET
    @Path("")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response corpusInfo(@PathParam("corpusName") String corpusName,
            @DefaultValue("") @QueryParam("listvalues") String listvalues) {

        switch (corpusName) {
        case "input-formats":
            return Response.ok().entity(new InputFormats()).build();
        case "cache-info":
        case "help":
            return resourceNotImplemented("/" + corpusName);
        }

        // Query each node and collect responses
        Map<String, Corpus> nodeResponses;
        try {
            nodeResponses = Requests.getResponses(client, target -> target.path(corpusName)
                    .queryParam("listvalues", listvalues), Corpus.class);
        } catch (BlsRequestException e) {
            // One of the node requests produced an error. Return it now.
            return Response.status(e.getStatus()).entity(e.getResponse()).build();
        }

        // Merge responses
        Corpus merged = nodeResponses.values().stream().reduce(Aggregation::mergeCorpus).orElseThrow();
        return Response.ok().entity(merged).build();
    }

    /**
     * Perform a /hits request.
     */
    @GET
    @Path("/hits")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response hits(
    		@PathParam("corpusName") String corpusName,
    		@QueryParam("patt") String patt,
            @DefaultValue("") @QueryParam("sort") String sort,
            @DefaultValue("") @QueryParam("group") String group,
            @DefaultValue("0") @QueryParam("first") long first,
            @DefaultValue("20") @QueryParam("number") long number,
            @DefaultValue("") @QueryParam("viewgroup") String viewGroup) {

        return Requests.getHitsResponse(client, corpusName, patt, sort,
                group, first, number, viewGroup);
    }

    /**
     * Perform a /hits request.
     */
    @GET
    @Path("/docs/{pid}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response docOverview(
            @PathParam("corpusName") String corpusName,
            @PathParam("pid") String pid) {

        // Query each node and collect responses
        try {
            Pair<String, DocOverview> response = Requests.getFirstSuccesfulResponse(client,
                    target -> target.path(corpusName).path("docs").path(pid),
                    DocOverview.class, MediaType.APPLICATION_JSON_TYPE);
            if (response == null)
                return Response.status(404).entity(new ErrorResponse("DOC_NOT_FOUND", "Document with pid '" + pid + "' wasn't found on any of the nodes.")).build();
            System.err.println("Found doc " + corpusName + "/" + pid + " on node " + response.getKey());
            return Response.ok().entity(response.getValue()).build();
        } catch (BlsRequestException e) {
            // One of the node requests produced an error. Return it now.
            return Response.status(e.getStatus()).entity(e.getResponse()).build();
        }
    }

    @GET
    @Path("/docs")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response docsNotImplemented() {
        return resourceNotImplemented("/CORPUS/docs");
    }

    /**
     * Perform a /hits request.
     */
    @GET
    @Path("/docs/{pid}/contents")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response docContents(
            @PathParam("corpusName") String corpusName,
            @PathParam("pid") String pid) {

        // Query each node and collect responses
        try {
            Pair<String, String> response = Requests.getFirstSuccesfulResponse(client,
                    target -> target.path(corpusName).path("docs").path(pid).path("contents"),
                    String.class, MediaType.APPLICATION_XML_TYPE);
            if (response == null)
                return Response.status(404).entity(new ErrorResponse("DOC_NOT_FOUND", "Document with pid '" + pid + "' wasn't found on any of the nodes.")).build();
            System.err.println("Found doc " + corpusName + "/" + pid + " on node " + response.getKey());
            return Response.ok().type(MediaType.APPLICATION_XML).entity(response.getValue()).build();
        } catch (BlsRequestException e) {
            // One of the node requests produced an error. Return it now.
            return Response.status(e.getStatus()).entity(e.getResponse()).build();
        }
    }

    @GET
    @Path("/termfreq")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response termFreq(String annotation, String terms) {
        // (TermFreqList resource exists, merge operation not yet, maybe implement later)
        return resourceNotImplemented("/CORPUS/termfreq");
    }

    /**
     * Perform a /hits request.
     */
    @GET
    @Path("/{resource:debug|fields|status|explain|autocomplete|sharing}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response notImplemented(@PathParam("resource") String resource) {
        return resourceNotImplemented("/CORPUS/" + resource);
    }

}