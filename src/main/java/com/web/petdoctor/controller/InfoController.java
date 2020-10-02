package com.web.petdoctor.controller;

import com.web.petdoctor.domain.Info;
import com.web.petdoctor.repository.InfoRepository;
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
@RequestMapping("/info")
@RestController
public class InfoController extends BaseController<Info> {

    private InfoRepository infoRepository;

    @Autowired
    public InfoController(InfoRepository infoRepository) {
        this.infoRepository = infoRepository;
        super.init(infoRepository);
    }


    @RequestMapping("/list")
    public ResponseEntity list(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
        return ResponseEntity.ok(findByPage(page,size));
    }


    @RequestMapping("/save")
    public ResponseEntity add(Info form) {
        return ResponseEntity.ok(update(form));
    }

    @RequestMapping("/delete")
    public ResponseEntity delete(String id) {
        return ResponseEntity.ok(remove(id));
    }
}
