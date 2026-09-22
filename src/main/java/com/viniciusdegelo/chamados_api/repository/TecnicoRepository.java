package com.viniciusdegelo.chamados_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.viniciusdegelo.chamados_api.model.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {
}