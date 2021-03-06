package com.web.petdoctor.controller;

import com.web.petdoctor.constants.SystemConstants;
import com.web.petdoctor.domain.Admin;
import com.web.petdoctor.repository.AdminRepository;
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
@RequestMapping("/admin")
@RestController
public class AdminController extends BaseController<Admin> {

    private AdminRepository adminRepository;

    @Autowired
    public AdminController(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
        super.init(adminRepository);
    }


    @RequestMapping("/list")
    public ResponseEntity list(@RequestParam(defaultValue = SystemConstants.PAGE) int page,
                               @RequestParam(defaultValue = SystemConstants.SIZE) int size) {
        return ResponseEntity.ok(findByPage(page, size));
    }


    @RequestMapping("/save")
    public ResponseEntity add(Admin form) {
        return ResponseEntity.ok(update(form));
    }

    @RequestMapping("/login")
    public ResponseEntity login(Admin form) {
        return ResponseEntity.ok(adminRepository.findByAdminNicknameAndAdminPassword(form.getAdminNickname(), form.getAdminPassword()));
    }
    @RequestMapping("/get/{id}")
    public ResponseEntity getById(@PathVariable String id){
        return ResponseEntity.ok(findById(id));
    }


    @RequestMapping("/delete")
    public ResponseEntity delete(String id) {
        return ResponseEntity.ok(remove(id));
    }

    @RequestMapping("/findAll")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(findAll());
    }

}
