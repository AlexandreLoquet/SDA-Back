package com.spring.rest.controllers;


import com.spring.rest.entities.Animals;
import com.spring.rest.entities.Sda;
import com.spring.rest.repositories.AnimalsRepository;
import com.spring.rest.repositories.SdaRepository;
import com.spring.rest.repositories.UsersRepository;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;


import static java.util.Date.*;

@RestController
@RequestMapping("/animals")
@CrossOrigin(origins = "http://localhost:4200")
public class AnimalsController {

    private AnimalsRepository animalsRepository;

    private SdaRepository sdaRepository;

    private UsersRepository usersRepository;

    public AnimalsController(AnimalsRepository animalsRepository, SdaRepository sdaRepository, UsersRepository usersRepository) {
        this.animalsRepository = animalsRepository;
        this.sdaRepository = sdaRepository;
        this.usersRepository = usersRepository;
    }


    @GetMapping("/all")
    public List<Animals> allAnimals() { return animalsRepository.findAll(); }


    @GetMapping("/sda/{sda}")
    List<Animals> animalsBySdaId(@PathVariable Sda sda) { return animalsRepository.findAnimalsBySda_id(sda); }

    @GetMapping("/{types}")
    List<Animals> animalsByTypes(@PathVariable String types) { return animalsRepository.findAnimalsByTypes(types); }

    @GetMapping("/free")
    List<Animals> FreeAnimals() { return animalsRepository.findFreeAnimals(); }

    @PostMapping("/new")
    Animals newAnimal(@RequestBody Animals a) {
        a.setAdopt(false);
        return animalsRepository.save(a);
    }

    @DeleteMapping("/delete/{id}")
    void deleteAnimal(@PathVariable Long id){
        animalsRepository.deleteById(id);}


    @PutMapping("/adopt/{id}")
    Animals adoptAnimals(@RequestBody Animals a) {
        a.setAdopt(true);
        a.setAdoptionDate(from(Instant.now()));
        return animalsRepository.save(a);
    }

}
