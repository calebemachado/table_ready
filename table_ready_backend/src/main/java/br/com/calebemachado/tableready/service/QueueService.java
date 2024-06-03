package br.com.calebemachado.tableready.service;

import br.com.calebemachado.tableready.model.AppUser;
import br.com.calebemachado.tableready.repository.QueueRepository;
import org.springframework.stereotype.Service;

import java.util.Queue;

@Service
public class QueueService {

    private final QueueRepository queueRepository;
    private final AppUserService appUserService;

    public QueueService(
            QueueRepository queueRepository,
            AppUserService appUserService
    ) {
        this.queueRepository = queueRepository;
        this.appUserService = appUserService;
    }

    public Queue<AppUser> getQueue() {
        return queueRepository.getQueue();
    }

    public void printUsers() {
        queueRepository.printUsers();
    }

    public void addUser(AppUser appUser) {
        appUserService.save(appUser);
        queueRepository.addUser(appUser);
    }

    public void deleteUser() {
        queueRepository.deleteUser();
    }
}
