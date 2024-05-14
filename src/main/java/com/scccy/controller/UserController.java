package com.scccy.controller;

import com.scccy.common.ResultData;

import com.scccy.domain.User;
import com.scccy.handler.GlobalExceptionHandler;
import com.scccy.service.UserService;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
@CrossOrigin(allowedHeaders = "*" , allowCredentials = "true" ,
        //允许跨域的客户端服务器
        originPatterns="*" )  //允许当前Cotroller所有接口跨域访问
public class UserController {

    @Autowired
    UserService userService ;
    //    增
    @PostMapping
    @ResponseBody
    public ResultData add(@RequestBody User user) {
         Object add = userService.add(user);

        if((Boolean)add){
            return ResultData.ok();
        }else {
            throw new GlobalExceptionHandler.CustomException("👋了您つぼみ");
        }
    }

    //    删
    @DeleteMapping("/{id}")
    @ResponseBody
    public String delete(@PathVariable("id") Integer id) {
        return id.toString();
    }

    @PutMapping("/{id}")
    @ResponseBody
    public String update(@PathVariable("id") Integer id) {
        return id.toString();
    }

    @GetMapping
    @ResponseBody
    public String getUserById(@RequestParam("userId") Integer id) {
        return id.toString();
    }
}
