package com.sistema.aprendizaje.sistema_aprendizaje.controllers;
import org.springframework.web.bind.annotation.*;

import com.sistema.aprendizaje.sistema_aprendizaje.entities.Pregunta;
import com.sistema.aprendizaje.sistema_aprendizaje.repositories.PreguntaRepository;

import java.util.List;

@RestController
@RequestMapping("/api/preguntas")
public class PreguntaController {

    private final PreguntaRepository preguntaRepository;

    public PreguntaController(PreguntaRepository preguntaRepository) {
        this.preguntaRepository = preguntaRepository;
    }

    @GetMapping
    public List<Pregunta> obtenerPreguntas() {
        return preguntaRepository.findAll();
    }

    @PostMapping
    public Pregunta crearPregunta(@RequestBody Pregunta pregunta) {
        return preguntaRepository.save(pregunta);
    }

    @PutMapping("/{id}")
    public Pregunta actualizarPregunta(@PathVariable Long id, @RequestBody Pregunta preguntaActualizada) {
        return preguntaRepository.findById(id)
                .map(pregunta -> {
                    pregunta.setContenido(preguntaActualizada.getContenido());
                    pregunta.setRespuestaCorrecta(preguntaActualizada.getRespuestaCorrecta());
                    return preguntaRepository.save(pregunta);
                })
                .orElseThrow(() -> new RuntimeException("Pregunta no encontrada"));
    }

    @DeleteMapping("/{id}")
    public void eliminarPregunta(@PathVariable Long id) {
        preguntaRepository.deleteById(id);
    }
}