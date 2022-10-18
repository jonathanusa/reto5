
package com.example.demo.repositories;

import com.example.demo.entities.Category;
import com.example.demo.repositories.crudRepositories.CategoryCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryRepository {
    
    @Autowired
    private CategoryCrudRepository categoryCrudRepository;
    
    // Retorna todos las elementos de la tabla category
    public List<Category> getAll(){ return (List<Category>) categoryCrudRepository.findAll(); }
    
    // Retorna un elemento que refiera al identificador id de la tabla category
    public Optional<Category> getCategory( int id ) { return categoryCrudRepository.findById(id); }
    
    // Guarda un elemento en la tabla category
    public Category save( Category category ) { return categoryCrudRepository.save(category); }
    
    // Borra un elemento de la tabla category
    public void delete( Category category ) { categoryCrudRepository.delete(category); }
}
