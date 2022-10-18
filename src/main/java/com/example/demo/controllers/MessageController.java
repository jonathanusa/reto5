package com.example.demo.controllers;

import com.example.demo.entities.Message;
import com.example.demo.services.MessageService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/Message")
public class MessageController {
    
    @Autowired
    private MessageService messageService;
    
    // Endpoint para retornar todos los elementos de la tabla
    @GetMapping("/all")
    public List<Message> getMessages(){ return messageService.getAll(); }
    
    // Endpoint para retornar un elemento particular de la tabla
    @GetMapping("/{id}")
    public Optional<Message> getMessage( @PathVariable("id") int messageId ){
        return messageService.getMessage(messageId);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save( @RequestBody Message message ){ return messageService.save(message); }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Message update( @RequestBody Message message ){ return messageService.update(message); }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete( @PathVariable("id") int messageId ){
        return messageService.deleteMessage(messageId);
    }
    
}
