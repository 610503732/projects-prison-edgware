package cn.com.git.order.service;

import cn.com.git.order.service.feign.GoodsServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单服务
 */
@RestController
public class OrderService {

    //远程服务注入
    @Autowired
    private GoodsServiceFeign goodsServiceFeign ;

    /**
     * 通过订单 ID 获取订单详情
     * @return
     */
    @RequestMapping(value = "/orderDetail")
    public String orderDetail(@RequestParam("id") int id){

        //测试调用，写死即可
        return "订单 ID :" + id + "," + goodsServiceFeign.goodsDetail(1) ;
    }
}
