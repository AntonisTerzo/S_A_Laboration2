package filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.annotation.Priority;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;

@Provider
@Priority(2000)
public class Logging_Req_ResFilter implements ContainerRequestFilter, ContainerResponseFilter{

    private static final Logger logger = LoggerFactory.getLogger(Logging_Req_ResFilter.class);

    @Override
    public void filter(ContainerRequestContext requestContext) {
        logger.info("Incoming request - Method: {}, URI: {}", 
        requestContext.getMethod(),
        requestContext.getUriInfo().getRequestUri());
    }

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) {
        logger.info("Outgoing response - Method: {}, URI: {}, Status: {}",
        requestContext.getMethod(),
        requestContext.getUriInfo().getRequestUri(),
        responseContext.getStatus());
    }
}
