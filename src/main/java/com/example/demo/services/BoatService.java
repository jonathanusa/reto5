package com.example.demo.services;

import com.example.demo.entities.Boat;
import com.example.demo.repositories.BoatRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoatService {
    
    @Autowired
    private BoatRepository boatRepository;
    
    // Retorna todos los elementos de la tabla boat
    public List<Boat> getAll() { return boatRepository.getAll(); }
    
    // Retorna un elemento que refiera al identificador id de la tabla boat
    public Optional<Boat> getBoat( int id ) { return boatRepository.getBoat(id); }
    
    // Guarda un elemento en la tabla boat
    public Boat save( Boat boat ) { 
        
        if (boat.getId() == null) {
            return boatRepository.save(boat);
        }
        else{
            Optional<Boat> b = boatRepository.getBoat(boat.getId());
            if ( b.isEmpty() ){ return boatRepository.save(boat); }
            else{ return boat; }
        }
    }
    
    // Actualiza un elemento en la tabla boat
    public Boat update ( Boat boat ){
        
        if( boat.getId() != null ){
            
            Optional<Boat> b = boatRepository.getBoat(boat.getId());
            
            if( !b.isEmpty() ){
                
                // Se retornan los atributos en caso de que sean no nulos
                if( boat.getName() != null ){ b.get().setName(boat.getName()); }
                if( boat.getBrand() != null ){ b.get().setBrand(boat.getBrand()); }
                if( boat.getYear() != null ){ b.get().setYear(boat.getYear()); }
                if( boat.getDescription() != null ){ b.get().setDescription(boat.getDescription()); }
                if( boat.getCategory() != null ){ b.get().setCategory(boat.getCategory()); }
                
                // Se realiza la actualización del objeto con ayuda del repositorio
                boatRepository.save(b.get());
                return b.get();
            }
            else{
                return boat;
            }
        }
        else{
            return boat;
        }
    }
    
    // Elimina un elemento en la tabla boat
    public boolean deleteBoat( int id ){
        
        Boolean bBoolean = getBoat(id).map( boat -> {
            boatRepository.delete(boat);
            return true;
        }).orElse(false);
        
        return bBoolean;
    }
    
}

