/**
 * this file is auto generated by TTO-CodeGenerator v1.3.10 !
 * if you want to modify this code,please read guide doc
 * and modify code template later.
 *
 * guide please see https://github.com/ixre/tto
 *
 */

package net.fze.mzl.board.service

import net.fze.mzl.board.pojo.CusFollowLogEntity
import net.fze.mzl.board.repo.CusFollowLogJpaRepository
import com.google.inject.Inject
import javax.enterprise.context.ApplicationScoped
import com.line.arch.commons.std.catch
import com.line.arch.commons.std.TypesConv

/** ¿Í»§»Ø·Ã¼ÇÂ¼服务  */
@ApplicationScoped
class CusFollowLogService {
    @Inject
    lateinit var repo: CusFollowLogJpaRepository

    fun parseId(id:Int):Long{return TypesConv.toLong(id)}

    // 根据ID查找¿Í»§»Ø·Ã¼ÇÂ¼
    fun findByIdOrNull(id:Int):CusFollowLogEntity?{
        return this.repo.findById(this.parseId(id))
    }

    // 保存¿Í»§»Ø·Ã¼ÇÂ¼
    fun saveCusFollowLog(e: CusFollowLogEntity):Error? {
        return catch {
            var dst: CusFollowLogEntity
            if (e.id > 0) {
                dst = this.repo.findById(this.parseId(e.id))!!
            } else {
                dst = CusFollowLogEntity()
            }
            dst.id = e.id
            dst.createdTime = e.createdTime
            dst.cusId = e.cusId
            dst.shopType = e.shopType
            dst.followState = e.followState
            dst.employeeNumber = e.employeeNumber
            dst.installationStatus = e.installationStatus
            dst.nextFollowTime = e.nextFollowTime
            dst.demandMod = e.demandMod
            dst.purchaseIntention = e.purchaseIntention
            dst.renarks = e.renarks
            dst.customerName = e.customerName
            dst.customerId = e.customerId
            this.repo.persist(dst)
            null
        }.error()
    }

    // 批量保存¿Í»§»Ø·Ã¼ÇÂ¼
    fun saveAllCusFollowLog(entities:Iterable<CusFollowLogEntity>){
        return this.repo.persist(entities)
    }

    // 删除¿Í»§»Ø·Ã¼ÇÂ¼
    fun deleteById(id:Int) {
         this.repo.deleteById(this.parseId(id))
    }

}