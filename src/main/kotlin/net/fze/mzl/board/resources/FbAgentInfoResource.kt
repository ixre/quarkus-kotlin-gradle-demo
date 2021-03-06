/**
 * this file is auto generated by tto v1.3.11 !
 * if you want to modify this code,please read guide doc
 * and modify code template later.
 *
 * guide please see https://github.com/fzen/tto
 *
 */
package net.fze.mzl.board.resources

import net.fze.mzl.board.pojo.FbAgentInfoEntity
import net.fze.mzl.board.service.FbAgentInfoService
import com.line.arch.commons.std.Result
import javax.inject.Inject
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

/* 代理回访表资源 */
@Path("/fb_agent_info")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class FbAgentInfoResource {
    @Inject
    private lateinit var service:FbAgentInfoService

    @GET
    @Path("/{id}")
    fun get(@PathParam("id") id:Int): FbAgentInfoEntity? {
        return service.findByIdOrNull(id)
    }

    @GET
    fun list(): Set<FbAgentInfoEntity> {
        return mutableSetOf()
    }

    @POST
    fun save(entity: FbAgentInfoEntity):Result {
        val err = this.service.saveFbAgentInfo(entity)
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