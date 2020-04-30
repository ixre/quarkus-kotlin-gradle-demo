package net.fze.mzl.board.resources

import com.line.arch.commons.std.Typed
import org.eclipse.microprofile.jwt.JsonWebToken
import javax.annotation.security.PermitAll
import javax.enterprise.context.RequestScoped
import javax.inject.Inject
import javax.ws.rs.Consumes
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.Context
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.SecurityContext


@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped // 添加注解
class UserResource {
    @Inject lateinit var jwt: JsonWebToken // 注入jwt

    @POST
    @Path("/login")
    fun login(entity: Map<String,String>):Map<String,String> {
        return mutableMapOf("accessToken" to Typed.encoder.md5("12346".toByteArray()));
    }

    @POST
    @Path("/info")
    @PermitAll
    fun info(@Context ctx: SecurityContext):Map<String,String>{
        val name = ctx.userPrincipal?.name?:"" // 获取值
        val hasJwt = jwt.claimNames != null    // 是否包含jwt
        val map = mutableMapOf<String,String>()
        map["name"] = name
        map["username"] = "jarrysix"
        map["jwt"] = hasJwt.toString()
        return map
    }

}