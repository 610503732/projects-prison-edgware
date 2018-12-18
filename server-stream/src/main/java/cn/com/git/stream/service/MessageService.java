package cn.com.git.stream.service;

import cn.com.git.stream.bind.GoodsServiceBind;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/message")
public class MessageService {

    @Autowired
    private GoodsServiceBind goodsServiceBind ;

    /**
     * 发送商品信息
     * @param name
     */
    @RequestMapping(value = "/goods")
    public void goodsSendMsg(@RequestParam("name") String name){
        goodsServiceBind.send(name);
    }

}
