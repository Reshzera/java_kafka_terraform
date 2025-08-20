package com.example.kafka_poc.controller;

import com.example.kafka_poc.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PurchaseController {
    @Autowired
    private KafkaProducerService kafkaProducerService;

    @KafkaListener(
            topics = "purchase-initiate",
            groupId = "purchase-service")
    public void createUser(){
        this.kafkaProducerService.send("purchase-done","some-product-id");
    }
}
