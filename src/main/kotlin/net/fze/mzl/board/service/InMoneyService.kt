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

import net.fze.mzl.board.pojo.InMoneyEntity
import net.fze.mzl.board.repo.InMoneyJpaRepository
import javax.inject.Inject
import javax.enterprise.inject.Default
import javax.enterprise.context.ApplicationScoped
import com.line.arch.commons.std.catch
import com.line.arch.commons.std.TypesConv

/** 进账表服务  */
@ApplicationScoped
class InMoneyService {
    @Inject@field:Default
    lateinit var repo: InMoneyJpaRepository

    fun parseId(id:Any):Long{return TypesConv.toLong(id)}

    // 根据ID查找进账表
    fun findByIdOrNull(id:Int):InMoneyEntity?{
        return this.repo.findById(this.parseId(id))
    }

    // 保存进账表
    fun saveInMoney(e: InMoneyEntity):Error? {
        return catch {
            var dst: InMoneyEntity
            if (e.id > 0) {
                dst = this.repo.findById(this.parseId(e.id))!!
            } else {
                dst = InMoneyEntity()
            }

            dst.id = e.id
            dst.scanIncome = e.scanIncome
            dst.thirdBill = e.thirdBill
            dst.poundage = e.poundage
            dst.feeRate = e.feeRate
            dst.checkMoney = e.checkMoney
            dst.state = e.state
            dst.operator = e.operator
            dst.opId = e.opId
            dst.inTime = e.inTime
            dst.createTime = e.createTime
            dst.updateTime = e.updateTime
            this.repo.persist(dst)
            null
        }.error()
    }

    // 批量保存进账表
    fun saveAllInMoney(entities:Iterable<InMoneyEntity>){
        return this.repo.persist(entities)
    }

    // 删除进账表
    fun deleteById(id:Int):Error? {
        return catch {
            this.repo.deleteById(this.parseId(id))
        }.error()
    }

}