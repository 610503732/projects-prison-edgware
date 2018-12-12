package cn.com.git.zuul.fallback.provider;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * zuul 中 order 服务 的 Hystrix 路由回退
 */
@Component
public class OrderFallbackProvider implements ZuulFallbackProvider {
    @Override
    public String getRoute() {
        //api服务id，如果需要所有调用都支持回退，则return "*"或return null
        return "client-order";
    }

    /**
     * 如果请求用户服务失败，返回什么信息给消费者客户端
     * @return
     */
    @Override
    public ClientHttpResponse fallbackResponse() {

        return new ClientHttpResponse() {

            @Override
            public HttpHeaders getHeaders() {
                //响应头
                HttpHeaders headers = new HttpHeaders();
                //和body中的内容编码一致，否则容易乱码
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }

            @Override
            public InputStream getBody() throws IOException {
                //响应 body
                return new ByteArrayInputStream("fallback 调用失败".getBytes());
            }

            /**
             * 网关向api服务请求是失败了，但是消费者客户端向网关发起的请求是OK的，
             * 不应该把api的404,500等问题抛给客户端
             * 网关和api服务集群对于客户端来说是黑盒子
             */
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return 200;
            }

            @Override
            public String getStatusText() throws IOException {
                return "OK";
            }

            @Override
            public void close() {

            }
        };
    }
}
