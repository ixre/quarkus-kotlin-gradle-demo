package net.fze.mzl.board.Resources

import com.google.inject.Inject
import io.agroal.api.AgroalDataSource
import org.eclipse.microprofile.config.inject.ConfigProperty
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
@Path("/hello")
class HelloResource {
    @ConfigProperty(name = "quarkus.datasource.jdbc.url")
    private  var jdbcURL :String =""
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun hello(): String? {
        return "jdbc url is: $jdbcURL"
    }

    @Inject
    private  var ds:AgroalDataSource? = null

    @GET
    @Path("test_db")
    fun testDb():Int {
        val conn = ds!!.connection
        val stmt = conn.prepareStatement("SELECT 1")
        val query = stmt.executeQuery()
        val ret = query.getInt(0)
        query.close()
        stmt.close()
        conn.close()
        return ret
    }
}