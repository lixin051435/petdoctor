package com.web.petdoctor.controller;

import com.web.petdoctor.constants.SystemConstants;
import com.web.petdoctor.domain.Pet;
import com.web.petdoctor.domain.User;
import com.web.petdoctor.repository.PetRepository;
import com.web.petdoctor.repository.UserRepository;
import com.web.petdoctor.vo.PetVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName : UserController
 * @Description :
 * @Author : lixin
 * @Date: 2020-08-25 22:56
 */
@RequestMapping("/pet")
@RestController
public class PetController extends BaseController<Pet> {

    private PetRepository petRepository;

    private UserRepository userRepository;

    @Autowired
    public PetController(PetRepository petRepository,UserRepository userRepository) {
        this.petRepository = petRepository;
        this.userRepository = userRepository;
        super.init(petRepository);
    }


    @RequestMapping("/list")
    public ResponseEntity list(@RequestParam(defaultValue = SystemConstants.PAGE) int page, @RequestParam(defaultValue = SystemConstants.SIZE) int size) {
        return ResponseEntity.ok(findByPage(page,size));
    }

    @RequestMapping("/findByUserId")
    public ResponseEntity findByUserId(String userId) {
        return ResponseEntity.ok(petRepository.findAllByUserId(userId));
    }


    @RequestMapping("/save")
    public ResponseEntity edit(Pet form) {
        return ResponseEntity.ok(update(form));
    }

    @RequestMapping("/delete")
    public ResponseEntity delete(String id) {
        return ResponseEntity.ok(remove(id));
    }

    @RequestMapping("/get/{id}")
    public ResponseEntity getById(@PathVariable("id") String id) {
        return ResponseEntity.ok(findById(id));
    }
    @RequestMapping("/banner/{number}")
    public ResponseEntity getBanner(@PathVariable("number") Integer number) {
        List<Pet> list = petRepository.findAll();
        Collections.shuffle(list);
        list = list.subList(0,number);
        return ResponseEntity.ok(list);
    }
    @RequestMapping("/findAll")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(findAll());
    }


}
