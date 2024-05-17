package br.com.calebemachado.tableready.controller;

import br.com.calebemachado.tableready.model.AppUser;
import br.com.calebemachado.tableready.repository.QueueRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Queue;

@RestController
public class QueueController {

    private final QueueRepository queueRepository;

    public QueueController(QueueRepository queueRepository) {
        this.queueRepository = queueRepository;
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
        queueRepository.addUser(appUser);
    }

    @DeleteMapping("/queue/user/")
    public void removeUser() {
        queueRepository.deleteUser();
    }
}
