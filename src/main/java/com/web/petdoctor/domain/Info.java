package com.web.petdoctor.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @ClassName : Info
 * @Description :
 * @Author : lixin
 * @Date: 2020-10-01 22:10
 */
@Entity
@Table(name = "t_info", schema = "db_pet", catalog = "")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Info {
    private String infoId;
    private String infoTitle;
    private String infoType;
    private String infoContent;
    private Timestamp createtime;

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
    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
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
