package com.web.petdoctor.vo;

/**
 * @ClassName : PetVO
 * @Description :
 * @Author : lixin
 * @Date: 2020-10-04 21:08
 */
public class PetVO {

    private String petId;
    private String petName;
    private String petCategory;
    private String petIcon;
    private String userId;

    public String getPetId() {
        return petId;
    }

    public void setPetId(String petId) {
        this.petId = petId;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getPetCategory() {
        return petCategory;
    }

    public void setPetCategory(String petCategory) {
        this.petCategory = petCategory;
    }

    public String getPetIcon() {
        return petIcon;
    }

    public void setPetIcon(String petIcon) {
        this.petIcon = petIcon;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
