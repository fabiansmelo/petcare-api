package com.petcare.controller;

import com.petcare.domain.model.Tutor;
import com.petcare.domain.service.TutorService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/tutors")
public class TutorController {

    private final TutorService tutorService;

    // Injeção de dependência via construtor
    public TutorController(TutorService tutorService) {
        this.tutorService = tutorService;
    }

    // POST /tutors
    @PostMapping
    public Tutor createTutor(@RequestBody com.petcare.Dto.TutorInputDto input) {
        Tutor tutor = new Tutor();
        tutor.setName(input.getName());
        tutor.setEmail(input.getEmail());
        tutor.setPhone(input.getPhone());

        return tutorService.save(tutor);
    }

    // GET /tutors/name/{name}
    @GetMapping("/name/{name}")
    public Optional<Tutor> getByName(@PathVariable String name) {
        return tutorService.findByName(name);
    }

    // GET /tutors/email/{email}
    @GetMapping("/email/{email}")
    public Optional<Tutor> getByEmail(@PathVariable String email) {
        return tutorService.findByEmail(email);
    }
}
