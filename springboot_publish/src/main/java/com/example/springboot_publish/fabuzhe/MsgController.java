package com.example.springboot_publish.fabuzhe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/testMsg")
public class MsgController {
    @Autowired
    private MsgRepository msgRepository;

    @RequestMapping(value = "/findall")
    public List<Mqtmsg> findAll(){
        List<Mqtmsg> msgList = msgRepository.findAll();
        return msgList;
    }
}
