package org.example.servicevoiture;

import org.example.servicevoiture.entities.Client;
import org.example.servicevoiture.entities.Voiture;
import org.example.servicevoiture.repositories.VoitureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class ServiceVoitureApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceVoitureApplication.class, args);
    }
    @Bean
    CommandLineRunner initData(VoitureRepository voitureRepository) {
        return args -> {
            // Créer des clients sans utiliser le ClientRepository
            Client client1 = new Client(1L, "Alice", 30f);
            Client client2 = new Client(2L, "Bob", 25f);

            // Créer des voitures en utilisant id_client au lieu de l'objet Client
            Voiture voiture1 = new Voiture(null, "Toyota", "ABC123", "Corolla", client1.getId(),client1);
            Voiture voiture2 = new Voiture(null, "Honda", "XYZ456", "Civic", client1.getId(),client1);
            Voiture voiture3 = new Voiture(null, "Ford", "DEF789", "Focus", client2.getId(),client2);

            // Enregistrer les voitures dans la base de données
            voitureRepository.saveAll(Arrays.asList(voiture1, voiture2, voiture3));

            System.out.println("Données insérées dans la base de données H2.");
        };
    }

}
