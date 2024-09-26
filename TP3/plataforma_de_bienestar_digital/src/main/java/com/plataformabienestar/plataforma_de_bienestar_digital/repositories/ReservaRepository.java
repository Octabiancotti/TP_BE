package com.plataformabienestar.plataforma_de_bienestar_digital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.plataformabienestar.plataforma_de_bienestar_digital.entities.Reserva;

@SuppressWarnings("rawtypes")
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}