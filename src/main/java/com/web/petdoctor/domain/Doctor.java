package com.web.petdoctor.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

/**
 * @ClassName : Doctor
 * @Description :
 * @Author : lixin
 * @Date: 2020-10-01 22:10
 */
@Entity
@Table(name = "t_doctor", schema = "db_pet", catalog = "")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Doctor {
    private String doctorId;
    private String doctorDescription;
    private String doctorGender;
    private String doctorIcon;
    private String doctorNickname;
    private String doctorPassword;
    private String doctorRealname;
    private String doctorTitle;
    private String lawyerField;

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(name = "doctor_id")
    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    @Basic
    @Column(name = "doctor_description")
    public String getDoctorDescription() {
        return doctorDescription;
    }

    public void setDoctorDescription(String doctorDescription) {
        this.doctorDescription = doctorDescription;
    }

    @Basic
    @Column(name = "doctor_gender")
    public String getDoctorGender() {
        return doctorGender;
    }

    public void setDoctorGender(String doctorGender) {
        this.doctorGender = doctorGender;
    }

    @Basic
    @Column(name = "doctor_icon")
    public String getDoctorIcon() {
        return doctorIcon;
    }

    public void setDoctorIcon(String doctorIcon) {
        this.doctorIcon = doctorIcon;
    }

    @Basic
    @Column(name = "doctor_nickname")
    public String getDoctorNickname() {
        return doctorNickname;
    }

    public void setDoctorNickname(String doctorNickname) {
        this.doctorNickname = doctorNickname;
    }

    @Basic
    @Column(name = "doctor_password")
    public String getDoctorPassword() {
        return doctorPassword;
    }

    public void setDoctorPassword(String doctorPassword) {
        this.doctorPassword = doctorPassword;
    }

    @Basic
    @Column(name = "doctor_realname")
    public String getDoctorRealname() {
        return doctorRealname;
    }

    public void setDoctorRealname(String doctorRealname) {
        this.doctorRealname = doctorRealname;
    }

    @Basic
    @Column(name = "doctor_title")
    public String getDoctorTitle() {
        return doctorTitle;
    }

    public void setDoctorTitle(String doctorTitle) {
        this.doctorTitle = doctorTitle;
    }

    @Basic
    @Column(name = "lawyer_field")
    public String getLawyerField() {
        return lawyerField;
    }

    public void setLawyerField(String lawyerField) {
        this.lawyerField = lawyerField;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return Objects.equals(doctorId, doctor.doctorId) &&
                Objects.equals(doctorDescription, doctor.doctorDescription) &&
                Objects.equals(doctorGender, doctor.doctorGender) &&
                Objects.equals(doctorIcon, doctor.doctorIcon) &&
                Objects.equals(doctorNickname, doctor.doctorNickname) &&
                Objects.equals(doctorPassword, doctor.doctorPassword) &&
                Objects.equals(doctorRealname, doctor.doctorRealname) &&
                Objects.equals(doctorTitle, doctor.doctorTitle) &&
                Objects.equals(lawyerField, doctor.lawyerField);
    }

    @Override
    public int hashCode() {

        return Objects.hash(doctorId, doctorDescription, doctorGender, doctorIcon, doctorNickname, doctorPassword, doctorRealname, doctorTitle, lawyerField);
    }
}
