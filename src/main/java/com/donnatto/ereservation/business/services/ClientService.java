package com.donnatto.ereservation.business.services;

import com.donnatto.ereservation.business.repository.ClientRepository;
import com.donnatto.ereservation.model.Client;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class to define client services
 * @author donnatto
 */
@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    /**
     * method to save a client in the DB
     * @param client
     * @return
     */
    public Client create(Client client) {
        return clientRepository.save(client);
    }

    /**
     * method to update a client from the DB
     * @param client
     * @return
     */
    public Client update(Client client) {
        return clientRepository.save(client);
    }

    /**
     * method to delete a client from the DB
     * @param client
     */
    public void delete(Client client) {
        clientRepository.delete(client);
    }

    /**
     * method to get clients by their last name
     * @param lastName
     * @return
     */
    public List<Client> findByLastName(String lastName) {
        return clientRepository.findByCliLastName(lastName);
    }
}
