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

import net.fze.mzl.board.pojo.PushNoticeEntity
import net.fze.mzl.board.repo.PushNoticeJpaRepository
import javax.inject.Inject
import javax.enterprise.inject.Default
import javax.enterprise.context.ApplicationScoped
import com.line.arch.commons.std.catch
import com.line.arch.commons.std.TypesConv

/** 消息推送表服务  */
@ApplicationScoped
class PushNoticeService {
    @Inject@field:Default
    lateinit var repo: PushNoticeJpaRepository

    fun parseId(id:Any):Long{return TypesConv.toLong(id)}

    // 根据ID查找消息推送表
    fun findByIdOrNull(id:Int):PushNoticeEntity?{
        return this.repo.findById(this.parseId(id))
    }

    // 保存消息推送表
    fun savePushNotice(e: PushNoticeEntity):Error? {
        return catch {
            var dst: PushNoticeEntity
            if (e.id > 0) {
                dst = this.repo.findById(this.parseId(e.id))!!
            } else {
                dst = PushNoticeEntity()
            }

            dst.id = e.id
            dst.title = e.title
            dst.content = e.content
            dst.channel = e.channel
            dst.bulletScreen = e.bulletScreen
            dst.state = e.state
            dst.optId = e.optId
            dst.optName = e.optName
            dst.beginTime = e.beginTime
            dst.overTime = e.overTime
            dst.createTime = e.createTime
            dst.updateTime = e.updateTime
            this.repo.persist(dst)
            null
        }.error()
    }

    // 批量保存消息推送表
    fun saveAllPushNotice(entities:Iterable<PushNoticeEntity>){
        return this.repo.persist(entities)
    }

    // 删除消息推送表
    fun deleteById(id:Int):Error? {
        return catch {
            this.repo.deleteById(this.parseId(id))
        }.error()
    }

}
