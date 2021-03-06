/**
 * this file is auto generated by tto v1.3.11 !
 * if you want to modify this code,please read guide doc
 * and modify code template later.
 *
 * guide please see https://github.com/fzen/tto
 *
 */
package net.fze.mzl.board.resources

import net.fze.mzl.board.pojo.HelpMenuEntity
import net.fze.mzl.board.service.HelpMenuService
import com.line.arch.commons.std.Result
import javax.inject.Inject
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

/* 帮助中心菜单资源 */
@Path("/help_menu")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class HelpMenuResource {
    @Inject
    private lateinit var service:HelpMenuService

    @GET
    @Path("/{id}")
    fun get(@PathParam("id") id:Int): HelpMenuEntity? {
        return service.findByIdOrNull(id)
    }

    @GET
    fun list(): Set<HelpMenuEntity> {
        return mutableSetOf()
    }

    @POST
    fun save(entity: HelpMenuEntity):Result {
        val err = this.service.saveHelpMenu(entity)
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