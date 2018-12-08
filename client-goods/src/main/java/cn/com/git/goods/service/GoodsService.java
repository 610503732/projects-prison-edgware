package cn.com.git.goods.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品服务
 */
@RestController
public class GoodsService {
    /**
     * 通过商品代码获取商品详情
     * @return
     */
    @RequestMapping(value = "/goodsDetail")
    public String goodsDetail(@RequestParam("code") int code){
        //测试调用，写死即可
        return "商品代码：" + code ;
    }
}
