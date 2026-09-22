package com.viniciusdegelo.chamados_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viniciusdegelo.chamados_api.model.Tecnico;
import com.viniciusdegelo.chamados_api.repository.TecnicoRepository;

@RestController
@RequestMapping("/tecnico")
public class TecnicoController{

    @Autowired
    private TecnicoRepository tecnicoRepository;


    @GetMapping
    public List<Tecnico> listarTodos(){
        return tecnicoRepository.findAll();
    }

    @PostMapping
    public Tecnico criar(@RequestBody Tecnico tecnico) {
    return tecnicoRepository.save(tecnico);
    }

}

