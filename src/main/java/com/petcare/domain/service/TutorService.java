package com.petcare.domain.service;

import com.petcare.domain.model.Tutor;
import com.petcare.domain.repository.TutorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TutorService {

    private final TutorRepository tutorRepository;

    public TutorService(TutorRepository tutorRepository) {
        this.tutorRepository = tutorRepository;
    }

    // Salvar novo tutor
    public Tutor save(Tutor tutor) {
        return tutorRepository.save(tutor);
    }

    // Buscar tutor pelo nome
    public Optional<Tutor> findByName(String name) {
        return tutorRepository.findByName(name);
    }

    // Buscar por ID
    public Optional<Tutor> findById(Long id) {
        return tutorRepository.findById(id);
    }

    // Buscar tutor pelo e-mail
    public Optional<Tutor> findByEmail(String email) {
        return tutorRepository.findByEmail(email);
    }

}
