package cn.com.git.stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServerStreamApplicationTests {

    @Autowired
    private Sink sink;

    @Test
    public void contextLoads() {

        System.out.println(this.sink.input());
    }

}

