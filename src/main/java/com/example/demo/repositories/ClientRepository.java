package com.example.demo.repositories;

import com.example.demo.entities.Client;
import com.example.demo.repositories.crudRepositories.ClientCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClientRepository {
    
    @Autowired
    private ClientCrudRepository clientCrudRepository;
    
    // Retorna todos los elementos de la tabla client
    public List<Client> getAll(){ return (List<Client>) clientCrudRepository.findAll(); }
    
    // Retorna un elemento que refiera al identificador id de la tabla client
    public Optional<Client> getClient( int id ) { return clientCrudRepository.findById(id); }
    
    // Guarda un elemento en la tabla client
    public Client save( Client client ) { return clientCrudRepository.save(client); }
    
    // Borra un elemento de la tabla client
    public void delete( Client client ) { clientCrudRepository.delete(client); } 
    
}
