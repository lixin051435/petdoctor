package com.web.petdoctor.controller;

import com.web.petdoctor.domain.Pet;
import com.web.petdoctor.domain.User;
import com.web.petdoctor.repository.PetRepository;
import com.web.petdoctor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
    public ResponseEntity list(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
        return ResponseEntity.ok(findByPage(page,size));
    }

    @RequestMapping("/findByUserId")
    public ResponseEntity findByUserId(String userId) {
        User user = userRepository.findById(userId).get();
        String[] petIds = user.getPets().split(",");
        List<Pet> pets = new ArrayList<>();
        for (int i = 0; i < petIds.length; i++) {
            pets.add(petRepository.findById(petIds[i]).get());
        }
        return ResponseEntity.ok(pets);
    }

    @RequestMapping("/save")
    public ResponseEntity edit(Pet form) {
        return ResponseEntity.ok(update(form));
    }

    @RequestMapping("/delete")
    public ResponseEntity delete(String id) {
        return ResponseEntity.ok(remove(id));
    }
}
