package com.petcare.domain.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "tb_tutor") // Indica que a classe é uma tabel no BD
public class Tutor {

    @Id // Id é a chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //o banco de dados autoincrementa o valor
    private Long id;

    private String name;
    private String email;
    private String phone;

    //Cascade - permite que as acoes se propaguem entre tutor e pets
    //Fetch = Ao buscar um tutor os pets dele sao carregados automaticamente
    @OneToMany(mappedBy = "tutor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Pet> pets;

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
