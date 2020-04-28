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

/** 需求模块表 */
@Entity
@Table(name = "demand_mod", schema = "")
public class DemandModEntity {

    private int id;
    public void setId(int id){
        this.id = id;
    }

    /** 物理主键 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" ,length = 11)
    public int getId() {
        return this.id;
    }

    private String mod_name;
    public void setModName(String mod_name){
        this.mod_name = mod_name;
    }

    /**  */
    @Basic
    @Column(name = "mod_name" ,length = 64)
    public String getModName() {
        return this.mod_name;
    }

    /** 拷贝数据  */
    public DemandModEntity copy(DemandModEntity src){
        DemandModEntity dst = new DemandModEntity();

        dst.setId(src.getId());
        dst.setModName(src.getModName());
        return dst;
    }
}
