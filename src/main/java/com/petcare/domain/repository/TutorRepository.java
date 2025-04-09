package com.petcare.domain.repository;

import com.petcare.domain.model.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TutorRepository extends JpaRepository<Tutor, Long> {

    //optional é usado quando esta buscando um unico objeto e nao uma lista
    // Buscar tutor pelo nome
    Optional<Tutor> findByName(String name);

    // Buscar tutor pelo e-mail (evita duplicidade)
    Optional<Tutor> findByEmail(String email);
}
