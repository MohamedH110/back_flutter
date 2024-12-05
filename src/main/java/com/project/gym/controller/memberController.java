package com.project.gym.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.project.gym.model.member;
import com.project.gym.repository.memberRepository;

@RestController
@RequestMapping("/members")
@CrossOrigin(origins = "*")
public class memberController {

    @Autowired
    private memberRepository memberRepository;

    // Ajouter un membre
    @PostMapping("/add")
    public member add(@RequestBody member newMember) {
        return memberRepository.save(newMember);
    }

    // Obtenir tous les membres
    @GetMapping("/all")
    public List<member> getAll() {
        return memberRepository.findAll();
    }

    // Obtenir un membre par ID
    @GetMapping("/getbyid/{id}")
    public member getById(@PathVariable int id) {
        return memberRepository.findById(id).orElse(null);
    }

    // Mettre à jour un membre
    @PutMapping("/update/{id}")
    public member update(@PathVariable int id, @RequestBody member updatedMember) {
        updatedMember.setId(id); 
        return memberRepository.save(updatedMember);
    }

    // Supprimer un membre
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        memberRepository.deleteById(id);
    }
}
