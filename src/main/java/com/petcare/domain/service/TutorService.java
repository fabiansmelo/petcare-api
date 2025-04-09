// Logica / regras do negocio - Dados vem do controller | nao preocupa com exibicáo dos dados
package com.petcare.domain.service;

import com.petcare.domain.model.Tutor;
import com.petcare.domain.repository.TutorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service  // Spring deve gerenciar automaticamente ela
public class TutorService {


    private final TutorRepository tutorRepository;

    // Construtor com injeção de dependência
    public TutorService(TutorRepository tutorRepository) {
        this.tutorRepository = tutorRepository;
    }

    // Metodo de Salvar novo tutor
    public Tutor save(Tutor tutor) {
        return tutorRepository.save(tutor);
    }

    // Metodo de Buscar tutor pelo nome
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
