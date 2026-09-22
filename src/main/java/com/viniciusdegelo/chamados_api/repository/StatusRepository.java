package com.viniciusdegelo.chamados_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.viniciusdegelo.chamados_api.model.Status;

public interface StatusRepository extends JpaRepository<Status, Integer> {
}
