package com.web.petdoctor.repository;

import com.web.petdoctor.domain.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet,String> {

    List<Pet> findAllByUserId(String userId);
}
