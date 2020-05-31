package com.zhagl.demo.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter;
import org.springframework.stereotype.Component;

@Component
public class ErrorExtFilter extends SendErrorFilter {

    public String filterType() {
        return "error";
    }

    public int filterOrder() {
        return 30;//大于ErrorFilter的值
    }

    public boolean shouldFilter() {
        //仅判断处理来自post过滤器引起的异常
        RequestContext ctx = RequestContext.getCurrentContext();
        //读取上下文中存储的异常过滤器实例
        ZuulFilter failedFilter = (ZuulFilter) ctx.get("failed.filter");
        if(failedFilter != null && failedFilter.filterType().equals("post")){
            return true;
        }
        return false;
    }
}
