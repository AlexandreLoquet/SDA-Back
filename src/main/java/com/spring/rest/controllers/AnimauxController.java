package com.spring.rest.controllers;


import com.spring.rest.entities.Animaux;
import com.spring.rest.entities.Sda;
import com.spring.rest.repositories.AnimauxRepository;
import com.spring.rest.repositories.SdaRepository;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.NameList;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/animaux")
@CrossOrigin(origins = "http://localhost:4200")
public class AnimauxController {

    private AnimauxRepository AnimauxRepository;

    private SdaRepository sdaRepository;

    public AnimauxController(AnimauxRepository animauxRepository, SdaRepository sdaRepository) {
        AnimauxRepository = animauxRepository;
        this.sdaRepository = sdaRepository;
    }


    @GetMapping("/all")
    public List<Animaux> allAnimaux() { return AnimauxRepository.findAll(); }


    @GetMapping("/sda/{sda}")
    List<Animaux> AnimauxBySdaId(@PathVariable Sda sda) { return AnimauxRepository.findAnimauxBySda_id(sda); }

    @GetMapping("/{types}")
    List<Animaux> AnimauxByTypes(@PathVariable String types) { return AnimauxRepository.findAnimauxByTypes(types); }

    @GetMapping("/free")
    List<Animaux> FreeAnimaux() { return AnimauxRepository.findFreeAnimaux(); }

    @PostMapping("/new")
    Animaux newAnimal(@RequestBody Animaux a) {
        a.setAdopte(false);
        return AnimauxRepository.save(a);
    }

    @DeleteMapping("/delete/{id}")
    void deleteAnimaux(@PathVariable Long id){AnimauxRepository.deleteById(id);}


    @PutMapping("/modify/{id}")
    Animaux modifyAnimaux(@RequestBody Animaux newAnimaux, @PathVariable Long id) {
        Optional<Animaux> animaux = AnimauxRepository.findById(id);

            Animaux ani = animaux.get();
            ani.setNom(newAnimaux.getNom());
            ani.setAdopte(newAnimaux.isAdopte());
            return AnimauxRepository.save(ani);
    }

}
