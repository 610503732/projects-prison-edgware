package cn.com.git.payment.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 支付服务
 */
@RestController
public class PaymentService {

    /**
     * 模拟支付数额
     * @return
     */
    @RequestMapping(value = "/consume")
    public String goodsDetail(@RequestParam("amount") int amount){
        //测试调用，写死即可
        return "消费金额：￥" + amount ;
    }


}
