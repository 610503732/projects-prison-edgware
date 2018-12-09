package cn.com.git.order.service.hystrix;

import cn.com.git.order.service.feign.GoodsServiceFeign;
import org.springframework.stereotype.Component;

/**
 * 商品服务熔断回调
 */
@Component
public class GoodsServiceCallBack implements GoodsServiceFeign {

    @Override
    public String goodsDetail(int code) {
        System.out.println("----------------- 商品服务 熔断 ------------------");
        return "商品服务调用异常";
    }
}
