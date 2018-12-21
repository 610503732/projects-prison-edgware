package cn.com.git.goods.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品服务
 */
@RestController
public class GoodsService {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate ;

    /**
     * 通过商品代码获取商品详情
     * @return
     */
    @RequestMapping(value = "/goodsDetail")
    public String goodsDetail(@RequestParam("code") String code){
        //测试调用，写死即可
        return "商品代码：" + code ;
    }

    @RequestMapping(value = "/getGoods")
    public String getGoods(@RequestParam("code") String code){
        String val = (String)redisTemplate.execute(new RedisCallback() {
            @Override
            public String doInRedis(RedisConnection redisConnection) throws DataAccessException {

                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                byte[] key = serializer.serialize(code);
                byte[] value = redisConnection.get(key);
                if (value == null) {
                    return null;
                }
                return serializer.deserialize(value);
            }
        });

        return val ;
    }
}
