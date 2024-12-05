package com.project.gym.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.project.gym.model.equipment;
import com.project.gym.repository.equipmentRepository;

@RestController
@RequestMapping("/equipments")
@CrossOrigin(origins = "*")
public class equipmentController {

    @Autowired
    private equipmentRepository equipmentRepository;

    // Ajouter un équipement
    @PostMapping("/add")
    public equipment add(@RequestBody equipment newEquipment) {
        return equipmentRepository.save(newEquipment);
    }

    // Obtenir tous les équipements
    @GetMapping("/all")
    public List<equipment> getAll() {
        return equipmentRepository.findAll();
    }

    // Obtenir un équipement par ID
    @GetMapping("/getbyid/{number}")
    public equipment getById(@PathVariable int number) {
        return equipmentRepository.findById(number).orElse(null);
    }

    // Mettre à jour un équipement
    @PutMapping("/update/{number}")
    public equipment update(@PathVariable int number, @RequestBody equipment updatedEquipment) {
        updatedEquipment.setNumber(number); // S'assurer que le numéro est mis à jour
        return equipmentRepository.save(updatedEquipment);
    }

    // Supprimer un équipement
    @DeleteMapping("/delete/{number}")
    public void delete(@PathVariable int number) {
        equipmentRepository.deleteById(number);
    }
}
