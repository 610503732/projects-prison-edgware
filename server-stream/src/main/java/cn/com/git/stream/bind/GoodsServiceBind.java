package cn.com.git.stream.bind;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@EnableBinding({Source.class})
public class GoodsServiceBind {

    //注入接口和注入MessageChannel的区别在于发送时需不需要调用接口内的方法
    @Autowired
    private Source source;

//    @SendTo(Source.OUTPUT)
    public void send(String payload) {
        System.out.println("goods service send:" + payload);
        source.output().send(MessageBuilder.withPayload(payload).build());
    }
}
