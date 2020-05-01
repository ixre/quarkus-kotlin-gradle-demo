package net.fze.mzl.board.config

import org.eclipse.microprofile.auth.LoginConfig
import javax.ws.rs.ApplicationPath
import javax.ws.rs.core.Application


@LoginConfig(authMethod = "MP-JWT")
@ApplicationPath("")
class JAXRSConfiguration : Application()