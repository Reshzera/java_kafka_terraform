package com.example.kafka_poc.controller;


import com.example.kafka_poc.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private KafkaProducerService kafkaProducerService;


    @PostMapping("/")
    public void createUser(){
        this.kafkaProducerService.send("userCreated");
    }
}
