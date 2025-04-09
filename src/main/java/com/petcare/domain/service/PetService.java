package com.petcare.domain.service;

import com.petcare.domain.model.Pet;
import com.petcare.domain.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public Pet save(Pet pet) {
        return petRepository.save(pet);
    }


    // Buscar por nome exato
    public List<Pet> findByName(String name) {
        return petRepository.findByName(name);
    }

    // Buscar por tutor específico (usando o ID do tutor)
    public List<Pet> findByTutorId(Long tutorId) {
        return petRepository.findByTutorId(tutorId);
    }

    // Buscar por espécie (ex: cachorro, gato)
    public List<Pet> findBySpecies(String species) {
        return petRepository.findBySpecies(species);
    }
}
