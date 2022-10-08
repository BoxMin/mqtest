package com.example.springboot_publish.fabuzhe;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Mqtmsg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String topic;

    @Column(nullable = false)
    private String msg;

    @Column(nullable = false)
    private int qos;

    @CreatedDate
    @Column(name = "create_time")
    private Date date;
}
