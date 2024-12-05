package com.project.gym.model;

import jakarta.persistence.*;

@Entity
@Table(name = "equipment")
public class equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "number")
    private int number;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "availability", nullable = false)
    private boolean availability;

    @Column(name = "weight", nullable = false)
    private double weight;

    @ManyToOne
    @JoinColumn(name = "coach_id", nullable = false)
    private coach coach;

    public equipment() {
    }

    public equipment(String name, String category, boolean availability, double weight, coach coach) {
        this.name = name;
        this.category = category;
        this.availability = availability;
        this.weight = weight;
        this.coach = coach;
    }

    // Getters and Setters
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public coach getCoach() {
        return coach;
    }

    public void setCoach(coach coach) {
        this.coach = coach;
    }
}
