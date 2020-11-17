package com.inet.code.controller;

import com.inet.code.service.UserService;
import com.inet.code.utlis.Result;
import io.swagger.annotations.Api;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * userController
 * 用户的操作
 * @author HCY
 * @since 2020/11/17
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
@Api(tags = {"用户页面的基础操作"},description = "用户模块")
public class UserController {
    @Resource
    private UserService userService;

    /**
     * 登录请求
     * @author HCY
     * @since 2020-11-17
     * @param account 账号,学号
     * @param password 密码
     * @return Result
     */
    @PostMapping("/register")
    public Result postRegister(@RequestParam(value = "Account",defaultValue = "") String account,
                               @RequestParam(value = "Password",defaultValue = "") String password){
        return userService.getLogin(
                account
                ,password
                ,"/android/user/register");
    }

}
