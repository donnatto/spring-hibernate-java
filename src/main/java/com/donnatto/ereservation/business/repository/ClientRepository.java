package com.donnatto.ereservation.business.repository;

import com.donnatto.ereservation.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface to define DB operations related to client
 * @author donnatto
 */
public interface ClientRepository extends JpaRepository<Client, String> {
}
