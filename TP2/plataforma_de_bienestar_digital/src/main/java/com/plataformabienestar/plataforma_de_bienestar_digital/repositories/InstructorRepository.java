package com.plataformabienestar.plataforma_de_bienestar_digital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.plataformabienestar.plataforma_de_bienestar_digital.entities.Instructor;

@SuppressWarnings("rawtypes")
public interface InstructorRepository extends JpaRepository<Instructor, Long> {
}
