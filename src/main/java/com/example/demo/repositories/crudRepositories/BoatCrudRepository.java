package com.example.demo.repositories.crudRepositories;

import com.example.demo.entities.Boat;
import org.springframework.data.repository.CrudRepository;

public interface BoatCrudRepository extends CrudRepository<Boat, Integer>{
    
}
