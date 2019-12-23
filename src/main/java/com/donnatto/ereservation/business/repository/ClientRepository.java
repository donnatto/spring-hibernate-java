package com.donnatto.ereservation.business.repository;

import com.donnatto.ereservation.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Interface to define DB operations related to client
 * @author donnatto
 */
public interface ClientRepository extends JpaRepository<Client, String> {

    /**
     * Method to find clients by last name
     * @param cliLastName last name of the client
     * @return returns a list of clients
     */
    public List<Client> findByCliLastName(String cliLastName);

    /**
     * Method to find a client by identification
     * @param identification
     * @return
     */
    public Client findByCliIdentification(String identification);
}
