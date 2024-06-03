package br.com.calebemachado.tableready.controller;

import br.com.calebemachado.tableready.model.AppUser;
import br.com.calebemachado.tableready.repository.AppUserRepository;
import br.com.calebemachado.tableready.repository.QueueRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Queue;
import java.util.UUID;

@RestController
public class QueueController {

    private final QueueRepository queueRepository;
    private final AppUserRepository appUserRepository;

    public QueueController(QueueRepository queueRepository, AppUserRepository appUserRepository) {
        this.queueRepository = queueRepository;
        this.appUserRepository = appUserRepository;
    }

    @GetMapping("/queue")
    public Queue<AppUser> getQueue() {
        return queueRepository.getQueue();
    }

    @GetMapping("/queue/print")
    public void printQueue() {
        queueRepository.printUsers();
    }

    @PostMapping("/queue")
    public void addUser(@RequestBody AppUser appUser) {
        appUser.setId(UUID.randomUUID());
        if (appUser.getPhone() != null) {
            appUser.getPhone().setId(UUID.randomUUID());
        }
        queueRepository.addUser(appUser);
        appUserRepository.save(appUser);
    }

    @DeleteMapping("/queue/user/")
    public void removeUser() {
        queueRepository.deleteUser();
    }
}
