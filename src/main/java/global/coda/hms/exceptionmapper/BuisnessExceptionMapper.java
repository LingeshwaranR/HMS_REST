package global.coda.hms.exceptionmapper;


import global.coda.hms.exception.BuisnessException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * The type System exception mapper.
 */
@Provider
public class BuisnessExceptionMapper implements ExceptionMapper<BuisnessException> {
    /**
     * The Logger.
     */
    private Logger LOGGER = LogManager.getLogger(BuisnessExceptionMapper.class);

    //FIX CHECKSTYLE
    /**
     * @param exception
     * @return
     */
    @Override
    public Response toResponse(BuisnessException exception) {


        return Response.status(Response.Status.BAD_REQUEST).type(MediaType.TEXT_PLAIN).entity(exception.getMessage()).build();
    }
}
