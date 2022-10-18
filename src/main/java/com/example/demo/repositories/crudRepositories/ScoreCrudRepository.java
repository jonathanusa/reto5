package com.example.demo.repositories.crudRepositories;

import com.example.demo.entities.Score;
import org.springframework.data.repository.CrudRepository;

public interface ScoreCrudRepository extends CrudRepository<Score, Integer>{
    
}
