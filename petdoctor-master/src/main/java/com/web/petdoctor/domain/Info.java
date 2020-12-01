package com.web.petdoctor.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Date;
/**
 * @ClassName : Info
 * @Description :
 * @Author : lixin
 * @Date: 2020-10-01 22:10
 */
@Entity
@Table(name = "t_info", schema = "db_pet", catalog = "")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
@EntityListeners(AuditingEntityListener.class)
public class Info {
    private String infoId;
    private String infoTitle;
    private String infoType;
    private String infoContent;
    private String infoIcon;

    @CreatedDate
    private Date createtime;

    @Basic
    @Column(name = "info_icon")
    public String getInfoIcon() {
        return infoIcon;
    }

    public void setInfoIcon(String infoIcon) {
        this.infoIcon = infoIcon;
    }

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(name = "info_id")
    public String getInfoId() {
        return infoId;
    }

    public void setInfoId(String infoId) {
        this.infoId = infoId;
    }

    @Basic
    @Column(name = "info_title")
    public String getInfoTitle() {
        return infoTitle;
    }

    public void setInfoTitle(String infoTitle) {
        this.infoTitle = infoTitle;
    }

    @Basic
    @Column(name = "info_type")
    public String getInfoType() {
        return infoType;
    }

    public void setInfoType(String infoType) {
        this.infoType = infoType;
    }

    @Basic
    @Column(name = "info_content")
    public String getInfoContent() {
        return infoContent;
    }

    public void setInfoContent(String infoContent) {
        this.infoContent = infoContent;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Info info = (Info) o;
        return Objects.equals(infoId, info.infoId) &&
                Objects.equals(infoTitle, info.infoTitle) &&
                Objects.equals(infoType, info.infoType) &&
                Objects.equals(infoContent, info.infoContent) &&
                Objects.equals(createtime, info.createtime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(infoId, infoTitle, infoType, infoContent, createtime);
    }
}
