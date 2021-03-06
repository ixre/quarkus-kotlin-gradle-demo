package net.fze.mzl.board.resources

import com.line.arch.commons.std.Result
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
    @Path("/{id}")
    fun hello(@PathParam("id") id:Int): CusFollowLogEntity? {
        return service.findByIdOrNull(id)
    }

    @GET
    fun list(): Set<CusFollowLogEntity> {
        return mutableSetOf()
    }

    @POST
    fun add(entity: CusFollowLogEntity):Result {
        val err = this.service.saveCusFollowLog(entity)
        if(err != null)return Result.create(1,err.message)
        return Result.OK
    }

    @DELETE
    @Path("/{id}")
    fun delete(@PathParam("id") id:Int):Result {
        val err = this.service.deleteById(id)
        if(err != null)return Result.create(1,err.message)
        return Result.OK
    }
}