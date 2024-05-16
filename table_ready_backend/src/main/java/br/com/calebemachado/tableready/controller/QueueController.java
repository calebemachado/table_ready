package br.com.calebemachado.tableready.controller;

import br.com.calebemachado.tableready.model.AppUser;
import br.com.calebemachado.tableready.repository.QueueRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/add-user")
    public void addUser(AppUser appUser) {
        queueRepository.addUser(appUser);

        queueRepository.printUsers();
    }
}
