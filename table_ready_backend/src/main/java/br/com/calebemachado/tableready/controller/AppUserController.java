package br.com.calebemachado.tableready.controller;

import br.com.calebemachado.tableready.model.AppUser;
import br.com.calebemachado.tableready.repository.AppUserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class AppUserController {

    private final AppUserRepository repository;

    public AppUserController(AppUserRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/app-user")
    public void addUser(@RequestBody AppUser appUser) {
        appUser.setId(UUID.randomUUID());
        appUser.getPhone().setId(UUID.randomUUID());
        repository.save(appUser);
    }
}
