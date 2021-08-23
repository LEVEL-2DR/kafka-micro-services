package com.ndr.kafka.kafkaspringboot.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author dinakar on 29/07/21
 */
@Setter
@Getter
@Entity
@Table(name = "kafka_model_t")
public class KafkaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "job_name")
    private String jobName;

    public KafkaModel() {
    }

    public KafkaModel(String name, int id, String jobName) {
        this.name = name;
        this.id = id;
        this.jobName = jobName;
    }

    @Override
    public String toString() {
        return "KafkaModel{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", jobName='" + jobName + '\'' +
                '}';
    }
}
