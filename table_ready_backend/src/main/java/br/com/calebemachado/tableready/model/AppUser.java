package br.com.calebemachado.tableready.model;

import java.util.UUID;

public class AppUser {
    private UUID id;
    private String name;
    private String surname;
    private Phone phone;

    public AppUser(String name, String surname, Phone phone) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Phone getPhone() {
        return phone;
    }
}