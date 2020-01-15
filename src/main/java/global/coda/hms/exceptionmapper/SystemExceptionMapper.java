package global.coda.hms.exceptionmapper;


import global.coda.hms.exception.SystemException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * The type System exception mapper.
 */
@Provider
public class SystemExceptionMapper implements ExceptionMapper<SystemException> {
    /**
     * The Logger.
     */

    /**
     *
     * @param exception
     * @return
     */
    @Override
    public Response toResponse(SystemException exception) {
//        if(exception.getCause()== )
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).type(MediaType.TEXT_PLAIN).entity("Something went wrong!!!").build();
    }
}
