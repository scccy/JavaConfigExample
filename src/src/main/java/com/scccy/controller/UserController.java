package com.scccy.controller;

import com.scccy.common.ResultData;

import com.scccy.domain.User;
import com.scccy.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
@CrossOrigin(allowedHeaders = "*", allowCredentials = "true",
        //允许跨域的客户端服务器
        originPatterns = "*")  //允许当前Cotroller所有接口跨域访问
public class UserController {

    @Autowired
    UserService userService;

    //    增
    @PostMapping
    @ResponseBody
    public ResultData add(@RequestBody User user) {
        userService.add(user);
        return ResultData.ok();
    }

    //    删
    @DeleteMapping("/{id}")
    @ResponseBody
    public ResultData delete(@PathVariable("id") Integer id) {
        userService.delete(id);
        return ResultData.ok();
    }

    @PutMapping("")
    @ResponseBody
    public ResultData update(@RequestBody User user) {
        userService.update(user);
        return ResultData.ok();
    }

    @GetMapping("")
    @ResponseBody
    public ResultData getUserById(@RequestParam("userId") Integer id) {
        User user = userService.getUserById(id);
        return ResultData.ok().setData(user);
    }

    @GetMapping("/all")
    @ResponseBody
    public ResultData getAll(@RequestParam("page") Integer page,
                             @RequestParam("pageSize") Integer pageSize) {
        List<User> users = userService.getAll(page, pageSize);
        return ResultData.ok().setData(users);
    }

    //        登入页面测试 修改返回接过是utf8
    @GetMapping(value= "/login",produces = "text/html;charset=UTF-8")
    @ResponseBody()
    public String login() {
        return "👴快来玩儿つぼみ";
    }

//    转发
    @GetMapping("/forward")
    public String forward(){
        return "forward:login";
    }
//    重定向
    @GetMapping("/red")
    public String redirect(){
        return "redirect:login";
    }

    
}
