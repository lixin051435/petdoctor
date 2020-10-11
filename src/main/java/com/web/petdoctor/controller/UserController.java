package com.web.petdoctor.controller;

import com.web.petdoctor.constants.SystemConstants;
import com.web.petdoctor.domain.User;
import com.web.petdoctor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName : UserController
 * @Description :
 * @Author : lixin
 * @Date: 2020-08-25 22:56
 */
@RequestMapping("/user")
@RestController
public class UserController extends BaseController<User> {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
        super.init(userRepository);
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
    public ResponseEntity add(User form) {
        return ResponseEntity.ok(update(form));
    }

    @RequestMapping("/login")
    public ResponseEntity login(User form) {
        return ResponseEntity.ok(userRepository.findByUserNicknameAndUserPassword(form.getUserNickname(),form.getUserPassword()));
    }


    @RequestMapping("/delete")
    public ResponseEntity delete(String id) {
        return ResponseEntity.ok(remove(id));
    }
}
