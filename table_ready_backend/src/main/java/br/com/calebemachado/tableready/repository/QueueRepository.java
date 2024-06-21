package br.com.calebemachado.tableready.repository;

import br.com.calebemachado.tableready.model.QueueEntry;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public interface QueueRepository extends JpaRepository<QueueEntry, UUID> {
    QueueEntry findByAppUserPhoneAreaCodeAndAppUserPhoneNumber(Integer areaCode, Integer number);
    List<QueueEntry> findAll(Sort sort);
    List<QueueEntry> findByStatus(String status, Sort sort);


}


/*private Queue<AppUser> userQueue = new LinkedList<>();

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
    }*/