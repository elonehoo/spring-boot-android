package com.inet.code.controller;

import com.inet.code.service.UserService;
import com.inet.code.utlis.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation("登陆操作，进行登陆，并且返回token，需要将token保留")
    @ApiImplicitParams({
            @ApiImplicitParam(name="Account",value="账号，学号",dataType="String", paramType = "query"),
            @ApiImplicitParam(name="Password",value="密码",dataType="String", paramType = "query"),
    })
    @PostMapping("/register")
    public Result postRegister(@RequestParam(value = "Account",defaultValue = "") String account,
                               @RequestParam(value = "Password",defaultValue = "") String password){
        return userService.getLogin(
                account
                ,password
                ,"/android/user/register");
    }

    /**
     * 注册操作
     * @author HCY
     * @since 2020-11-18
     * @param name 姓名
     * @param buddha 头像
     * @param phone 电话号码
     * @param number 学号
     * @param password 密码
     * @param clazz 班级
     * @return Result
     */
    @ApiOperation("注册操作，输入学生姓名，头像的url地址，电话号码，学号，密码，班级")
    @ApiImplicitParams({
            @ApiImplicitParam(name="Name",value="学生姓名",dataType="String", paramType = "query"),
            @ApiImplicitParam(name="Buddha",value="学生头像的URL地址",dataType="String", paramType = "query"),
            @ApiImplicitParam(name="Phone",value="电话号码",dataType="String", paramType = "query"),
            @ApiImplicitParam(name="Number",value="学号",dataType="String", paramType = "query"),
            @ApiImplicitParam(name="Password",value="密码",dataType="String", paramType = "query"),
            @ApiImplicitParam(name="Clazz",value="班级",dataType="String", paramType = "query"),
    })
    @PostMapping("/enroll")
    public Result postEnroll(
            @RequestParam(value = "Name",defaultValue = "") String name
            ,@RequestParam(value = "Buddha",defaultValue = "") String buddha
            ,@RequestParam(value = "Phone",defaultValue = "") String phone
            ,@RequestParam(value = "Number",defaultValue = "") String number
            ,@RequestParam(value = "Password",defaultValue = "") String password
            ,@RequestParam(value = "Clazz",defaultValue = "") String clazz){
        return userService.getEnroll(
                 name
                ,buddha
                ,phone
                ,number
                ,password
                ,clazz
                ,"/android/user/enroll");
    }

    /**
     * 退出操作
     * @author HCY
     * @since 2020-11-18
     * @param token 令牌
     * @return Result
     */
    @ApiOperation("退出操作，输入token判断是在登陆状态，即可退出")
    @GetMapping("/exit")
    @RequiresRoles(value = {"student"})
    public Result getExit(@RequestHeader(value = "Token",defaultValue = "") String token){
        return userService.getExit(
                token
                ,"/android/user/exit");
    }
}
