package com.zhagl.demo;

import com.netflix.zuul.FilterProcessor;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class DidiFilterProcessor extends FilterProcessor {//继承核心处理器

    @Override
    public Object processZuulFilter(ZuulFilter filter) throws ZuulException {
        try {
            return super.processZuulFilter(filter);
        } catch (ZuulException e){
            RequestContext ctx = RequestContext.getCurrentContext();
            //上下文中存储异常的过滤器实例
            ctx.set("failed.filter", filter);
            throw e;
        }
    }
}
