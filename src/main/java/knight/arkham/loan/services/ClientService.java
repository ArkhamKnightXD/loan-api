package knight.arkham.loan.services;

import knight.arkham.loan.entities.Client;
import knight.arkham.loan.repositories.ClientRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    public List<Client> getAllClients() {

        return clientRepository.findAll();
    }


    public Client getClientById(long clientId) {

        return clientRepository.findClientById(clientId);
    }


    public List<Client> saveClient(Client client) {

        clientRepository.save(client);

        return clientRepository.findAll();
    }


    public void saveAllClients(List<Client> clients) {

        clientRepository.saveAll(clients);
    }


    public List<Client> updateClient(Client updatedClient) {

        var actualClient = clientRepository.findClientById(updatedClient.getId());

        actualClient.setName(updatedClient.getName());
        actualClient.setLastName(updatedClient.getLastName());
        actualClient.setDirection(updatedClient.getDirection());
        actualClient.setPhoneNumber(updatedClient.getPhoneNumber());
        actualClient.setAge(updatedClient.getAge());

        clientRepository.save(actualClient);

        return clientRepository.findAll();
    }


    public void deleteClientById(long clientId){

        try {

            clientRepository.deleteById(clientId);
        }catch (Exception exception){

            System.out.println(exception.getMessage());
        }
    }
}
