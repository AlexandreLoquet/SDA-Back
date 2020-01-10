package com.spring.rest.controllers;


import com.spring.rest.entities.Animaux;
import com.spring.rest.entities.Sda;
import com.spring.rest.entities.Users;
import com.spring.rest.repositories.AnimauxRepository;
import com.spring.rest.repositories.SdaRepository;
import com.spring.rest.repositories.UsersRepository;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static java.util.Date.*;

@RestController
@RequestMapping("/animaux")
@CrossOrigin(origins = "http://localhost:4200")
public class AnimauxController {

    private AnimauxRepository AnimauxRepository;

    private SdaRepository sdaRepository;

    private UsersRepository usersRepository;

    public AnimauxController(AnimauxRepository animauxRepository, SdaRepository sdaRepository, UsersRepository usersRepository) {
        AnimauxRepository = animauxRepository;
        this.sdaRepository = sdaRepository;
        this.usersRepository = usersRepository;
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


    @PutMapping("/adopt/{id}")
    Animaux modifyAnimaux(@RequestBody Animaux a) {
        a.setAdopte(true);
        a.setDateAdoption(from(Instant.now()));
        return AnimauxRepository.save(a);
    }

}
