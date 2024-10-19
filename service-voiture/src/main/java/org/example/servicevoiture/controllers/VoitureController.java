package org.example.servicevoiture.controllers;

import org.example.servicevoiture.entities.Voiture;
import org.example.servicevoiture.repositories.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VoitureController {
    @Autowired
    VoitureRepository voitureRepository;

    @GetMapping("/voitures")
    public List<Voiture> findAll() {
        return voitureRepository.findAll();
    }

    @GetMapping("/voitures/{id}")
    public Voiture findById(@PathVariable Long id) throws Exception {
        return this.voitureRepository.findById(id).orElseThrow(() -> new Exception("Voiture inexistante"));
    }
}
