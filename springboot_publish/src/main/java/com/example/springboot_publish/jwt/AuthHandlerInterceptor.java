package com.example.springboot_publish.jwt;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("进入拦截器.......");
        String token = request.getHeader("token");
        if (null == token) {
            System.out.println("缺少认证信息");
            return false;  // 这里一般都是抛出自定义异常给全局异常处理，这里为了简化不做扩展说明
        }
        System.out.println("header token:" + token);
        boolean auth = JwtTokenUtils.verity(token);
        System.out.println("认证结果:" + auth);
        return auth;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}