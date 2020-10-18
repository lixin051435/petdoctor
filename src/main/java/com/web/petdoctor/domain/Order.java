package com.web.petdoctor.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.web.petdoctor.enums.OrderStatusEnum;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

/**
 * @ClassName : Order
 * @Description :
 * @Author : lixin
 * @Date: 2020-10-04 15:33
 */
@Entity
@Table(name = "t_order", schema = "db_pet", catalog = "")
@EntityListeners(AuditingEntityListener.class)
public class Order {
    private String orderId;
    private String userId;
    private String realname;
    private String gender;
    private String phone;
    private String doctorId;
    private String doctorName;
    private String petId;
    private String petName;
    private String petIcon;
    private String symptom;
    private String solution;
    private String ordertime;

    @CreatedDate
    private Date createtime;
    private Integer orderstatus = OrderStatusEnum.ORDERING.getCode();

    @Basic
    @Column(name = "pet_icon")
    public String getPetIcon() {
        return petIcon;
    }

    public void setPetIcon(String petIcon) {
        this.petIcon = petIcon;
    }

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(name = "order_id")
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "user_id")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "realname")
    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    @Basic
    @Column(name = "gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "doctor_id")
    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    @Basic
    @Column(name = "doctor_name")
    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    @Basic
    @Column(name = "pet_id")
    public String getPetId() {
        return petId;
    }

    public void setPetId(String petId) {
        this.petId = petId;
    }

    @Basic
    @Column(name = "pet_name")
    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    @Basic
    @Column(name = "symptom")
    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    @Basic
    @Column(name = "solution")
    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    @Basic
    @Column(name = "ordertime")
    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime;
    }

    @Basic
    @Column(name = "createtime")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Basic
    @Column(name = "orderstatus")
    public Integer getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(Integer orderstatus) {
        this.orderstatus = orderstatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(orderId, order.orderId) &&
                Objects.equals(userId, order.userId) &&
                Objects.equals(realname, order.realname) &&
                Objects.equals(gender, order.gender) &&
                Objects.equals(phone, order.phone) &&
                Objects.equals(doctorId, order.doctorId) &&
                Objects.equals(doctorName, order.doctorName) &&
                Objects.equals(petId, order.petId) &&
                Objects.equals(petName, order.petName) &&
                Objects.equals(symptom, order.symptom) &&
                Objects.equals(solution, order.solution) &&
                Objects.equals(ordertime, order.ordertime) &&
                Objects.equals(createtime, order.createtime) &&
                Objects.equals(orderstatus, order.orderstatus);
    }

    @Override
    public int hashCode() {

        return Objects.hash(orderId, userId, realname, gender, phone, doctorId, doctorName, petId, petName, symptom, solution, ordertime, createtime, orderstatus);
    }
}
