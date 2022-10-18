package com.example.demo.repositories.crudRepositories;

import com.example.demo.entities.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message, Integer>{
    
}
