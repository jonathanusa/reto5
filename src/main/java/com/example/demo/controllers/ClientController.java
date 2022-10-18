package com.example.demo.controllers;

import com.example.demo.entities.Client;
import com.example.demo.services.ClientService;
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
@RequestMapping("/api/Client")
public class ClientController {
    
    @Autowired
    private ClientService clientService;
    
    // Endpoint para retornar todos los elementos de la tabla
    @GetMapping("/all")
    public List<Client> getClients(){ return clientService.getAll(); }
    
    // Endpoint para retornar un elemento particular de la tabla
    @GetMapping("/{id}")
    public Optional<Client> getClient( @PathVariable("id") int clientId ){
        return clientService.getClient(clientId);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client save( @RequestBody Client client ){ return clientService.save(client); }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Client update( @RequestBody Client client ){ return clientService.update(client); }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete( @PathVariable("id") int clientId ){
        return clientService.deleteClient(clientId);
    }
    
}
