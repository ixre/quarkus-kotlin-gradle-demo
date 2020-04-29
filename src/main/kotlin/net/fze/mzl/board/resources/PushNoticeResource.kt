/**
 * this file is auto generated by tto v1.3.11 !
 * if you want to modify this code,please read guide doc
 * and modify code template later.
 *
 * guide please see https://github.com/fzen/tto
 *
 */
package net.fze.mzl.board.resources

import net.fze.mzl.board.pojo.PushNoticeEntity
import net.fze.mzl.board.service.PushNoticeService
import com.line.arch.commons.std.Result
import javax.inject.Inject
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

/* 消息推送表资源 */
@Path("/push_notice")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class PushNoticeResource {
    @Inject
    private lateinit var service:PushNoticeService

    @GET
    @Path("/{id}")
    fun get(@PathParam("id") id:Int): PushNoticeEntity? {
        return service.findByIdOrNull(id)
    }

    @GET
    fun list(): Set<PushNoticeEntity> {
        return mutableSetOf()
    }

    @POST
    fun save(entity: PushNoticeEntity):Result {
        val err = this.service.savePushNotice(entity)
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