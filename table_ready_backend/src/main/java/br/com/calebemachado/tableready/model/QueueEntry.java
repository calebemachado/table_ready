package br.com.calebemachado.tableready.model;

import ch.qos.logback.classic.Logger;
import jakarta.persistence.*;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class QueueEntry {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(QueueEntry.class);

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private AppUser appUser;

    private String status;
    private long position;

    @Column(name = "created_at", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
        logger.info("onCreate called, createdAt set to {}", createdAt);
    }

    //getters and setters

    //return id
    public UUID getId() {
        return id;
    }
    //set id
    public void setId(UUID id) {
        this.id = id;
    }

    //Return appUser
    public AppUser getAppUser() {
        return appUser;
    }

    //Set appUser
    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    //Return status
    public String getStatus() {
        return status;
    }

    //Set status
    public void setStatus(String status) {
        this.status = status;
    }

    //Return date
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    //Set date
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    //Return position
    public long getPosition() {
        return position;
    }

    //Set position
    public void setPosition(long position) {
        this.position = position;
    }

}


