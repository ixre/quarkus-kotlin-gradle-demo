package net.fze.mzl.board.Resources

import org.eclipse.microprofile.config.inject.ConfigProperty
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
@Path("/hello")
class HelloResource {
    @ConfigProperty(name = "database.driver_url")
    private  var jdbcURL :String =""
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun hello(): String? {
        return "hello world -> $jdbcURL"
    }
}