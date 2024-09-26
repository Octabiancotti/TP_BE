package com.sistema.aprendizaje.sistema_aprendizaje.controllers;

import org.springframework.web.bind.annotation.*;

import com.sistema.aprendizaje.sistema_aprendizaje.entities.Estudiante;
import com.sistema.aprendizaje.sistema_aprendizaje.repositories.EstudianteRepository;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    private final EstudianteRepository estudianteRepository;

    public EstudianteController(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    @GetMapping
    public List<Estudiante> obtenerEstudiantes() {
        return estudianteRepository.findAll();
    }

    @PostMapping
    public Estudiante crearEstudiante(@RequestBody Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    @PutMapping("/{id}")
    public Estudiante actualizarEstudiante(@PathVariable Long id, @RequestBody Estudiante estudianteActualizado) {
        return estudianteRepository.findById(id)
                .map(estudiante -> {
                    estudiante.setNombre(estudianteActualizado.getNombre());
                    estudiante.setEmail(estudianteActualizado.getEmail());
                    estudiante.setEstiloAprendizaje(estudianteActualizado.getEstiloAprendizaje());
                    return estudianteRepository.save(estudiante);
                })
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
    }

    @DeleteMapping("/{id}")
    public void eliminarEstudiante(@PathVariable Long id) {
        estudianteRepository.deleteById(id);
    }
}
