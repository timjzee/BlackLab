package nl.inl.blacklab.server.requesthandlers;

import nl.inl.blacklab.server.datastream.DataStream;
import nl.inl.blacklab.server.exceptions.BlsException;
import nl.inl.blacklab.server.lib.WebserviceOperation;
import nl.inl.blacklab.server.lib.results.WebserviceRequestHandler;

/**
 * Get information about the structure of an index.
 */
public class RequestHandlerIndexMetadata extends RequestHandler {

    public RequestHandlerIndexMetadata(UserRequestBls userRequest) {
        super(userRequest, WebserviceOperation.CORPUS_INFO);
    }

    @Override
    public boolean isCacheAllowed() {
        return false; // because status might change (or you might reindex)
    }

    @Override
    public int handle(DataStream ds) throws BlsException {
        WebserviceRequestHandler.opCorpusInfo(params, ds);
        return HTTP_OK;
    }

}
