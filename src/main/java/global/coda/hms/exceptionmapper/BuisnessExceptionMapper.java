package global.coda.hms.exceptionmapper;


import global.coda.hms.exception.BuisnessException;
import org.apache.log4j.Logger;

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
    private Logger LOGGER = Logger.getLogger(BuisnessExceptionMapper.class);

    /**
     * @param exception
     * @return
     */
    @Override
    public Response toResponse(BuisnessException exception) {
        LOGGER.error(exception);
        return Response.status(Response.Status.BAD_REQUEST).type(MediaType.TEXT_PLAIN).entity("You Entered Wrong Credentials").build();
    }
}
