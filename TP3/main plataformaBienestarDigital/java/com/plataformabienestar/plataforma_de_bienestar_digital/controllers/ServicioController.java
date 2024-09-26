package com.plataformabienestar.plataforma_de_bienestar_digital.controllers;

import com.plataformabienestar.plataforma_de_bienestar_digital.entities.Servicio;
import com.plataformabienestar.plataforma_de_bienestar_digital.repositories.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/servicios")
@SuppressWarnings("rawtypes")
public class ServicioController {

    @Autowired
    private ServicioRepository servicioRepository;

    @GetMapping
    public List<Servicio> getAllServicios() {
        return servicioRepository.findAll();
    }

    @PostMapping
    public Servicio createServicio(@RequestBody Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Servicio> getServicioById(@PathVariable Long id) {
        Servicio servicio = servicioRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Servicio no encontrado con ID " + id));
        return ResponseEntity.ok(servicio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Servicio> updateServicio(@PathVariable Long id, @RequestBody Servicio servicioDetails) {
        Servicio servicio = servicioRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Servicio no encontrado con ID " + id));

        servicio.setNombre(servicioDetails.getNombre());
        servicio.setTipo(servicioDetails.getTipo());

        Servicio updatedServicio = servicioRepository.save(servicio);
        return ResponseEntity.ok(updatedServicio);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServicio(@PathVariable Long id) {
        Servicio servicio = servicioRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Servicio no encontrado con ID " + id));

        servicioRepository.delete(servicio);
        return ResponseEntity.noContent().build();
    }
}

