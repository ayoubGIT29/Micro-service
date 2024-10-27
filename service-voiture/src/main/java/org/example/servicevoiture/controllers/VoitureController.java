package org.example.servicevoiture.controllers;

import lombok.AllArgsConstructor;
import org.example.servicevoiture.clientRest.ClientService;
import org.example.servicevoiture.entities.Client;
import org.example.servicevoiture.entities.Voiture;
import org.example.servicevoiture.repositories.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/voitures")
public class VoitureController {

    VoitureRepository voitureRepository;
    ClientService clientService;

    @GetMapping()
    public List<Voiture> findAll() {
        return voitureRepository.findAll().stream().map(voiture -> {
                    voiture.setClient(clientService.clientById(voiture.getId_client()));
                    return  voiture;
                }
                ).collect(Collectors.toList());

    }

    @GetMapping("/{id}")
    public Voiture findById(@PathVariable Long id) throws Exception {
        return this.voitureRepository.findById(id).orElseThrow(() -> new Exception("Voiture inexistante"));
    }
}
