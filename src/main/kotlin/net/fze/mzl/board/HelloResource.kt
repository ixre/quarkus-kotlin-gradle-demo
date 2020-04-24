package net.fze.mzl.board

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
@Path("/hello")
class HelloResource {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun hello(): String? {
        return "hello world"
    }
}