package com.digi.kafkaproducer.controller;

import com.digi.kafkaproducer.domain.OrderEvent;
import com.digi.kafkaproducer.producer.OrderEventProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderEventProducer orderEventProducer;

    @PostMapping("/createOrder")
    public ResponseEntity<OrderEvent> postOrderEvent(@RequestBody OrderEvent orderEvent) throws JsonProcessingException {

        orderEventProducer.sendOrderEvent(orderEvent);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderEvent);
    }
}
