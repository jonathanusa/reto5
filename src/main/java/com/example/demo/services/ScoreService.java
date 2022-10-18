package com.example.demo.services;

import com.example.demo.entities.Score;
import com.example.demo.repositories.ScoreRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreService {
    
    @Autowired
    private ScoreRepository scoreRepository;
    
    // Retorna todos los elementos de la tabla score
    public List<Score> getAll() { return scoreRepository.getAll(); }
    
    // Retorna un elemento que refiera al identificador id de la tabla score
    public Optional<Score> getScore( int id ) { return scoreRepository.getScore(id); }
    
    // Guarda un elemento en la tabla score
    public Score save( Score score ) { 
        
        if (score.getId() == null) {
            return scoreRepository.save(score);
        }
        else{
            Optional<Score> b = scoreRepository.getScore(score.getId());
            if ( b.isEmpty() ){ return scoreRepository.save(score); }
            else{ return score; }
        }
    }
    
    // Actualiza un elemento en la tabla score
    public Score update ( Score score ){
        
        if( score.getId() != null ){
            
            Optional<Score> b = scoreRepository.getScore(score.getId());
            
            if( !b.isEmpty() ){
                
                // Se retornan los atributos en caso de que sean no nulos
                if( score.getScore()!= null ){ b.get().setScore(score.getScore()); }
                if( score.getReservations()!= null ){ b.get().setReservations(score.getReservations()); }
                
                
                // Se realiza la actualización del objeto con ayuda del repositorio
                scoreRepository.save(b.get());
                return b.get();
            }
            else{
                return score;
            }
        }
        else{
            return score;
        }
    }
    
    // Elimina un elemento en la tabla score
    public boolean deleteScore( int id ){
        
        Boolean bBoolean = getScore(id).map( score -> {
            scoreRepository.delete(score);
            return true;
        }).orElse(false);
        
        return bBoolean;
    }
    
}

