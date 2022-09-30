package com.example.springboot_publish.jwt;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

@Service
public class LoginService {


    public String login(HttpServletResponse response, User user) {

        // 对账号和密码进行验证，一般是和数据库的数据对比，这里简化
        if (!user.getUserName().equals("admin")) return "账号错误";
        if (!user.getPassword().equals("admin")) return "密码错误";

        String token = JwtTokenUtils.sign(user);
        response.setHeader("token", token);
        return "登录成功";
    }

}