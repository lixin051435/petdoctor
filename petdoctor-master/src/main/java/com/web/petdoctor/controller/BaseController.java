package com.web.petdoctor.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * @ClassName : BaseController
 * @Description :
 * @Author : lixin
 * @Date: 2020-08-25 22:41
 */
public class BaseController<E> {

    private JpaRepository repository;

    public void init(JpaRepository repository){
        this.repository = repository;
    }

    public Page<E> findByPage(int page, int size){
        Pageable pageable = PageRequest.of(page,size);
        return repository.findAll(pageable);
    }

    public List<E> findAll(){
        return repository.findAll();
    }

    public Object insert(E e){
        return repository.save(e);
    }

    public Object remove(Serializable id){
        Object e = repository.findById(id).get();
        repository.deleteById(id);
        return e;
    }

    public Object update(E e){
        return repository.save(e);
    }

    public E findById(Serializable id) {
        Optional<E> optional =  repository.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }
}
