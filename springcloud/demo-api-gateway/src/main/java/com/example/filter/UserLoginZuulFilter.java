package com.example.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 网关过滤器
 * @author JC
 * @date 15:05 2020/2/19
 **/
@Component
public class UserLoginZuulFilter extends ZuulFilter {
    @Override
    public String filterType() {
        // 设置过滤器类型：pre
        return "pre";
    }

    @Override
    public int filterOrder() {
        // 设置执行顺序
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        // 该过滤器需要执行
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        // 编写业务逻辑
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String token = request.getParameter("token");
        if (StringUtils.isEmpty(token)) {
            // 过滤该请求，不对其进行路由
            requestContext.setSendZuulResponse(false);
            // 设置响应状态码
            requestContext.setResponseStatusCode(401);
            requestContext.setResponseBody("token is empty!");
            return null;
        }
        return null;
    }
}
