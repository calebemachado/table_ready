package br.com.calebemachado.tableready.repository;

import br.com.calebemachado.tableready.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AppUserRepository extends JpaRepository<AppUser, UUID> {
}
