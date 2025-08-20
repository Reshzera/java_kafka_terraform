package com.example.kafka_poc.controller;


import com.example.kafka_poc.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
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
        this.kafkaProducerService.send("purchase-initiate","some-product-id");
    }

    @KafkaListener(
            topics = "purchase-done",
            groupId = "user-service")
    public void updateUserPurchase(String message){
        System.out.println("Chegou a menssagem" + message);
    }
}
