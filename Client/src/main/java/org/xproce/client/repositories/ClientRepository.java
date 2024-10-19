package org.xproce.client.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.xproce.client.entities.Client;


public interface ClientRepository extends JpaRepository<Client,Long> {

}
