package com.plataformabienestar.plataforma_de_bienestar_digital.controllers;

import com.plataformabienestar.plataforma_de_bienestar_digital.entities.SistemaRecomendacion;
import com.plataformabienestar.plataforma_de_bienestar_digital.repositories.SistemaRecomendacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/recomendaciones")
public class SistemaRecomendacionController {

    @Autowired
    private SistemaRecomendacionRepository sistemaRecomendacionRepository;

    @GetMapping
    public List<SistemaRecomendacion> getAllRecomendaciones() {
        return sistemaRecomendacionRepository.findAll();
    }

    @PostMapping
    public SistemaRecomendacion createRecomendacion(@RequestBody SistemaRecomendacion recomendacion) {
        return sistemaRecomendacionRepository.save(recomendacion);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SistemaRecomendacion> getRecomendacionById(@PathVariable Long id) {
        SistemaRecomendacion recomendacion = sistemaRecomendacionRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Recomendación no encontrada con ID " + id));
        return ResponseEntity.ok(recomendacion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SistemaRecomendacion> updateRecomendacion(@PathVariable Long id, @RequestBody SistemaRecomendacion recomendacionDetails) {
        SistemaRecomendacion recomendacion = sistemaRecomendacionRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Recomendación no encontrada con ID " + id));

        recomendacion.setDescripcion(recomendacionDetails.getDescripcion());
        recomendacion.setMiembros(recomendacionDetails.getMiembros());

        SistemaRecomendacion updatedRecomendacion = sistemaRecomendacionRepository.save(recomendacion);
        return ResponseEntity.ok(updatedRecomendacion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecomendacion(@PathVariable Long id) {
        SistemaRecomendacion recomendacion = sistemaRecomendacionRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Recomendación no encontrada con ID " + id));

        sistemaRecomendacionRepository.delete(recomendacion);
        return ResponseEntity.noContent().build();
    }
}