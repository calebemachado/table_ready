package br.com.calebemachado.tableready.repository;

import br.com.calebemachado.tableready.model.AppUser;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.Queue;

@Component
public class QueueRepository {
    private Queue<AppUser> userQueue = new LinkedList<>();

    public void addUser(AppUser appUser) {
        userQueue.add(appUser);
    }

    public void printUsers() {
        userQueue.forEach(appUser -> {
            System.out.println("Usuário na fila: " + appUser.name());
        });
        System.out.println("Quantos usuarios tem aqui dentro: " + userQueue.size());
    }

    public void removeUser(AppUser appUser) {
        userQueue.remove(appUser);
    }

    public Queue<AppUser> getUserQueue() {
        return userQueue;
    }


}
