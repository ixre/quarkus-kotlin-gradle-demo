/**
 * this file is auto generated by tto v1.3.11 !
 * if you want to modify this code,please read guide doc
 * and modify code template later.
 *
 * guide please see https://github.com/fzen/tto
 *
 *//**
 * this file is auto generated by TTO-CodeGenerator v1.3.11 !
 * if you want to modify this code,please read guide doc
 * and modify code template later.
 *
 * guide please see https://github.com/ixre/tto
 *
 */

package net.fze.mzl.board.service

import net.fze.mzl.board.pojo.CusSourceEntity
import net.fze.mzl.board.repo.CusSourceJpaRepository
import javax.inject.Inject
import javax.enterprise.inject.Default
import javax.enterprise.context.ApplicationScoped
import com.line.arch.commons.std.catch
import com.line.arch.commons.std.TypesConv

/** 服务  */
@ApplicationScoped
class CusSourceService {
    @Inject@field:Default
    lateinit var repo: CusSourceJpaRepository

    fun parseId(id:Any):Long{return TypesConv.toLong(id)}

    // 根据ID查找
    fun findByIdOrNull(id:Int):CusSourceEntity?{
        return this.repo.findById(this.parseId(id))
    }

    // 保存
    fun saveCusSource(e: CusSourceEntity):Error? {
        return catch {
            var dst: CusSourceEntity
            if (e.id > 0) {
                dst = this.repo.findById(this.parseId(e.id))!!
            } else {
                dst = CusSourceEntity()
            }

            dst.id = e.id
            dst.cusSource = e.cusSource
            dst.code = e.code
            this.repo.persist(dst)
            null
        }.error()
    }

    // 批量保存
    fun saveAllCusSource(entities:Iterable<CusSourceEntity>){
        return this.repo.persist(entities)
    }

    // 删除
    fun deleteById(id:Int):Error? {
        return catch {
            this.repo.deleteById(this.parseId(id))
        }.error()
    }

}