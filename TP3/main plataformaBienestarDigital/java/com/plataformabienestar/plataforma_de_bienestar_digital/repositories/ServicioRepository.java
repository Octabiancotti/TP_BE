package com.plataformabienestar.plataforma_de_bienestar_digital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.plataformabienestar.plataforma_de_bienestar_digital.entities.Servicio;

@SuppressWarnings("rawtypes")
public interface ServicioRepository extends JpaRepository<Servicio, Long> {
}
