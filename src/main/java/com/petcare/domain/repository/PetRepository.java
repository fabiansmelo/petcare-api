package com.petcare.domain.repository;

import com.petcare.domain.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {

    // Buscar pets por nome
    List<Pet> findByName(String name);

    // Buscar todos os pets de um tutor específico
    List<Pet> findByTutorId(Long tutorId);

    // Buscar pets por espécie (gato, cachorro)
    List<Pet> findBySpecies(String species);
}
