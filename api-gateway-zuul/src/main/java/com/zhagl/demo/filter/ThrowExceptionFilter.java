package com.zhagl.demo.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class ThrowExceptionFilter extends ZuulFilter {

    private static Logger logger = LoggerFactory.getLogger(ThrowExceptionFilter.class);

    @Override
    public String filterType() {
        /*过滤类型
        pre代表在请求路由之前执行。
        routing路由请求时被调用，但这里写是route
        post：在routing和error过滤器之后被调用
        error处理请求时发生错误时被调用*/
        //一般生命周期顺序是pre、routing、post。如果有错误时是error
        return "pre";
    }

    @Override
    public int filterOrder() {
        //过滤器的执行顺序。当请求在一个阶段中存在多个过滤器时，需要根据该方法返回的值来依次执行
        //数值越小优先级越高
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;//是否应该被过滤，true表示该过滤器对所有请求都会生效。
    }

    @Override
    public Object run() {//过滤器的具体逻辑
        logger.info("This is a pre filter, it will throw RuntimeException");
        doSomething();
        return null;
    }

    private void doSomething() {
        throw new RuntimeException("Exists some errors");
    }
}
