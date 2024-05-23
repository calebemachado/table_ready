package br.com.calebemachado.tableready.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import java.util.UUID;

@Entity
public class AppUser {

    @Id
    private UUID id;
    private String name;
    private String surname;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "phone_id")
    private Phone phone;

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public AppUser() {
    }

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