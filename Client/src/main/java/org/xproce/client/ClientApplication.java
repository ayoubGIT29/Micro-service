package org.xproce.client;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.xproce.client.entities.Client;
import org.xproce.client.repositories.ClientRepository;

@EnableDiscoveryClient
@SpringBootApplication
public class ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @Bean
    CommandLineRunner createClients(ClientRepository clientRepository) {
        return args -> {
            // Create some client instances
            clientRepository.save(new Client(null, "Alice", 30.5f));
            clientRepository.save(new Client(null, "Bob", 45.2f));
            clientRepository.save(new Client(null, "Charlie", 27.8f));

            // Display the saved clients
            clientRepository.findAll().forEach(client -> {
                System.out.println(client.getNom() + " - Age: " + client.getAge());
            });
        };
    }
}
