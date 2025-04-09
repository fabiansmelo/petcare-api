package com.petcare.domain.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "tb_consultation")
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateTime;  // Ideal p/ salvar a data e hora jutas

    private String description;

    private String veterinarian;

    @ManyToOne  // Muitas consultas podem estar ligadas a um mesmp pet
    @JoinColumn(name = "pet_id") // cria uma coluna com a chave estrangeira
    private Pet pet;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public String getVeterinarian() {
        return veterinarian;
    }

    public Pet getPet() {
        return pet;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setVeterinarian(String veterinarian) {
        this.veterinarian = veterinarian;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
