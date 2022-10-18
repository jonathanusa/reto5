package com.example.demo.repositories.crudRepositories;


import com.example.demo.entities.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientCrudRepository extends CrudRepository<Client, Integer>{
    
}
