package com.example.demo.controllers;

import com.example.demo.entities.Boat;
import com.example.demo.services.BoatService;
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
@RequestMapping("/api/Boat")
public class BoatController {
    
    @Autowired
    private BoatService boatService;
    
    // Endpoint para retornar todos los elementos de la tabla
    @GetMapping("/all")
    public List<Boat> getBoats(){ return boatService.getAll(); }
    
    // Endpoint para retornar un elemento particular de la tabla
    @GetMapping("/{id}")
    public Optional<Boat> getBoat( @PathVariable("id") int boatId ){
        return boatService.getBoat(boatId);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Boat save( @RequestBody Boat boat ){ return boatService.save(boat); }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Boat update( @RequestBody Boat boat ){ return boatService.update(boat); }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete( @PathVariable("id") int boatId ){
        return boatService.deleteBoat(boatId);
    }
    
}
