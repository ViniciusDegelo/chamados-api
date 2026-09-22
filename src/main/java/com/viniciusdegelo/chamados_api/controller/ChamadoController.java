package com.viniciusdegelo.chamados_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viniciusdegelo.chamados_api.model.Chamado;
import com.viniciusdegelo.chamados_api.repository.ChamadoRepository;

@RestController
@RequestMapping("/chamado")
public class ChamadoController{

    @Autowired
    private ChamadoRepository chamadoRepository;


    @GetMapping
    public List<Chamado> listarTodos(){
        return chamadoRepository.findAll();
    }

    @PostMapping
    public Chamado criar(@RequestBody Chamado chamado) {
    return chamadoRepository.save(chamado);
    }

}

