package knight.arkham.loan;

import knight.arkham.loan.entities.Client;
import knight.arkham.loan.services.ClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.ArrayList;
import java.util.Date;
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

            var date = new Date();

            var client = new Client("Alex","Rodriguez","Calle 8", "8095824544",
                    "22",date,date,10000,10,0.5f);

            var client2 = new Client("Pepe","Lorenzo","Calle 10", "8095824544",
                    "22",date,date,10000,10,0.5f);


            clients.add(client);
            clients.add(client2);

            clientService.saveAllClients(clients);
        };
    }
}
