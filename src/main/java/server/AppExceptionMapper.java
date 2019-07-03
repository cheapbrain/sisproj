package server;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class AppExceptionMapper implements ExceptionMapper<Exception> {

    public Response toResponse(Exception e) {    	
    	e.printStackTrace();
    	
        return Response
		        .status(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode())
		        .type(MediaType.TEXT_PLAIN)
		        .entity("Catching in ApplicaitonExceptionMapper : " + e.getMessage())
		        .build();
    }
}
