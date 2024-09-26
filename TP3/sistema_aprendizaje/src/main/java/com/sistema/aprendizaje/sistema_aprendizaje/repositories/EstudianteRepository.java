package com.sistema.aprendizaje.sistema_aprendizaje.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.aprendizaje.sistema_aprendizaje.entities.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
}
