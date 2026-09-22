package com.viniciusdegelo.chamados_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viniciusdegelo.chamados_api.model.TipoChamado;
import com.viniciusdegelo.chamados_api.repository.TipoChamadoRepository;

@RestController
@RequestMapping("/tipochamado")
public class TipoChamadoController{

    @Autowired
    private TipoChamadoRepository tipoChamadoRepository;


    @GetMapping
    public List<TipoChamado> listarTodos(){
        return tipoChamadoRepository.findAll();
    }

    @PostMapping
    public TipoChamado criar(@RequestBody TipoChamado tipoChamado) {
    return tipoChamadoRepository.save(tipoChamado);
    }

}
