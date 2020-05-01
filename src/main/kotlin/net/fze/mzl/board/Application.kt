package net.fze.mzl.board

import io.quarkus.runtime.StartupEvent
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.event.Observes
import javax.ws.rs.ApplicationPath
import javax.ws.rs.core.Application


@ApplicationScoped
@ApplicationPath("/")
class Application: Application() {
    fun onStart(@Observes event: StartupEvent?) {
        println("app started..")
    }
}