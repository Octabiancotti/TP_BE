package com.sistema.aprendizaje.sistema_aprendizaje.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.aprendizaje.sistema_aprendizaje.entities.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}