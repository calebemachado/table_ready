package br.com.calebemachado.tableready.service;

import br.com.calebemachado.tableready.model.AppUser;
import br.com.calebemachado.tableready.model.QueueEntry;
import br.com.calebemachado.tableready.repository.QueueRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

// Define que essa Classe do Spring é um serviço (pode ter Injeção de Dependências)
@Service
public class QueueService {

    // Declara quais dependências serão injetadas.
    private static final Logger logger = LoggerFactory.getLogger(QueueService.class);
    private final QueueRepository queueRepository;
    private final AppUserService appUserService;

    //Construtor com injeção de dependências
    public QueueService(
                QueueRepository queueRepository,
                AppUserService appUserService
        ) {
        //Atribui as dependências injetadas as variáveis da classe
        this.queueRepository = queueRepository;
            this.appUserService = appUserService;
        }

        //Método que adiciona um usuário na fila
        public void addUser (AppUser appUser) {
            //Salva o usuário no banco de dados usando o serviço de usuário
            logger.info("Saving AppUser: {}", appUser);
            appUserService.save(appUser);

            //Cria uma nova entrada na fila com o usuário salvo
            QueueEntry queueEntry = new QueueEntry();
            queueEntry.setAppUser(appUser);  //Atribui o usuário a entrada da fila
            queueEntry.setStatus("WAITING"); //Atribui o status da fila como "WAITING"

            //Determina a posição do usuário na fila
            int position = determinatePosition();
            queueEntry.setPosition(position); //Define a posição na fila

            //Salva a entrada da fila no banco de dados
            logger.info("QueueEntry before saving: id={}, appUser={}, status={}, position={}, createdAt={}",
                    queueEntry.getId(), queueEntry.getAppUser(), queueEntry.getStatus(), queueEntry.getPosition(), queueEntry.getCreatedAt());
            queueRepository.save(queueEntry);

            logger.info("QueueEntry after saving: id={}, appUser={}, status={}, position={}, createdAt={}",
                    queueEntry.getId(), queueEntry.getAppUser(), queueEntry.getStatus(), queueEntry.getPosition(), queueEntry.getCreatedAt());
        }

        //Método que remove o primeiro usuário da fila
        public void deleteUser() {
            //Recupera a primeira entrada da fila
            QueueEntry queueEntry = queueRepository.findAll().getFirst();

            //Remove essa entrada da fila do banco de dados
            queueRepository.delete(queueEntry);
        }

        //Método que remove um usuário da fila pelo telefone
        public void deleteUserByPhone(Integer areaCode, Integer number) {
            //Recupera a entrada da fila pelo telefone
            QueueEntry queueEntry = queueRepository.findByAppUserPhoneAreaCodeAndAppUserPhoneNumber(areaCode, number);

            //Remove essa entrada da fila do banco de dados
            queueRepository.delete(queueEntry);
        }

        //Método que retorna a fila de usuários esperando
            public List<QueueEntry> getQueue() {
                return queueRepository.findByStatus(
                        "WAITING",
                        Sort.by(Sort.Direction.ASC, "createdAt")
                );
            }

        //Método que imprime os usuários esperando na fila
            public void printUsers() {
                //Recupera a fila de usuários
                List<QueueEntry> queue = getQueue();

                //Itera sobre a fila e imprime os usuários
                queue.forEach(queueEntry -> {
                    System.out.println("Position: " + queueEntry.getPosition() + " - Name: " + queueEntry.getAppUser().getName() + " - Phone: " + queueEntry.getAppUser().getPhone().getAreaCode()+ "-" + queueEntry.getAppUser().getPhone().getNumber());
                });

                //Imprime a quantidade de usuários na fila
                System.out.println("Number of users awaiting:  " + queue.size());
            }



        //Método auxiliar que determina a posição do usuário na fila
        private int determinatePosition() {
            long count = queueRepository.count();
            return (int) (count + 1);
        }
}
