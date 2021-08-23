package com.ndr.kafka.kafkaspringboot.controller;

import com.ndr.kafka.kafkaspringboot.model.KafkaModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dinakar on 29/07/21
 */
@RestController
@RequestMapping("kafka")
public class KafkaController {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC1_NAME = "TOPIC1";
    private static final String TOPIC2_NAME = "TOPIC2";

    @GetMapping("/produce/message")
    @ApiOperation(value = "Produce Message to KAFKA")
    public ResponseEntity<String> produceMessage(@RequestParam("message") final String message) {

        try {
            kafkaTemplate.send(TOPIC1_NAME, message);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }
        return new ResponseEntity<>("published Successfully:: "+message, HttpStatus.OK);
    }

    @GetMapping("/produce/model")
    @ApiOperation(value = "Produce Model to KAFKA")
    public ResponseEntity<String> produceModel(@RequestParam("message") final String name) {

        try {
            kafkaTemplate.send(TOPIC1_NAME, new KafkaModel(name,12345,"JOBNAME").toString());
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }
        return new ResponseEntity<>("published Successfully:: "+name, HttpStatus.OK);
    }
    @PostMapping("/produce/model")
    @ApiOperation(value = "Produce Model to KAFKA - POST")
    public ResponseEntity<String> producePostModel(@RequestBody final KafkaModel kafkaModel) {

        try {
            kafkaTemplate.send(TOPIC2_NAME,kafkaModel.toString());
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }
        return new ResponseEntity<>("published Successfully:: "+ kafkaModel, HttpStatus.OK);
    }
}
