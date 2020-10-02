package com.web.petdoctor.controller;

import com.web.petdoctor.domain.Doctor;
import com.web.petdoctor.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName : UserController
 * @Description :
 * @Author : lixin
 * @Date: 2020-08-25 22:56
 */
@RequestMapping("/doctor")
@RestController
public class DoctorController extends BaseController<Doctor> {

    private DoctorRepository doctorRepository;

    @Autowired
    public DoctorController(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
        super.init(doctorRepository);
    }


    @RequestMapping("/list")
    public ResponseEntity list(@RequestParam(defaultValue = "0") int page,
                               @RequestParam(defaultValue = "5") int size) {
        return ResponseEntity.ok(findByPage(page,size));
    }


    @RequestMapping("/save")
    public ResponseEntity add(Doctor form) {
        return ResponseEntity.ok(update(form));
    }

    @RequestMapping("/login")
    public ResponseEntity login(String nickname,String password) {
        return ResponseEntity.ok(doctorRepository.findByDoctorNicknameAndDoctorPassword(nickname,password));
    }



    @RequestMapping("/delete")
    public ResponseEntity delete(String id) {
        return ResponseEntity.ok(remove(id));
    }
}
