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

/** 流失店铺状态表 */
@Entity
@Table(name = "lost_shop_state", schema = "")
public class LostShopStateEntity {

    private int id;
    public void setId(int id){
        this.id = id;
    }

    /** 编号 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" ,length = 11)
    public int getId() {
        return this.id;
    }

    private int shop_id;
    public void setShopId(int shop_id){
        this.shop_id = shop_id;
    }

    /** 商铺ID */
    @Basic
    @Column(name = "shop_id" ,length = 11)
    public int getShopId() {
        return this.shop_id;
    }

    private int state;
    public void setState(int state){
        this.state = state;
    }

    /** 状态 */
    @Basic
    @Column(name = "state" ,length = 11)
    public int getState() {
        return this.state;
    }

    private int op_id;
    public void setOpId(int op_id){
        this.op_id = op_id;
    }

    /** 操作人ID */
    @Basic
    @Column(name = "op_id" ,length = 11)
    public int getOpId() {
        return this.op_id;
    }

    private String op_name;
    public void setOpName(String op_name){
        this.op_name = op_name;
    }

    /** 操作人姓名 */
    @Basic
    @Column(name = "op_name" ,length = 16)
    public String getOpName() {
        return this.op_name;
    }

    private int create_time;
    public void setCreateTime(int create_time){
        this.create_time = create_time;
    }

    /** 创建时间 */
    @Basic
    @Column(name = "create_time" ,length = 11)
    public int getCreateTime() {
        return this.create_time;
    }

    /** 拷贝数据  */
    public LostShopStateEntity copy(LostShopStateEntity src){
        LostShopStateEntity dst = new LostShopStateEntity();

        dst.setId(src.getId());
        dst.setShopId(src.getShopId());
        dst.setState(src.getState());
        dst.setOpId(src.getOpId());
        dst.setOpName(src.getOpName());
        dst.setCreateTime(src.getCreateTime());
        return dst;
    }
}
