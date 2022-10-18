package com.example.demo.repositories;

import com.example.demo.entities.Score;
import com.example.demo.repositories.crudRepositories.ScoreCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ScoreRepository {
    
    @Autowired
    private ScoreCrudRepository scoreCrudRepository;
    
    // Retorna todos los elementos de la tabla score
    public List<Score> getAll(){ return (List<Score>) scoreCrudRepository.findAll(); }
    
    // Retorna un elemento que refiera al identificador id de la tabla score
    public Optional<Score> getScore( int id ) { return scoreCrudRepository.findById(id); }
    
    // Guarda un elemento en la tabla score
    public Score save( Score score ) { return scoreCrudRepository.save(score); }
    
    // Borra un elemento de la tabla score
    public void delete( Score score ) { scoreCrudRepository.delete(score); } 
    
}
