package com.petcare.domain.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "tb_appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateTime; // Armazenar a data e hora do serviço

    @ManyToOne // Podem existar muitos agendamentos para o mesmo pet
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @ManyToOne  // Varios agendamentos para um mesmo servico (como varios pets tomando banho)
    @JoinColumn(name = "service_id")
    private Service service;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Pet getPet() {
        return pet;
    }

    public Service getService() {
        return service;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
