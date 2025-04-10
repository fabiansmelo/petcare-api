// Transporta dados entre as partes da aplicacao
// Evita expor diretamente as entidades do DB.

package com.petcare.Dto;

public class TutorInputDto {
    private String name;
    private String email;
    private String phone;

    // Getters e setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
