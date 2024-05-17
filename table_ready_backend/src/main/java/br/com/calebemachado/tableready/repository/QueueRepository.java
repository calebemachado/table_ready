package br.com.calebemachado.tableready.repository;

import br.com.calebemachado.tableready.model.AppUser;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.Queue;
import java.util.UUID;

@Component
public class QueueRepository {
    private Queue<AppUser> userQueue = new LinkedList<>();

    public void addUser(AppUser appUser) {
        appUser.setId(UUID.randomUUID());
        userQueue.add(appUser);
    }

    public void printUsers() {
        userQueue.forEach(appUser -> {
            System.out.println("Usuário na fila: " + appUser.getName());
        });
        System.out.println("Quantos usuarios tem aqui dentro: " + userQueue.size());
    }

    public Queue<AppUser> getQueue() {
        return userQueue;
    }


    public void deleteUser() {
        userQueue.remove();
    }
}
