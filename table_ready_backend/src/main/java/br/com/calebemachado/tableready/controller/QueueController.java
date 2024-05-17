package br.com.calebemachado.tableready.controller;

import br.com.calebemachado.tableready.model.AppUser;
import br.com.calebemachado.tableready.repository.QueueRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Queue;

@RestController
public class QueueController {

    private final QueueRepository queueRepository;

    public QueueController(QueueRepository queueRepository) {
        this.queueRepository = queueRepository;
    }

    @GetMapping("/queue")
    public void getQueue() {
        queueRepository.printUsers();
    }

    @GetMapping("/user-queue")
    public Queue<AppUser> getUserQueue() {
        return queueRepository.getUserQueue();
    }

    @PostMapping("/add-user")
    public void addUser(@RequestBody AppUser appUser) {
        queueRepository.addUser(appUser);

        queueRepository.printUsers();
    }

    @DeleteMapping("/remove-user")
    public void removeUser(@RequestBody AppUser appUser) {
        queueRepository.removeUser(appUser);

        queueRepository.printUsers();
    }
}
