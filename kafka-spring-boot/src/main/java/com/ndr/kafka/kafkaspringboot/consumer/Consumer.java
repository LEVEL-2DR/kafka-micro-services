package com.ndr.kafka.kafkaspringboot.consumer;

import com.ndr.kafka.kafkaspringboot.model.KafkaModel;
import com.ndr.kafka.kafkaspringboot.repository.KafkaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @author dinakar on 29/07/21
 */
@Service
public class Consumer {

    @Autowired
    private KafkaRepository kafkaRepository;

    @KafkaListener(topics = "TOPIC1", groupId = "group_1")
    public void consume1(String message) {
        System.out.println("message is Consumed by consumer1 & TOPIC1:: " + message);
    }

    @KafkaListener(topics = "TOPIC1", groupId = "group_2")
    public void consume2(String message) {
        System.out.println("message is Consumed by consumer2 & TOPIC1:: " + message);
    }


    @KafkaListener(topics = "TOPIC2", groupId = "group_1")
    public void consume3(String message) {
        System.out.println("message is Consumed by consumer1 & TOPIC2:: " + message);
    }

    @KafkaListener(topics = "TOPIC2", groupId = "group_2")
    public void consume4(String message) {
        KafkaModel kafkaModel = new KafkaModel("TOPIC", 12345, message);
        kafkaRepository.save(kafkaModel);
        System.out.println("message is Consumed by consumer2 & TOPIC2:: " + message);
    }
}
