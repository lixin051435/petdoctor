package com.web.petdoctor.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "t_chat", schema = "db_pet", catalog = "")
public class Chat {
    private String chatId;
    private String doctorId;
    private String userId;
    private Integer senderType;
    private Integer receiverType;

    private String message;

    @CreatedDate
    private Date createtime;

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(name = "chat_id")
    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    @Basic
    @Column(name = "message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
    @Column(name = "user_id")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "sender_type")
    public Integer getSenderType() {
        return senderType;
    }

    public void setSenderType(Integer senderType) {
        this.senderType = senderType;
    }

    @Basic
    @Column(name = "receiver_type")
    public Integer getReceiverType() {
        return receiverType;
    }

    public void setReceiverType(Integer receiverType) {
        this.receiverType = receiverType;
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
        Chat chat = (Chat) o;
        return Objects.equals(chatId, chat.chatId) &&
                Objects.equals(doctorId, chat.doctorId) &&
                Objects.equals(userId, chat.userId) &&
                Objects.equals(senderType, chat.senderType) &&
                Objects.equals(receiverType, chat.receiverType) &&
                Objects.equals(createtime, chat.createtime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chatId, doctorId, userId, senderType, receiverType, createtime);
    }
}
