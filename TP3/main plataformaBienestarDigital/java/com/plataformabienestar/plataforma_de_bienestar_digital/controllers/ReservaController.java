package com.plataformabienestar.plataforma_de_bienestar_digital.controllers;

import com.plataformabienestar.plataforma_de_bienestar_digital.entities.Reserva;
import com.plataformabienestar.plataforma_de_bienestar_digital.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
@SuppressWarnings("rawtypes")
public class ReservaController {

    @Autowired
    private ReservaRepository reservaRepository;

    @GetMapping
    public List<Reserva> getAllReservas() {
        return reservaRepository.findAll();
    }

    @PostMapping
    public Reserva createReserva(@RequestBody Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> getReservaById(@PathVariable Long id) {
        Reserva reserva = reservaRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reserva no encontrada con ID " + id));
        return ResponseEntity.ok(reserva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reserva> updateReserva(@PathVariable Long id, @RequestBody Reserva reservaDetails) {
        Reserva reserva = reservaRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reserva no encontrada con ID " + id));

        reserva.setFecha(reservaDetails.getFecha());
        reserva.setMiembro(reservaDetails.getMiembro());
        reserva.setInstructor(reservaDetails.getInstructor());
        reserva.setServicio(reservaDetails.getServicio());

        Reserva updatedReserva = reservaRepository.save(reserva);
        return ResponseEntity.ok(updatedReserva);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReserva(@PathVariable Long id) {
        Reserva reserva = reservaRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reserva no encontrada con ID " + id));

        reservaRepository.delete(reserva);
        return ResponseEntity.noContent().build();
    }
}