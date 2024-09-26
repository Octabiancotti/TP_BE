package com.plataformabienestar.plataforma_de_bienestar_digital.controllers;

import com.plataformabienestar.plataforma_de_bienestar_digital.entities.Miembro;
import com.plataformabienestar.plataforma_de_bienestar_digital.repositories.MiembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/miembros")
@SuppressWarnings("rawtypes")
public class MiembroController {

    @Autowired
    private MiembroRepository miembroRepository;

    @GetMapping
    public List<Miembro> getAllMiembros() {
        return miembroRepository.findAll();
    }

    @PostMapping
    public Miembro createMiembro(@RequestBody Miembro miembro) {
        return miembroRepository.save(miembro);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Miembro> getMiembroById(@PathVariable Long id) {
        Miembro miembro = miembroRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Miembro no encontrado con ID " + id));
        return ResponseEntity.ok(miembro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Miembro> updateMiembro(@PathVariable Long id, @RequestBody Miembro miembroDetails) {
        Miembro miembro = miembroRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Miembro no encontrado con ID " + id));

        miembro.setNombre(miembroDetails.getNombre());
        miembro.setEmail(miembroDetails.getEmail());
        miembro.setMetas(miembroDetails.getMetas());

        Miembro updatedMiembro = miembroRepository.save(miembro);
        return ResponseEntity.ok(updatedMiembro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMiembro(@PathVariable Long id) {
        Miembro miembro = miembroRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Miembro no encontrado con ID " + id));
        
        miembroRepository.delete(miembro);
        return ResponseEntity.noContent().build();
    }
}