package br.com.calebemachado.tableready.model;

public record AppUser(
        String name,
        String surname,
        Phone phone
) {
}