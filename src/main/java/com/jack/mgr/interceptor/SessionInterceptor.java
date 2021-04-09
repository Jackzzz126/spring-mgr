package com.jack.mgr.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * SessionInterceptor
 *
 * @author zhengzhe17
 * @date 2021/4/8
 */
@Configuration
public class SessionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession httpSession = request.getSession();
        if(httpSession.getAttribute(httpSession.getId()) != null) {
            return true;
        }
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write("{\"code\": 500,\"msg\": \"session失效，请重新登录\"}");
        return false;
    }
}
