package com.example.springboot_publish.fabuzhe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping(value = "/testPublish")
public class PublishController {

    @Resource
    private MQTTServer mqttserver;

    @Autowired
    private MsgRepository msgRepository;

    @RequestMapping(value = "testPublish")
    public String testPublish(String topic, String msg, int qos) {
        Mqtmsg mqtmsg = new Mqtmsg();
        mqtmsg.setTopic(topic);
        mqtmsg.setMsg(msg);
        mqtmsg.setQos(qos);
        Date date = new Date();
        mqtmsg.setDate(date);
        msgRepository.save(mqtmsg);
        mqttserver.sendMQTTMessage(topic, msg, qos);
        String data = "发送了一条主题是‘"+topic+"’，内容是:"+msg+"，消息级别 "+qos;
        return data;
    }

    /**
     * 订阅主题
     * @param topic 主题
     * @param qos 消息级别
     * @return
     */
    @RequestMapping(value = "testSubsribe")
    public String testSubsribe(String topic, int qos) {
        mqttserver.init(topic, qos);
        return "订阅主题'"+topic+"'成功";
    }
}
