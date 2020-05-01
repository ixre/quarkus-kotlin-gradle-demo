package net.fze.mzl.board

import io.quarkus.runtime.StartupEvent
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.event.Observes
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.core.Response


@ApplicationScoped
class Application {
    fun onStart(@Observes event: StartupEvent?) {
        println("app started..")
    }
}

@Path("/")
class HomeResource {
    @GET
    fun home(): Response {
        return Response.status(302)
                .header("Location", "/app/index.html")
                .build()
    }
}