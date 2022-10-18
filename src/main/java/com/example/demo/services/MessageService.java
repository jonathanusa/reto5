package com.example.demo.services;

import com.example.demo.entities.Message;
import com.example.demo.repositories.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    
    @Autowired
    private MessageRepository messageRepository;
    
    // Retorna todos los elementos de la tabla message
    public List<Message> getAll() { return messageRepository.getAll(); }
    
    // Retorna un elemento que refiera al identificador id de la tabla message
    public Optional<Message> getMessage( int id ) { return messageRepository.getMessage(id); }
    
    // Guarda un elemento en la tabla message
    public Message save( Message message ) { 
        
        if (message.getIdMessage() == null) {
            return messageRepository.save(message);
        }
        else{
            Optional<Message> b = messageRepository.getMessage(message.getIdMessage());
            if ( b.isEmpty() ){ return messageRepository.save(message); }
            else{ return message; }
        }
    }
    
    // Actualiza un elemento en la tabla message
    public Message update ( Message message ){
        
        if( message.getIdMessage() != null ){
            
            Optional<Message> b = messageRepository.getMessage(message.getIdMessage());
            
            if( !b.isEmpty() ){
                
                // Se retornan los atributos en caso de que sean no nulos
                if( message.getMessageText()!= null ){ b.get().setMessageText(message.getMessageText()); }
                if( message.getClient()!= null ){ b.get().setClient(message.getClient()); }
                if( message.getBoat()!= null ){ b.get().setBoat(message.getBoat()); }

                
                // Se realiza la actualización del objeto con ayuda del repositorio
                messageRepository.save(b.get());
                return b.get();
            }
            else{
                return message;
            }
        }
        else{
            return message;
        }
    }
    
    // Elimina un elemento en la tabla message
    public boolean deleteMessage( int id ){
        
        Boolean bBoolean = getMessage(id).map( message -> {
            messageRepository.delete(message);
            return true;
        }).orElse(false);
        
        return bBoolean;
    }
    
}

