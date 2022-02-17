package knight.arkham.loan.controllers;

import io.swagger.v3.oas.annotations.Operation;
import knight.arkham.loan.entities.Client;
import knight.arkham.loan.services.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }


    @GetMapping("/clients")
    @Operation(summary = "Get All Clients", description = "Consigue la lista de todos los clients")
    public ResponseEntity<List<Client>> getAllClients() {

        return new ResponseEntity<>(clientService.getAllClients(), HttpStatus.OK);
    }


    @GetMapping("/clients/{clientId}")
    @Operation(summary = "Get A Client By Id", description = "Retorna un cliente con el id correspondiente")
    public ResponseEntity<Client> getClientById(@PathVariable long clientId) {

        var actualClient = clientService.getClientById(clientId);

        if (actualClient != null)
            return new ResponseEntity<>(actualClient, HttpStatus.OK);

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }


    @PostMapping("/clients")
    @Operation(summary = "Save Client", description = "Crear cliente")
    public ResponseEntity<List<Client>> saveClient(@RequestBody Client clientToSave) {

        var clients= clientService.saveClient(clientToSave);

        return new ResponseEntity<>(clients, HttpStatus.OK);
    }


    @PutMapping("/clients")
    @Operation(summary = "Update Client", description = "Actualiza el cliente enviado")
    public ResponseEntity<List<Client>> updateClient(@RequestBody Client updatedClient) {

        var clients = clientService.updateClient(updatedClient);

        return new ResponseEntity<>(clients, HttpStatus.OK);
    }


    @DeleteMapping("/clients/{clientId}")
    @Operation(summary = "Delete A Client By Id", description = "Elimina un cliente con el id correspondiente")
    public ResponseEntity<List<Client>> deleteClientById(@PathVariable long clientId) {

        clientService.deleteClientById(clientId);

        return new ResponseEntity<>(clientService.getAllClients(), HttpStatus.OK);
    }
}
