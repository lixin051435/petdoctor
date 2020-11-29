package com.web.petdoctor.repository;

import com.web.petdoctor.domain.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatRepository extends JpaRepository<Chat,String> {

    List<Chat> findAllByUserIdAndDoctorIdOrderByCreatetime(String userId, String doctorId);

    List<Chat> findAllByDoctorIdOrderByCreatetimeDesc(String doctorId);
}
