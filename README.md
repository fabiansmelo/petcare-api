# 🐾 PetCare API

A **PetCare** é uma API REST desenvolvida para gerenciar um sistema de petshop.  
Com ela é possível cadastrar tutores, seus pets, consultas, agendamentos e serviços oferecidos.  
O principal objetivo deste projeto é exercitar conceitos de desenvolvimento com **Spring Boot**, boas práticas de organização de código e a estruturação de uma aplicação backend.

---

## 🚀 Tecnologias utilizadas

- **Java**
- **Spring Boot**
  - Spring Web:
    > Maximiza a produtividade do desenvolvedor por meio de sua poderosa premissa de autoconfiguração;
  - Spring Data JPA:
    > Ferramenta que ajuda a simplificar a camada de acesso aos dados, facilitando a integração com bancos de dados SQL;
- **Banco de dados H2** (em memória, usado para testes)
- **Hibernate** (implementação JPA usada pelo Spring para mapeamento objeto-relacional)
- **Gradle** – como gerenciador de dependências

---

## 📌 Funcionalidades atuais

- Cadastro de tutores
- Cadastro de pets vinculados a tutores
- Consultas médicas para os pets - (Falta implementar)
- Agendamento de serviços para os pets - (Falta implementar)

---

## 🧩 Diagrama de classes

```mermaid
classDiagram
    class Tutor {
        +Long id
        +String name
        +String email
        +String phone
    }

    class Pet {
        +Long id
        +String name
        +String species
        +String breed
        +int age
    }

    class Consultation {
        +Long id
        +LocalDateTime dateTime
        +String description
        +String veterinarian
    }

    class Appointment {
        +Long id
        +LocalDateTime dateTime
    }

    class Service {
        +Long id
        +String name
        +String description
        +Double price
    }

    Tutor "1" --> "0..*" Pet : owns
    Pet "1" --> "0..*" Consultation : has
    Pet "1" --> "0..*" Appointment : has
    Appointment "1" --> "1" Service : includes
