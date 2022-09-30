package com.example.springboot_publish.jwt;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/user")
public class ControllerTest {

    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public String login(
            HttpServletResponse response,
            @RequestParam(value = "username") String userName,
            @RequestParam(value = "password") String password
    ) {
        System.out.println("进入登录接口.....");
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        String loginResult = loginService.login(response, user);
        System.out.println("登录服务结果：" + loginResult);
        return loginResult;
    }

    @GetMapping("/test")
    public String name() {
        return "this is from client-1";
    }

}