package com.lxl.controller;
import com.lxl.pojo.User;
import com.lxl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/user/")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;
    @RequestMapping("login")
    public Object login(@RequestBody User user , HttpServletResponse response, HttpServletRequest request){
        if (user.getUsername()==null ||"".equals(user.getUsername())){
            return
        }




    }





}
