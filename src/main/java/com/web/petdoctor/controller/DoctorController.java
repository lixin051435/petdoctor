package com.web.petdoctor.controller;

import com.web.petdoctor.constants.SystemConstants;
import com.web.petdoctor.domain.Doctor;
import com.web.petdoctor.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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
    @RequestMapping("/findAll")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(findAll());
    }


    @RequestMapping("/list")
    public ResponseEntity list(@RequestParam(defaultValue = SystemConstants.PAGE) int page,
                               @RequestParam(defaultValue = SystemConstants.SIZE) int size) {
        return ResponseEntity.ok(findByPage(page,size));
    }


    @RequestMapping("/save")
    public ResponseEntity add(Doctor form) {
        return ResponseEntity.ok(update(form));
    }

    @RequestMapping("/login")
    public ResponseEntity login(Doctor form) {
        return ResponseEntity.ok(doctorRepository.findByDoctorNicknameAndDoctorPassword(form.getDoctorNickname(),form.getDoctorPassword()));
    }
    @RequestMapping("/get/{id}")
    public ResponseEntity getById(@PathVariable String id){
        return ResponseEntity.ok(findById(id));
    }



    @RequestMapping("/delete")
    public ResponseEntity delete(String id) {
        return ResponseEntity.ok(remove(id));
    }
}
