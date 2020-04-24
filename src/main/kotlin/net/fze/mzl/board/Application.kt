package net.fze.mzl.board

import io.quarkus.runtime.StartupEvent
import io.quarkus.runtime.configuration.ProfileManager
import org.eclipse.microprofile.config.ConfigProvider
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.event.Observes


@ApplicationScoped
class Application {
    fun onStart(@Observes event: StartupEvent?) {
        println("app started..")
    }
}