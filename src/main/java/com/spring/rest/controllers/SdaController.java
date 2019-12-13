package com.spring.rest.controllers;


import com.spring.rest.entities.Sda;
import com.spring.rest.repositories.SdaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sda")
@CrossOrigin(origins = "http://localhost:4200")
public class SdaController {

    private SdaRepository sdaRepository;

    public SdaController(SdaRepository sdaRepository) {
        this.sdaRepository = sdaRepository;
    }

    @GetMapping("/all")
    List<Sda> allSda() {
        return sdaRepository.findAll();
    }

    @GetMapping("/{id}")
    Optional<Sda> SdaById(@PathVariable Long id) { return sdaRepository.findById(id); }

    @PostMapping("/new")
    Sda newSda(@RequestBody Sda s) {
        return sdaRepository.save(s);
    }

    @DeleteMapping("/delete/{id}")
    void deleteSda(@PathVariable Long id){sdaRepository.deleteById(id);}
}
