package com.web.petdoctor.controller;

import com.web.petdoctor.domain.Admin;
import com.web.petdoctor.repository.AdminRepository;
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
    public ResponseEntity list(@RequestParam(defaultValue = "0") int page,
                               @RequestParam(defaultValue = "5") int size) {
        return ResponseEntity.ok(findByPage(page,size));
    }


    @RequestMapping("/save")
    public ResponseEntity add(Admin form) {
        return ResponseEntity.ok(update(form));
    }

    @RequestMapping("/login")
    public ResponseEntity login(String nickname,String password) {
        return ResponseEntity.ok(adminRepository.findByAdminNicknameAndAdminPassword(nickname,password));
    }


    @RequestMapping("/delete")
    public ResponseEntity delete(String id) {
        return ResponseEntity.ok(remove(id));
    }
}
