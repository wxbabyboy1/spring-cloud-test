package com.zhagl.demo.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class AccessFilter extends ZuulFilter {

    private static Logger logger = LoggerFactory.getLogger(AccessFilter.class);

    @Override
    public String filterType() {
        return "pre";//过滤类型，pre代表在请求路由之前执行。
    }

    @Override
    public int filterOrder() {
        return 0;//过滤器的执行顺序。当请求在一个阶段中存在多个过滤器时，需要根据该方法返回的值来依次执行
    }

    @Override
    public boolean shouldFilter() {
        return true;//是否应该被过滤，true表示该过滤器对所有请求都会生效。
    }

    @Override
    public Object run() {//过滤器的具体逻辑
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        logger.info("send {} request to {}", request.getMethod(), request.getRequestURL().toString());

        Object accessToken = request.getParameter("accessToken");//请求参数
        if(accessToken == null){
            logger.warn("access token is empty");
            ctx.setSendZuulResponse(false);//过滤该请求，不对其进行路由。
            ctx.setResponseStatusCode(401);//设置其返回的错误码
            return null;
        }
        logger.info("access token ok");
        return null;
    }
}
