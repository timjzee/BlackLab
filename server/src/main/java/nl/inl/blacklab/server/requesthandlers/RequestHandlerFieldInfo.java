package nl.inl.blacklab.server.requesthandlers;

import nl.inl.blacklab.server.datastream.DataStream;
import nl.inl.blacklab.server.exceptions.BadRequest;
import nl.inl.blacklab.server.exceptions.BlsException;
import nl.inl.blacklab.server.lib.WebserviceOperation;
import nl.inl.blacklab.server.lib.results.WebserviceRequestHandler;

/**
 * Get information about a field in the index.
 */
public class RequestHandlerFieldInfo extends RequestHandler {

    public RequestHandlerFieldInfo(UserRequestBls userRequest) {
        super(userRequest, WebserviceOperation.FIELD_INFO);
    }

    @Override
    public boolean isCacheAllowed() {
        return false; // Because reindexing might change something
    }

    @Override
    public int handle(DataStream ds) throws BlsException {
        int i = urlPathInfo.indexOf('/');
        String fieldName = i >= 0 ? urlPathInfo.substring(0, i) : urlPathInfo;
        if (fieldName.length() == 0) {
            throw new BadRequest("UNKNOWN_OPERATION",
                    "Bad URL. Either specify a field name to show information about, or remove the 'fields' part to get general index information.");
        }
        params.setFieldName(fieldName);

        WebserviceRequestHandler.opFieldInfo(params, ds);

        // Remove any empty settings
        //response.removeEmptyMapValues();

        return HTTP_OK;
    }

}
