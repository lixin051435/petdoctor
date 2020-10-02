package com.web.petdoctor.repository;

import com.web.petdoctor.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin,String> {

    Admin findByAdminNicknameAndAdminPassword(String nickname,String password);
}
