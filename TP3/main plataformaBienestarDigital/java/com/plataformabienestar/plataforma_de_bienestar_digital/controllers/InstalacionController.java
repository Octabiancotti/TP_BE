package com.plataformabienestar.plataforma_de_bienestar_digital.controllers;

import com.plataformabienestar.plataforma_de_bienestar_digital.entities.Instalacion;
import com.plataformabienestar.plataforma_de_bienestar_digital.repositories.InstalacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/instalaciones")
public class InstalacionController {

    @Autowired
    private InstalacionRepository instalacionRepository;

    @GetMapping
    public List<Instalacion> getAllInstalaciones() {
        return instalacionRepository.findAll();
    }

    @PostMapping
    public Instalacion createInstalacion(@RequestBody Instalacion instalacion) {
        return instalacionRepository.save(instalacion);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instalacion> getInstalacionById(@PathVariable Long id) {
        Instalacion instalacion = instalacionRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Instalación no encontrada con ID " + id));
        return ResponseEntity.ok(instalacion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Instalacion> updateInstalacion(@PathVariable Long id, @RequestBody Instalacion instalacionDetails) {
        Instalacion instalacion = instalacionRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Instalación no encontrada con ID " + id));

        instalacion.setNombre(instalacionDetails.getNombre());
        instalacion.setUbicacion(instalacionDetails.getUbicacion());

        Instalacion updatedInstalacion = instalacionRepository.save(instalacion);
        return ResponseEntity.ok(updatedInstalacion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstalacion(@PathVariable Long id) {
        Instalacion instalacion = instalacionRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Instalación no encontrada con ID " + id));

        instalacionRepository.delete(instalacion);
        return ResponseEntity.noContent().build();
    }
}
