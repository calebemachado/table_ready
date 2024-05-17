package br.com.calebemachado.tableready.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Phone {

    @Id
    private UUID id;
    private Integer areaCode;
    private Integer number;

    public Phone() {

    }

    public Phone(Integer areaCode, Integer number) {
        this.areaCode = areaCode;
        this.number = number;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getAreaCode() {
        return areaCode;
    }

    public Integer getNumber() {
        return number;
    }
}
