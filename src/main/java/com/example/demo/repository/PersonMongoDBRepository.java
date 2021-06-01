package com.example.demo.repository;

import com.example.demo.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonMongoDBRepository extends MongoRepository<Person, String> {

}
