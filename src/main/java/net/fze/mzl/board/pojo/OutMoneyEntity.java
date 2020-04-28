/**
 * this file is auto generated by TTO-CodeGenerator v1.3.10 !
 * if you want to modify this code,please read guide doc
 * and modify code template later.
 *
 * guide please see https://github.com/ixre/tto
 *
 */

package net.fze.mzl.board.pojo;

import javax.persistence.Basic;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;

/** 提现表 */
@Entity
@Table(name = "out_money", schema = "")
public class OutMoneyEntity {

    private int id;
    public void setId(int id){
        this.id = id;
    }

    /**  */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" ,length = 11)
    public int getId() {
        return this.id;
    }

    private Long out_num;
    public void setOutNum(Long out_num){
        this.out_num = out_num;
    }

    /** 提现金额 */
    @Basic
    @Column(name = "out_num", nullable = true ,length = 20)
    public Long getOutNum() {
        return this.out_num;
    }

    private Long third_bill;
    public void setThirdBill(Long third_bill){
        this.third_bill = third_bill;
    }

    /** 第三方出账金额 */
    @Basic
    @Column(name = "third_bill", nullable = true ,length = 20)
    public Long getThirdBill() {
        return this.third_bill;
    }

    private Long poundage;
    public void setPoundage(Long poundage){
        this.poundage = poundage;
    }

    /** 手续费 */
    @Basic
    @Column(name = "poundage", nullable = true ,length = 20)
    public Long getPoundage() {
        return this.poundage;
    }

    private Long fee_rate;
    public void setFeeRate(Long fee_rate){
        this.fee_rate = fee_rate;
    }

    /** 手续费率 */
    @Basic
    @Column(name = "fee_rate", nullable = true ,length = 20)
    public Long getFeeRate() {
        return this.fee_rate;
    }

    private Long check_money;
    public void setCheckMoney(Long check_money){
        this.check_money = check_money;
    }

    /** 核对金额 */
    @Basic
    @Column(name = "check_money", nullable = true ,length = 20)
    public Long getCheckMoney() {
        return this.check_money;
    }

    private int state;
    public void setState(int state){
        this.state = state;
    }

    /** 核对状态:1待核对2正确3错误 */
    @Basic
    @Column(name = "state", nullable = true ,length = 11)
    public int getState() {
        return this.state;
    }

    private String operator;
    public void setOperator(String operator){
        this.operator = operator;
    }

    /** 核对人 */
    @Basic
    @Column(name = "operator", nullable = true ,length = 30)
    public String getOperator() {
        return this.operator;
    }

    private int op_id;
    public void setOpId(int op_id){
        this.op_id = op_id;
    }

    /** 核对人id */
    @Basic
    @Column(name = "op_id", nullable = true ,length = 11)
    public int getOpId() {
        return this.op_id;
    }

    private int out_time;
    public void setOutTime(int out_time){
        this.out_time = out_time;
    }

    /** 提现日期 */
    @Basic
    @Column(name = "out_time", nullable = true ,length = 11)
    public int getOutTime() {
        return this.out_time;
    }

    private int create_time;
    public void setCreateTime(int create_time){
        this.create_time = create_time;
    }

    /**  */
    @Basic
    @Column(name = "create_time", nullable = true ,length = 11)
    public int getCreateTime() {
        return this.create_time;
    }

    private int update_time;
    public void setUpdateTime(int update_time){
        this.update_time = update_time;
    }

    /**  */
    @Basic
    @Column(name = "update_time", nullable = true ,length = 11)
    public int getUpdateTime() {
        return this.update_time;
    }

    /** 拷贝数据  */
    public OutMoneyEntity copy(OutMoneyEntity src){
        OutMoneyEntity dst = new OutMoneyEntity();

        dst.setId(src.getId());
        dst.setOutNum(src.getOutNum());
        dst.setThirdBill(src.getThirdBill());
        dst.setPoundage(src.getPoundage());
        dst.setFeeRate(src.getFeeRate());
        dst.setCheckMoney(src.getCheckMoney());
        dst.setState(src.getState());
        dst.setOperator(src.getOperator());
        dst.setOpId(src.getOpId());
        dst.setOutTime(src.getOutTime());
        dst.setCreateTime(src.getCreateTime());
        dst.setUpdateTime(src.getUpdateTime());
        return dst;
    }
}
