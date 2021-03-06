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

package net.fze.mzl.board.pojo;

import javax.persistence.Basic;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;

/** »Ø·Ã¿Í»§±í */
@Entity
@Table(name = "follow_cus", schema = "")
public class FollowCusEntity {

    private Long id;
    public void setId(Long id){
        this.id = id;
    }

    /** ÎïÀíÖ÷¼ü */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" ,length = 11)
    public Long getId() {
        return this.id;
    }

    private String cus_name;
    public void setCusName(String cus_name){
        this.cus_name = cus_name;
    }

    /** ¿Í»§Ãû×Ö */
    @Basic
    @Column(name = "cus_name" ,length = 32)
    public String getCusName() {
        return this.cus_name;
    }

    private String cus_phone;
    public void setCusPhone(String cus_phone){
        this.cus_phone = cus_phone;
    }

    /** ¿Í»§ÊÖ»úºÅ */
    @Basic
    @Column(name = "cus_phone" ,length = 15)
    public String getCusPhone() {
        return this.cus_phone;
    }

    private Long cus_source;
    public void setCusSource(Long cus_source){
        this.cus_source = cus_source;
    }

    /** ¿Í»§À´Ô´ */
    @Basic
    @Column(name = "cus_source" ,length = 11)
    public Long getCusSource() {
        return this.cus_source;
    }

    private Long created_time;
    public void setCreatedTime(Long created_time){
        this.created_time = created_time;
    }

    /** ´´½¨Ê±¼ä */
    @Basic
    @Column(name = "created_time" ,length = 11)
    public Long getCreatedTime() {
        return this.created_time;
    }

    private Long first_visit_time;
    public void setFirstVisitTime(Long first_visit_time){
        this.first_visit_time = first_visit_time;
    }

    /** Ê×´Î»Ø·ÃÊ±¼ä */
    @Basic
    @Column(name = "first_visit_time" ,length = 11)
    public Long getFirstVisitTime() {
        return this.first_visit_time;
    }

    private String site_id;
    public void setSiteId(String site_id){
        this.site_id = site_id;
    }

    /**  */
    @Basic
    @Column(name = "site_id" ,length = 32)
    public String getSiteId() {
        return this.site_id;
    }

    private String client_ip;
    public void setClientIp(String client_ip){
        this.client_ip = client_ip;
    }

    /** ip地址 */
    @Basic
    @Column(name = "client_ip" ,length = 64)
    public String getClientIp() {
        return this.client_ip;
    }

    private String device_os;
    public void setDeviceOs(String device_os){
        this.device_os = device_os;
    }

    /** 访问形式 */
    @Basic
    @Column(name = "device_os" ,length = 64)
    public String getDeviceOs() {
        return this.device_os;
    }

    private String referer;
    public void setReferer(String referer){
        this.referer = referer;
    }

    /** 来源主机 */
    @Basic
    @Column(name = "referer", nullable = true ,length = 120)
    public String getReferer() {
        return this.referer;
    }

    private String user_from;
    public void setUserFrom(String user_from){
        this.user_from = user_from;
    }

    /**  */
    @Basic
    @Column(name = "user_from" ,length = 64)
    public String getUserFrom() {
        return this.user_from;
    }

    private String user_district;
    public void setUserDistrict(String user_district){
        this.user_district = user_district;
    }

    /** 地址 */
    @Basic
    @Column(name = "user_district" ,length = 64)
    public String getUserDistrict() {
        return this.user_district;
    }

    private String user_place;
    public void setUserPlace(String user_place){
        this.user_place = user_place;
    }

    /** 具体地址 */
    @Basic
    @Column(name = "user_place" ,length = 256)
    public String getUserPlace() {
        return this.user_place;
    }

    /** 拷贝数据  */
    public FollowCusEntity copy(FollowCusEntity src){
        FollowCusEntity dst = new FollowCusEntity();

        dst.setId(src.getId());
        dst.setCusName(src.getCusName());
        dst.setCusPhone(src.getCusPhone());
        dst.setCusSource(src.getCusSource());
        dst.setCreatedTime(src.getCreatedTime());
        dst.setFirstVisitTime(src.getFirstVisitTime());
        dst.setSiteId(src.getSiteId());
        dst.setClientIp(src.getClientIp());
        dst.setDeviceOs(src.getDeviceOs());
        dst.setReferer(src.getReferer());
        dst.setUserFrom(src.getUserFrom());
        dst.setUserDistrict(src.getUserDistrict());
        dst.setUserPlace(src.getUserPlace());
        return dst;
    }
}
