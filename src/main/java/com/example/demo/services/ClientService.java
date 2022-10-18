package com.example.demo.services;

import com.example.demo.entities.Client;
import com.example.demo.repositories.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepository;
    
    // Retorna todos los elementos de la tabla client
    public List<Client> getAll() { return clientRepository.getAll(); }
    
    // Retorna un elemento que refiera al identificador id de la tabla client
    public Optional<Client> getClient( int id ) { return clientRepository.getClient(id); }
    
    // Guarda un elemento en la tabla client
    public Client save( Client client ) { 
        
        if (client.getIdClient()== null) {
            return clientRepository.save(client);
        }
        else{
            Optional<Client> b = clientRepository.getClient(client.getIdClient());
            if ( b.isEmpty() ){ return clientRepository.save(client); }
            else{ return client; }
        }
    }
    
    // Actualiza un elemento en la tabla client
    public Client update ( Client client ){
        
        if( client.getIdClient()!= null ){
            
            Optional<Client> b = clientRepository.getClient(client.getIdClient());
            
            if( !b.isEmpty() ){
                
                // Se retornan los atributos en caso de que sean no nulos
                if( client.getName() != null ){ b.get().setName(client.getName()); }
                if( client.getEmail()!= null ){ b.get().setEmail(client.getEmail()); }
                if( client.getPassword()!= null ){ b.get().setPassword(client.getPassword()); }
                if( client.getAge() != null ){ b.get().setAge(client.getAge()); }
                if( client.getMessages() != null ){ b.get().setMessages(client.getMessages()); }
                if( client.getReservations() != null ){ b.get().setReservations(client.getReservations()); }

                
                // Se realiza la actualización del objeto con ayuda del repositorio
                clientRepository.save(b.get());
                return b.get();
            }
            else{
                return client;
            }
        }
        else{
            return client;
        }
    }
    
    // Elimina un elemento en la tabla client
    public boolean deleteClient( int id ){
        
        Boolean bBoolean = getClient(id).map( client -> {
            clientRepository.delete(client);
            return true;
        }).orElse(false);
        
        return bBoolean;
    }
    
}

