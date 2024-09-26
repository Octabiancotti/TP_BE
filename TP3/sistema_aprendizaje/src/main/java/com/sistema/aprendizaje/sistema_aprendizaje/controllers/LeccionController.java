package com.sistema.aprendizaje.sistema_aprendizaje.controllers;

import org.springframework.web.bind.annotation.*;

import com.sistema.aprendizaje.sistema_aprendizaje.entities.Leccion;
import com.sistema.aprendizaje.sistema_aprendizaje.repositories.LeccionRepository;

import java.util.List;

@RestController
@RequestMapping("/api/lecciones")
public class LeccionController {

    private final LeccionRepository leccionRepository;

    public LeccionController(LeccionRepository leccionRepository) {
        this.leccionRepository = leccionRepository;
    }

    @GetMapping
    public List<Leccion> obtenerLecciones() {
        return leccionRepository.findAll();
    }

    @PostMapping
    public Leccion crearLeccion(@RequestBody Leccion leccion) {
        return leccionRepository.save(leccion);
    }

    @PutMapping("/{id}")
    public Leccion actualizarLeccion(@PathVariable Long id, @RequestBody Leccion leccionActualizada) {
        return leccionRepository.findById(id)
                .map(leccion -> {
                    leccion.setTitulo(leccionActualizada.getTitulo());
                    leccion.setContenido(leccionActualizada.getContenido());
                    return leccionRepository.save(leccion);
                })
                .orElseThrow(() -> new RuntimeException("Leccion no encontrada"));
    }

    @DeleteMapping("/{id}")
    public void eliminarLeccion(@PathVariable Long id) {
        leccionRepository.deleteById(id);
    }
}
