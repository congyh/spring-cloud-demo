package com.github.congyh.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author <a href='mailto:yihao.cong@outlook.com'>Cong Yihao</a>
 */

/**
 * ZuulFilter组件, 统一对Eureka中暴露的REST服务进行过滤,
 * 可以进行权限检查等诸多操作
 */
@Component
public class AccessFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(AccessFilter.class);

    /**
     * filter的类型
     *
     * @return pre 也就是在服务前过滤
     */
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));

        Object accessToken = request.getParameter("accessToken");
        if(accessToken == null) {
            log.warn("access token is empty");
            ctx.setSendZuulResponse(false); // 不进行响应
            ctx.setResponseStatusCode(401); // 返回未授权提示
            return null;
        }
        log.info("access token ok");
        return null;
    }

}
