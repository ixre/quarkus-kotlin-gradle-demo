package net.fze.mzl.board.resources

import net.fze.mzl.board.pojo.CusFollowLogEntity
import net.fze.mzl.board.service.CusFollowLogService
import javax.inject.Inject
import javax.ws.rs.*
import javax.ws.rs.core.MediaType


@Path("/cus")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class CusFlowResource {
    @Inject
    lateinit var service:CusFollowLogService
    @GET
    @Path("/get/{id}")
    fun hello(@PathParam("id") id:Int): CusFollowLogEntity? {
        val e = this.service.findByIdOrNull(id)
        return e
    }
}