package com.sistema.aprendizaje.sistema_aprendizaje.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.aprendizaje.sistema_aprendizaje.entities.Evaluacion;

public interface EvaluacionRepository extends JpaRepository<Evaluacion, Long> {
}
