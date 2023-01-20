package nl.inl.blacklab.server.requesthandlers;

import javax.servlet.http.HttpServletRequest;

import nl.inl.blacklab.exceptions.InvalidQuery;
import nl.inl.blacklab.server.BlackLabServer;
import nl.inl.blacklab.server.datastream.DataStream;
import nl.inl.blacklab.server.exceptions.BlsException;
import nl.inl.blacklab.server.lib.User;
import nl.inl.blacklab.server.lib.results.WebserviceRequestHandler;

/**
 * Request handler for grouped hit results.
 */
public class RequestHandlerHitsGrouped extends RequestHandler {

    public RequestHandlerHitsGrouped(BlackLabServer servlet, HttpServletRequest request, User user, String indexName,
            String urlResource, String urlPathPart) {
        super(servlet, request, user, indexName, urlResource, urlPathPart);
    }

    @Override
    public int handle(DataStream ds) throws BlsException, InvalidQuery {
        WebserviceRequestHandler.opHits(params, ds);
//        ResultHitsGrouped hitsGrouped = WebserviceOperations.hitsGrouped(params);
//        DStream.hitsGroupedResponse(ds, hitsGrouped);
        return HTTP_OK;
    }

}
