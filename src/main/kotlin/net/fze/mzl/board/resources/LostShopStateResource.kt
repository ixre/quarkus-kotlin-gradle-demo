/**
 * this file is auto generated by tto v1.3.11 !
 * if you want to modify this code,please read guide doc
 * and modify code template later.
 *
 * guide please see https://github.com/fzen/tto
 *
 */
package net.fze.mzl.board.resources

import net.fze.mzl.board.pojo.LostShopStateEntity
import net.fze.mzl.board.service.LostShopStateService
import com.line.arch.commons.std.Result
import javax.inject.Inject
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

/* 流失店铺状态表资源 */
@Path("/lost_shop_state")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class LostShopStateResource {
    @Inject
    private lateinit var service:LostShopStateService

    @GET
    @Path("/{id}")
    fun get(@PathParam("id") id:Int): LostShopStateEntity? {
        return service.findByIdOrNull(id)
    }

    @GET
    fun list(): Set<LostShopStateEntity> {
        return mutableSetOf()
    }

    @POST
    fun save(entity: LostShopStateEntity):Result {
        val err = this.service.saveLostShopState(entity)
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