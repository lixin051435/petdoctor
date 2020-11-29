package com.web.petdoctor.controller;

import com.web.petdoctor.constants.SystemConstants;
import com.web.petdoctor.domain.Admin;
import com.web.petdoctor.domain.Chat;
import com.web.petdoctor.domain.User;
import com.web.petdoctor.repository.AdminRepository;
import com.web.petdoctor.repository.ChatRepository;
import com.web.petdoctor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName : UserController
 * @Description :
 * @Author : lixin
 * @Date: 2020-08-25 22:56
 */
@RequestMapping("/chat")
@RestController
public class ChatController extends BaseController<Chat> {

    private ChatRepository chatRepository;

    private UserRepository userRepository;

    @Autowired
    public ChatController(ChatRepository chatRepository,UserRepository userRepository) {
        this.chatRepository = chatRepository;
        this.userRepository = userRepository;
        super.init(chatRepository);
    }

    @RequestMapping("/save")
    public ResponseEntity add(Chat form) {
        form.setCreatetime(new Date());
        return ResponseEntity.ok(update(form));
    }


    @RequestMapping("/findAll")
    public ResponseEntity getAll(String userId,String doctorId) {
        return ResponseEntity.ok(chatRepository.findAllByUserIdAndDoctorIdOrderByCreatetime(userId,doctorId));
    }

    @RequestMapping("/findAllChatUser")
    public ResponseEntity findAllChatUser(String doctorId) {
        List<String> userIdlist = chatRepository.findAllByDoctorIdOrderByCreatetimeDesc(doctorId)
                .stream().map(Chat::getUserId).collect(Collectors.toList())
                .stream().distinct().collect(Collectors.toList());

        List<User> userList = userRepository.findAllByUserIdIn(userIdlist);
        return ResponseEntity.ok(userList);
    }

}
