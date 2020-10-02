package com.web.petdoctor.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

/**
 * @ClassName : Pet
 * @Description :
 * @Author : lixin
 * @Date: 2020-10-01 22:10
 */
@Entity
@Table(name = "t_pet", schema = "db_pet", catalog = "")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Pet {
    private String petId;
    private String petName;
    private String petCategory;
    private String petIcon;

    @Id
    @GeneratedValue(generator = "jpa-uuid")
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
    @Column(name = "pet_category")
    public String getPetCategory() {
        return petCategory;
    }

    public void setPetCategory(String petCategory) {
        this.petCategory = petCategory;
    }

    @Basic
    @Column(name = "pet_icon")
    public String getPetIcon() {
        return petIcon;
    }

    public void setPetIcon(String petIcon) {
        this.petIcon = petIcon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Objects.equals(petId, pet.petId) &&
                Objects.equals(petName, pet.petName) &&
                Objects.equals(petCategory, pet.petCategory) &&
                Objects.equals(petIcon, pet.petIcon);
    }

    @Override
    public int hashCode() {

        return Objects.hash(petId, petName, petCategory, petIcon);
    }
}
