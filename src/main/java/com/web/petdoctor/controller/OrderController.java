package com.web.petdoctor.controller;

import com.web.petdoctor.domain.*;
import com.web.petdoctor.enums.OrderStatusEnum;
import com.web.petdoctor.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @ClassName : UserController
 * @Description :
 * @Author : lixin
 * @Date: 2020-08-25 22:56
 */
@RequestMapping("/order")
@RestController
public class OrderController extends BaseController<Order> {

    private OrderRepository orderRepository;

    private UserRepository userRepository;

    private DoctorRepository doctorRepository;

    private PetRepository petRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository, UserRepository userRepository, DoctorRepository doctorRepository,PetRepository petRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.doctorRepository = doctorRepository;
        this.petRepository = petRepository;
        super.init(orderRepository);
    }


    @RequestMapping("/list")
    public ResponseEntity list(@RequestParam(defaultValue = "0") int page,
                               @RequestParam(defaultValue = "5") int size,
                               String username) {
        Pageable pageable = PageRequest.of(page,size);
        return ResponseEntity.ok(orderRepository.findAllByRealname(username,pageable));
    }


    @RequestMapping("/save")
    public ResponseEntity add(Order form) {
        if(form.getCreatetime() == null){
            form.setCreatetime(new Date());
        }
        User user = userRepository.findById(form.getUserId()).get();
        Doctor doctor = doctorRepository.findById(form.getDoctorId()).get();
        Pet pet = petRepository.findById(form.getPetId()).get();
        form.setDoctorName(doctor.getDoctorNickname());
        form.setGender(user.getUserGender());
        form.setRealname(user.getUserRealname());
        form.setPhone(user.getUserPhone());
        form.setPetName(pet.getPetName());
        form.setPetIcon(pet.getPetIcon());

        return ResponseEntity.ok(update(form));
    }

    @RequestMapping("/delete")
    public ResponseEntity delete(String id) {
        return ResponseEntity.ok(remove(id));
    }
}
