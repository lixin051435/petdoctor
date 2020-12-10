package com.web.petdoctor.repository;

import com.web.petdoctor.domain.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,String> {

    Page<Order> findAllByRealname(String userRealname, Pageable pageable);

    List<Order> findAllByUserIdAndOrderstatus(String userId, Integer orderstatus);

    List<Order> findAllByDoctorId(String doctorId);

    List<Order> findAllByDoctorIdAndOrderstatusOrderByOrdertime(String doctorId,Integer orderstatus);



}
