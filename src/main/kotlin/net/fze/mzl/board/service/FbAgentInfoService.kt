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

import net.fze.mzl.board.pojo.FbAgentInfoEntity
import net.fze.mzl.board.repo.FbAgentInfoJpaRepository
import javax.inject.Inject
import javax.enterprise.inject.Default
import javax.enterprise.context.ApplicationScoped
import com.line.arch.commons.std.catch
import com.line.arch.commons.std.TypesConv

/** 代理回访表服务  */
@ApplicationScoped
class FbAgentInfoService {
    @Inject@field:Default
    lateinit var repo: FbAgentInfoJpaRepository

    fun parseId(id:Any):Long{return TypesConv.toLong(id)}

    // 根据ID查找代理回访表
    fun findByIdOrNull(id:Int):FbAgentInfoEntity?{
        return this.repo.findById(this.parseId(id))
    }

    // 保存代理回访表
    fun saveFbAgentInfo(e: FbAgentInfoEntity):Error? {
        return catch {
            var dst: FbAgentInfoEntity
            if (e.id > 0) {
                dst = this.repo.findById(this.parseId(e.id))!!
            } else {
                dst = FbAgentInfoEntity()
            }

            dst.id = e.id
            dst.personName = e.personName
            dst.personPhone = e.personPhone
            dst.requestArea = e.requestArea
            dst.firstCallTime = e.firstCallTime
            dst.clientIp = e.clientIp
            dst.referer = e.referer
            dst.deviceOs = e.deviceOs
            dst.userFrom = e.userFrom
            dst.userDistrict = e.userDistrict
            dst.userPlace = e.userPlace
            dst.remark = e.remark
            dst.createdTime = e.createdTime
            this.repo.persist(dst)
            null
        }.error()
    }

    // 批量保存代理回访表
    fun saveAllFbAgentInfo(entities:Iterable<FbAgentInfoEntity>){
        return this.repo.persist(entities)
    }

    // 删除代理回访表
    fun deleteById(id:Int):Error? {
        return catch {
            this.repo.deleteById(this.parseId(id))
        }.error()
    }

}
