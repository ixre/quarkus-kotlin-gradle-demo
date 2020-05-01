package net.fze.mzl.board.resources

import org.eclipse.microprofile.jwt.Claim
import org.eclipse.microprofile.jwt.Claims
import org.eclipse.microprofile.jwt.JsonWebToken
import java.util.*
import javax.annotation.security.PermitAll
import javax.enterprise.context.RequestScoped
import javax.inject.Inject
import javax.json.JsonString
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.Context
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.SecurityContext

@Path("/user1")
@RequestScoped
 class TokenSecuredResource {
    @Inject
    lateinit var jwt: JsonWebToken

    @GET
    @Path("permit-all")
    @PermitAll
    @Produces(MediaType.TEXT_PLAIN)
    fun hello(@Context ctx: SecurityContext): String? {
        val caller = ctx.userPrincipal
        val name = if (caller == null) "anonymous" else caller.name
        val hasJWT = jwt!!.claimNames != null
        return String.format("hello + %s, isSecure: %s, authScheme: %s, hasJWT: %s", name, ctx.isSecure,
                ctx.authenticationScheme, hasJWT)
    }
}