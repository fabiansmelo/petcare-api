package com.petcare.domain.repository;

import com.petcare.domain.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Service, Long> {

    // Buscar serviços por nome exato
    List<Service> findByName(String name);

    // Buscar serviços por parte do nome (ignora maiúsculas/minúsculas)
    List<Service> findByNameContainingIgnoreCase(String namePart);


}
