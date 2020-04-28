#target!kotlin/{{.global.Pkg}}/resources/{{.table.Title}}Resource.kt.gen
package {{pkg "java" .global.Pkg}}.resources

import {{pkg "java" .global.Pkg}}.pojo.{{.table.Title}}Entity
import {{pkg "java" .global.Pkg}}.service.{{.table.Title}}Service
import com.line.arch.commons.std.Result
import javax.inject.Inject
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

{{$tableTitle := .table.Title}}

/* {{.table.Comment}}资源 */
@Path("/{{.table.Name}}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class {{.table.Title}}Resource {
    @Inject
    private lateinit var service:{{.table.Title}}Service

    @GET
    @Path("/{id}")
    fun get(@PathParam("id") id:Int): {{.table.Title}}Entity? {
        return service.findByIdOrNull(id)
    }

    @GET
    fun list(): Set<{{.table.Title}}Entity> {
        return mutableSetOf()
    }

    @POST
    fun save(entity: {{.table.Title}}Entity):Result {
        val err = this.service.save{{.table.Title}}(entity)
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