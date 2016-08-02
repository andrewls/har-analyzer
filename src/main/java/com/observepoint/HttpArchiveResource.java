package com.observepoint;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("http-archive")
public class HttpArchiveResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response analyze(HttpArchive har) {
        if (har != null) {
            return Response.ok(har.analyze()).build();
        }
        return Response.ok("{\"message\": \"You must provide a valid har file to analyze.\"").build();
    }
}
