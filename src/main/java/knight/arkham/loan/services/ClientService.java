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


    public List<Client> updateClient(Client client) {

        var actualVideoGame = clientRepository.findClientById(client.getId());

        actualVideoGame.setName(client.getName());
        actualVideoGame.setLastName(client.getLastName());
        actualVideoGame.setDirection(client.getDirection());
        actualVideoGame.setPhoneNumber(client.getPhoneNumber());
        actualVideoGame.setAge(client.getAge());
        actualVideoGame.setLoanStartDate(client.getLoanStartDate());
        actualVideoGame.setLoanEndDate(client.getLoanEndDate());
        actualVideoGame.setLoanTerms(client.getLoanTerms());
        actualVideoGame.setLoanInterest(client.getLoanInterest());
        actualVideoGame.setLoanInterest(client.getLoanQuantity());

        clientRepository.save(actualVideoGame);

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
