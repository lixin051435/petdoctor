package com.web.petdoctor.repository;

import com.web.petdoctor.domain.Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoRepository extends JpaRepository<Info,String> {
}
