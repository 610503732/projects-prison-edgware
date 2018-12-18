package cn.com.git.stream.bind;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding({Sink.class})
public class OrderServiceBind {

    @Autowired
    private Sink sink;

    @StreamListener(Sink.INPUT)
    public void receive(String payload) {
        System.out.println("order service Received: " + payload);
    }
}
