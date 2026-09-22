package com.viniciusdegelo.chamados_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.viniciusdegelo.chamados_api.model.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {
}