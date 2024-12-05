package com.project.gym.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.project.gym.model.coach;
import com.project.gym.repository.coachRepository;

@RestController
@RequestMapping("/coaches")
@CrossOrigin("*")
public class coachController {

    @Autowired
    private coachRepository coachRepository;

    // Ajouter un coach
    @PostMapping("/add")
    public coach add(@RequestBody coach newCoach) {
        return coachRepository.save(newCoach);
    }

    // Obtenir tous les coaches
    @GetMapping("/all")
    public List<coach> getAll() {
        return coachRepository.findAll();
    }

    // Obtenir un coach par ID
    @GetMapping("/getbyid/{id}")
    public coach getById(@PathVariable int id) {
        return coachRepository.findById(id).orElse(null);
    }

    // Mettre à jour un coach
    @PutMapping("/update/{id}")
    public coach update(@PathVariable int id, @RequestBody coach updatedCoach) {
        updatedCoach.setId(id); // S'assurer que l'ID est mis à jour
        return coachRepository.save(updatedCoach);
    }

    // Supprimer un coach
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        coachRepository.deleteById(id);
    }
}
