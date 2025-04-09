package com.petcare.controller;

import com.petcare.Dto.PetInputDto;
import com.petcare.domain.model.Pet;
import com.petcare.domain.model.Tutor;
import com.petcare.domain.service.PetService;
import com.petcare.domain.service.TutorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Informa ao Spring que essa classe vai receber requisições HTTP
@RequestMapping("/pets") // Define o caminho base da URL para os endpoints desse controlador
public class PetController {

    private final PetService petService;
    private final TutorService tutorService; // Precisamos disso para buscar o Tutor pelo ID


    // Injeção de dependência via construtor ao invés de ciar um novo PetService, o spring cuida disso
    public PetController(PetService petService, TutorService tutorService) {
        this.petService = petService;
        this.tutorService = tutorService;
    }

    // POST /pets
    // Recebe os dados de um novo pet no corpo da requisição e salva no banco de dados
    @PostMapping
    public Pet createPet(@RequestBody PetInputDto petInputDto) {
        Pet pet = new Pet();
        pet.setName(petInputDto.getName());
        pet.setSpecies(petInputDto.getSpecies());
        pet.setBreed(petInputDto.getBreed());
        pet.setAge(petInputDto.getAge());

        // Buscar o tutor pelo ID
        Tutor tutor = tutorService.findById(petInputDto.getTutorId())
                .orElseThrow(() -> new RuntimeException("Tutor não encontrado com ID: " + petInputDto.getTutorId()));

        pet.setTutor(tutor);

        return petService.save(pet);
    }


    // GET /pets/name/{name}  -- Caminho base, definido no request mapping
    // PathVariable - Indica que a URL {name} name vai ser passado como argumento no metodo
    @GetMapping("/name/{name}")
    public List<Pet> getByName(@PathVariable String name) {
        return petService.findByName(name);
    }

    // GET /pets/tutor/{tutorId}
    // Retorna todos os pets de um tutor especifico determinado pelo ID do tutor
    @GetMapping("/tutor/{tutorId}")
    public List<Pet> getByTutorId(@PathVariable Long tutorId) {
        return petService.findByTutorId(tutorId);
    }

    // GET /pets/species/{species}
    // Buscar por especies
    @GetMapping("/species/{species}")
    public List<Pet> getBySpecies(@PathVariable String species) {
        return petService.findBySpecies(species);
    }
}
