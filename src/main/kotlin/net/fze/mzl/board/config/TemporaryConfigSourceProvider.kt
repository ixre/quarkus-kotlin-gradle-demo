package net.fze.mzl.board.config

import io.quarkus.runtime.configuration.ApplicationPropertiesConfigSource
import org.eclipse.microprofile.config.spi.ConfigSource
import org.eclipse.microprofile.config.spi.ConfigSourceProvider

class TemporaryConfigSourceProvider : ConfigSourceProvider {
    override fun getConfigSources(forClassLoader: ClassLoader): Iterable<ConfigSource> {
        return listOf(
                ApplicationPropertiesConfigSource.InJar(),
                ApplicationPropertiesConfigSource.InFileSystem())
    }
}