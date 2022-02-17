package knight.arkham.loan;

import knight.arkham.loan.entities.Client;
import knight.arkham.loan.services.ClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class LoanApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoanApplication.class, args);
    }


    @Bean
    public CommandLineRunner startup(ClientService clientService) {
        return args -> {

            List<Client> clients = new ArrayList<>();

            var client = new Client("Alex","Rodriguez","Calle 8", "8095824544", "22");
            var client2 = new Client("Pepe","Lorenzo","Calle 10", "8095824544", "25");
            var client3 = new Client("Pepe","Lorenzo","Calle 10", "8095824544", "25");
            var client4 = new Client("Pepe","Lorenzo","Calle 10", "8095824544", "25");
            var client5 = new Client("Pepe","Lorenzo","Calle 10", "8095824544", "25");
            var client6 = new Client("Pepe","Lorenzo","Calle 10", "8095824544", "25");

            clients.add(client);
            clients.add(client2);
            clients.add(client3);
            clients.add(client4);
            clients.add(client5);
            clients.add(client6);

            clientService.saveAllClients(clients);
        };
    }
}
