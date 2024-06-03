package br.com.calebemachado.tableready.controller;

import br.com.calebemachado.tableready.model.AppUser;
import br.com.calebemachado.tableready.service.AppUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppUserController {

    private final AppUserService appUserService;

    public AppUserController(
            AppUserService appUserService
    ) {
        this.appUserService = appUserService;
    }

    @PostMapping("/app-user")
    public void addUser(
            @RequestBody AppUser appUser
    ) {
        appUserService.save(appUser);
    }
}
