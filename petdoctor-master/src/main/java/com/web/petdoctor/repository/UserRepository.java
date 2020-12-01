package com.web.petdoctor.repository;

import com.web.petdoctor.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

    User findByUserNicknameAndUserPassword(String nickname,String password);

    List<User> findAllByUserIdIn(List<String> userIds);
}
