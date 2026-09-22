package com.viniciusdegelo.chamados_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viniciusdegelo.chamados_api.model.Status;
import com.viniciusdegelo.chamados_api.repository.StatusRepository;

@RestController
@RequestMapping("/status")
public class StatusController{

    @Autowired
    private StatusRepository statusRepository;


    @GetMapping
    public List<Status> listarTodos(){
        return statusRepository.findAll();
    }

    @PostMapping
    public Status criar(@RequestBody Status status) {
    return statusRepository.save(status);
    }

}






