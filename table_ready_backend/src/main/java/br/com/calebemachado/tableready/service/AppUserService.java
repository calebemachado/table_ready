package br.com.calebemachado.tableready.service;

import br.com.calebemachado.tableready.model.AppUser;
import br.com.calebemachado.tableready.repository.AppUserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AppUserService {

    private final AppUserRepository appUserRepository;

    //Dependecy Injection -> Dependency Inversion
    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public void save(AppUser appUser) {
        appUser.setId(UUID.randomUUID());
        if (appUser.getPhone() != null) {
            appUser.getPhone().setId(UUID.randomUUID());
        }

        appUserRepository.save(appUser);
    }
}
