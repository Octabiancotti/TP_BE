package com.plataformabienestar.plataforma_de_bienestar_digital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.plataformabienestar.plataforma_de_bienestar_digital.entities.Miembro;

@SuppressWarnings("rawtypes")
public interface MiembroRepository extends JpaRepository<Miembro, Long> {
}