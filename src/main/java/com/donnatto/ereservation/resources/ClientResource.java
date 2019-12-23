package com.donnatto.ereservation.resources;

import com.donnatto.ereservation.business.services.ClientService;
import com.donnatto.ereservation.model.Client;
import com.donnatto.ereservation.resources.vo.ClientVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Class to represent client web service
 *
 * @author donnatto
 */
@RestController
@RequestMapping("/api/client")
@Api(tags = "client")
public class ClientResource {

    private final ClientService clientService;

    public ClientResource(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    @ApiOperation(value = "Create client", notes = "Service to create a new client")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Client created succesfully"), @ApiResponse(code = 400, message = "Invalid request")})
    public ResponseEntity<Client> createClient(@RequestBody ClientVO clientVo) {
        Client client = new Client();
        client.setCliIdentification(clientVo.getCliIdentification());
        client.setCliName(clientVo.getCliName());
        client.setCliLastName(clientVo.getCliLastName());
        client.setCliAddress(clientVo.getCliAddress());
        client.setCliPhone(clientVo.getCliPhone());
        client.setCliEmail(clientVo.getCliEmail());
        return new ResponseEntity<>(clientService.create(client), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update client", notes = "Service to update a client")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Client updated succesfully"), @ApiResponse(code = 404, message = "Client not found")})
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

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete client", notes = "Service to delete a client")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Client deleted succesfully"), @ApiResponse(code = 404, message = "Client not found")})
    public void removeClient(@PathVariable("id") String id) {
        Client client = clientService.findByIdentification("id");
        if (client != null) {
            clientService.delete(client);
        }
    }

    @GetMapping
    @ApiOperation(value = "List clients", notes = "Service to list all clients")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Clients found"), @ApiResponse(code = 404, message = "Clients not found")})
    public ResponseEntity<List<Client>> findAll() {
        return ResponseEntity.ok(clientService.findAll());
    }
}
