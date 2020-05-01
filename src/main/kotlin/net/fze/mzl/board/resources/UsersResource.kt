package net.fze.mzl.board.resources

import net.fze.mzl.board.models.vue.UserModel
import net.fze.mzl.board.util.jwt.TokenUtils
import org.eclipse.microprofile.jwt.JsonWebToken
import javax.annotation.security.PermitAll
import javax.annotation.security.RolesAllowed
import javax.enterprise.context.RequestScoped
import javax.enterprise.inject.Default
import javax.inject.Inject
import javax.ws.rs.Consumes
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.Context
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.SecurityContext


@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped // 添加注解
class UsersResource {
    @Inject lateinit var jwt: JsonWebToken // 注入jwt

    @POST
    @Path("/login")
    fun login(entity: Map<String, String>): Map<String, String> {
        val pemPath = "/META-INF/private_key.pem"
        val claims = mutableMapOf<String,Any>()
        claims["iss"] = "https://quarkus.io/using-jwt-rbac"
        claims["upn"] = "user1"
        claims["aud"] = "using-jwt-rbac"
        claims["preferred_username"] = "admin"
        claims["roleMappings"] = mutableMapOf( "group1" to "Group1MappedRole",
        "group2" to "Group2MappedRole")
        claims["groups"] = mutableListOf("Admin","Guest","group2")
        val token = TokenUtils.generateTokenString(pemPath,"",
                claims,1800)
        return mutableMapOf("accessToken" to token);
    }

    @POST
    @Path("/info")
    //@PermitAll
    @RolesAllowed("group2")
    fun info(@Context ctx: SecurityContext):Map<String,Any> {
        val mp = mutableMapOf<String,Any>()
        val user = UserModel()
        user.username = ctx.userPrincipal?.name ?: ""
        user.password = ""
        user.name = "管理员"
        user.avatar = "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif"
        user.introduction = ""
        user.email = ""
        user.phone = ""
        user.roles.add("admin")
        user.roles.add("master")
        mp["user"] = user
        return mp
    }

    @POST
    @Path("/logout")
    fun logout():String{
        return "ok"
    }
}

