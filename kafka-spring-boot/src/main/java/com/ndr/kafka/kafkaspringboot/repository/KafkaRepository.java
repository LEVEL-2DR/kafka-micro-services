package com.ndr.kafka.kafkaspringboot.repository;

import com.ndr.kafka.kafkaspringboot.model.KafkaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author dinakar on 30/07/21
 */
@Repository
public interface KafkaRepository extends JpaRepository<KafkaModel,Integer> {
}
