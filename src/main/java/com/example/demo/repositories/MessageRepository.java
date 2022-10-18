package com.example.demo.repositories;

import com.example.demo.entities.Message;
import com.example.demo.repositories.crudRepositories.MessageCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MessageRepository {
    
    @Autowired
    private MessageCrudRepository messageCrudRepository;
    
    // Retorna todos los elementos de la tabla message
    public List<Message> getAll(){ return (List<Message>) messageCrudRepository.findAll(); }
    
    // Retorna un elemento que refiera al identificador id de la tabla message
    public Optional<Message> getMessage( int id ) { return messageCrudRepository.findById(id); }
    
    // Guarda un elemento en la tabla message
    public Message save( Message message ) { return messageCrudRepository.save(message); }
    
    // Borra un elemento de la tabla message
    public void delete( Message message ) { messageCrudRepository.delete(message); } 
    
}
