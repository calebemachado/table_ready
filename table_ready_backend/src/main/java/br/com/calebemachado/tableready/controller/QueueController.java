package br.com.calebemachado.tableready.controller;

import br.com.calebemachado.tableready.model.AppUser;
import br.com.calebemachado.tableready.model.QueueEntry;
import br.com.calebemachado.tableready.service.QueueService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QueueController {

    private final QueueService queueService;

    public QueueController(
            QueueService queueService
    ) {
        this.queueService = queueService;
    }

    @GetMapping("/queue")
    public List<QueueEntry> getQueue() {
        return queueService.getQueue();
    }

    @GetMapping("/queue/print")
    public void printQueue() {
        queueService.printUsers();
    }

    @PostMapping("/queue")
    public void addUser(@RequestBody AppUser appUser) {
        queueService.addUser(appUser);
    }

    @DeleteMapping("/queue/user")
    public void removeUser() {
        queueService.deleteUser();
    }
}
