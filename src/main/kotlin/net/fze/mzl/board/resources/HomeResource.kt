package net.fze.mzl.board.resources

import java.net.URI
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.core.Response

@Path("/")
class HomeResource {
   @GET
   fun home():Response {
        return Response.status(302)
                .header("Location", "/app/")
                .build()
    }
}