package com.example.demo;

import com.example.demo.repository.PersonMongoDBRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpringBootMongoDBTest {

    @Autowired
    private PersonMongoDBRepository personMongoDBRepository;

    @Test
    public void printProjectData() {
        System.out.println(personMongoDBRepository.findAll());
    }

}
