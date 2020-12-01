package com.web.petdoctor.repository;

import com.web.petdoctor.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,String> {

    Doctor findByDoctorNicknameAndDoctorPassword(String nickname,String password);
}
