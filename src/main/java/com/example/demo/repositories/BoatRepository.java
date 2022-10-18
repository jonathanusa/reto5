package com.example.demo.repositories;

import com.example.demo.entities.Boat;
import com.example.demo.repositories.crudRepositories.BoatCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoatRepository {
    
    @Autowired
    private BoatCrudRepository boatCrudRepository;
    
    // Retorna todos los elementos de la tabla boat
    public List<Boat> getAll(){ return (List<Boat>) boatCrudRepository.findAll(); }
    
    // Retorna un elemento que refiera al identificador id de la tabla boat
    public Optional<Boat> getBoat( int id ) { return boatCrudRepository.findById(id); }
    
    // Guarda un elemento en la tabla boat
    public Boat save( Boat boat ) { return boatCrudRepository.save(boat); }
    
    // Borra un elemento de la tabla boat
    public void delete( Boat boat ) { boatCrudRepository.delete(boat); } 
    
}
