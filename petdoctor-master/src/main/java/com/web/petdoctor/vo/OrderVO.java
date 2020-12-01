package com.web.petdoctor.vo;

/**
 * @ClassName : OrderVO
 * @Description :
 * @Author : lixin
 * @Date: 2020-11-08 19:41
 */
public class OrderVO {
    private String userId;
    private String petId;
    private String doctorId;
    private String symptom;
    private String ordertime;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPetId() {
        return petId;
    }

    public void setPetId(String petId) {
        this.petId = petId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime;
    }
}
