package com.example.demo.controllers;

import com.example.demo.entities.Score;
import com.example.demo.services.ScoreService;
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
@RequestMapping("/api/Score")
public class ScoreController {
    
    @Autowired
    private ScoreService scoreService;
    
    // Endpoint para retornar todos los elementos de la tabla
    @GetMapping("/all")
    public List<Score> getScores(){ return scoreService.getAll(); }
    
    // Endpoint para retornar un elemento particular de la tabla
    @GetMapping("/{id}")
    public Optional<Score> getScore( @PathVariable("id") int scoreId ){
        return scoreService.getScore(scoreId);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Score save( @RequestBody Score score ){ return scoreService.save(score); }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Score update( @RequestBody Score score ){ return scoreService.update(score); }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete( @PathVariable("id") int scoreId ){
        return scoreService.deleteScore(scoreId);
    }
    
}
