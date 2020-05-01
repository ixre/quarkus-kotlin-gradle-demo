package net.fze.mzl.board.resources

import com.line.arch.commons.std.Typed
import net.fze.mzl.board.models.vue.UserModel
import org.eclipse.microprofile.jwt.JsonWebToken
import javax.annotation.security.PermitAll
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
@RequestScoped // 添加注解
class UsersResource {
    @Inject
    @field:Default
    lateinit var jwt: JsonWebToken // 注入jwt

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun login(entity: Map<String, String>): Map<String, String> {
        return mutableMapOf("accessToken" to Typed.encoder.md5("12346".toByteArray()));
    }

    @POST
    @Path("/info")
    @PermitAll
    fun info(@Context ctx: SecurityContext):UserModel {
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
        return user
    }
}

