package com.example.demo.services;

import com.example.demo.entities.Admin;
import com.example.demo.repositories.AdminRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    
    @Autowired
    private AdminRepository adminRepository;
    
    // Retorna todos los elementos de la tabla admin
    public List<Admin> getAll() { return adminRepository.getAll(); }
    
    // Retorna un elemento que refiera al identificador id de la tabla admin
    public Optional<Admin> getAdmin( int id ) { return adminRepository.getAdmin(id); }
    
    // Guarda un elemento en la tabla admin
    public Admin save( Admin admin ) { 
        
        if (admin.getId() == null) {
            return adminRepository.save(admin);
        }
        else{
            Optional<Admin> b = adminRepository.getAdmin(admin.getId());
            if ( b.isEmpty() ){ return adminRepository.save(admin); }
            else{ return admin; }
        }
    }
    
    // Actualiza un elemento en la tabla admin
    public Admin update ( Admin admin ){
        
        if( admin.getId() != null ){
            
            Optional<Admin> b = adminRepository.getAdmin(admin.getId());
            
            if( !b.isEmpty() ){
                
                // Se retornan los atributos en caso de que sean no nulos
                if( admin.getName() != null ){ b.get().setName(admin.getName()); }
                if( admin.getEmail()!= null ){ b.get().setEmail(admin.getEmail()); }
                if( admin.getPassword() != null ){ b.get().setPassword(admin.getPassword()); }
                
                // Se realiza la actualización del objeto con ayuda del repositorio
                adminRepository.save(b.get());
                return b.get();
            }
            else{
                return admin;
            }
        }
        else{
            return admin;
        }
    }
    
    // Elimina un elemento en la tabla admin
    public boolean deleteAdmin( int id ){
        
        Boolean bBoolean = getAdmin(id).map( admin -> {
            adminRepository.delete(admin);
            return true;
        }).orElse(false);
        
        return bBoolean;
    }
    
}

