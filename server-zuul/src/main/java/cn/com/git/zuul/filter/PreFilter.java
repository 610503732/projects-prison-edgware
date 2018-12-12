package cn.com.git.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 前置过滤器
 */
@Component
//配置自动刷新
@RefreshScope
public class PreFilter extends ZuulFilter {

    @Value("${tokenCheck}")
    private boolean tokenCheck ;

    @Value("${token}")
    private String token ;

    @Override
    public String filterType() {//过滤器类型
        //过滤器属于四大类中的哪一类，小写，pre/error/router/post ,网关提供了一个常量类
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {//同类型间优先级
        //同一级别内部，排序，过滤器的顺序
        //数值越小，优先级越高，可以为负数
        return 0;
    }

    @Override
    public boolean shouldFilter() {//过滤器是否起作用
        //当前过滤器是否生效
        return true;
    }

    @Override
    public Object run() {//过滤器业务，返回值目前没有用

        /**
         * 这里实现一个简单的 token 令牌校验
         */
        //打印远程配置服务的 token
        System.out.println("--------------打印远程配置服务 tokenCheck --- "+ tokenCheck +" -----------------");
        System.out.println("--------------打印远程配置服务 token --- "+ token +" -----------------");

        //获取多个过滤器间公用的上下文
        RequestContext ctx = RequestContext.getCurrentContext();
        //获取请求
        HttpServletRequest request = ctx.getRequest();
        //获取请求头信息
        String _token = request.getHeader("token") ;

        //如果 token 令牌为空，则说明未登录或者其他无权限操作，则拦截
        if(StringUtils.isEmpty(_token) ){
            //表示没必要进行路由转发
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            ctx.setResponseBody("{\"msg:\"useless token \"");
            return "access denied" ;
        }

        //目前返回参数吴用，可以预置，方便以后拓展
        return "pass";
    }

}