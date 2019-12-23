package com.donnatto.ereservation.resources;

import com.donnatto.ereservation.business.services.ClientService;
import com.donnatto.ereservation.model.Client;
import com.donnatto.ereservation.resources.vo.ClientVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Class to represent client web service
 * @author donnatto
 */
@RestController
@RequestMapping("/api/client")
public class ClientResource {

    private final ClientService clientService;

    public ClientResource(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody ClientVO clientVo) {
        Client client = new Client();
        client.setCliName(clientVo.getCliName());
        client.setCliLastName(clientVo.getCliLastName());
        client.setCliAddress(clientVo.getCliAddress());
        client.setCliPhone(clientVo.getCliPhone());
        client.setCliEmail(clientVo.getCliEmail());
        return new ResponseEntity<>(clientService.create(client), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable("id") String id, @RequestBody ClientVO clientVo) {
        Client client = clientService.findByIdentification(id);
        if (client == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            client.setCliName(clientVo.getCliName());
            client.setCliLastName(clientVo.getCliLastName());
            client.setCliAddress(clientVo.getCliAddress());
            client.setCliPhone(clientVo.getCliPhone());
            client.setCliEmail(clientVo.getCliEmail());
            return new ResponseEntity<>(clientService.update(client), HttpStatus.OK);
        }
    }
}
