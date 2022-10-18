package com.example.demo.repositories;

import com.example.demo.entities.Admin;
import com.example.demo.repositories.crudRepositories.AdminCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminRepository {
    
    @Autowired
    private AdminCrudRepository adminCrudRepository;
    
    // Retorna todos los elementos de la tabla admin
    public List<Admin> getAll(){ return (List<Admin>) adminCrudRepository.findAll(); }
    
    // Retorna un elemento que refiera al identificador id de la tabla admin
    public Optional<Admin> getAdmin( int id ) { return adminCrudRepository.findById(id); }
    
    // Guarda un elemento en la tabla admin
    public Admin save( Admin admin ) { return adminCrudRepository.save(admin); }
    
    // Borra un elemento de la tabla admin
    public void delete( Admin admin ) { adminCrudRepository.delete(admin); } 
    
}
