package com.inet.code.controller;

import com.inet.code.service.ExhibitionService;
import com.inet.code.service.PushService;
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
 * 管理页面
 * @author HCY
 * @since 2020-11-18
 */
@RestController
@RequestMapping("/admin")
@CrossOrigin
@Api(tags = {"管理页面的基础操作"},description = "管理模块")
public class AdminController {
    @Resource
    private PushService pushService;

    @Resource
    private ExhibitionService exhibitionService;

    @Resource
    private UserService userService;

    /**
     * 发送推送信息
     * @author HCY
     * @since 2020-11-18
     * @param headline 标题
     * @param content 内容
     * @return Result
     */
    @ApiOperation("发送推送信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="Headline",value="标题",dataType="String", paramType = "query"),
            @ApiImplicitParam(name="Content",value="内容",dataType="String", paramType = "query"),
    })
    @PostMapping("/push")
    @RequiresRoles(value = {"admin"})
    public Result postPush(@RequestParam(value = "Headline",defaultValue = "") String headline,
                           @RequestParam(value = "Content",defaultValue = "") String content){
        return pushService.getSend(
                 headline
                ,content
                ,"/android/admin/push");
    }
    /**
     * 删除推文，通过uuid
     * @author HCY
     * @since 2020/11/20 9:34 上午
     * @param uuid: 序号
     * @return com.inet.code.utlis.Result
    */
    @ApiOperation("通过uuid删除推文")
    @ApiImplicitParams({
            @ApiImplicitParam(name="UUID",value="uuid",dataType="String", paramType = "query"),
    })
    @GetMapping("/deleteTweets")
    @RequiresRoles(value = {"admin"})
    public Result getDeleteTweets(@RequestParam(value = "UUID",defaultValue = "") String uuid){
        return pushService.removeByuuid(uuid,"/android/admin/deleteTweets");
    }

    /**
     * 上传校园图片
     * @author HCY
     * @since 2020-11-18
     * @param city 校园位置
     * @param images 图片URL位置
     * @return Result
     */
    @ApiOperation("上传校园图片")
    @ApiImplicitParams({
            @ApiImplicitParam(name="City",value="校园位置",dataType="String", paramType = "query"),
            @ApiImplicitParam(name="Images",value="图片URL位置",dataType="String", paramType = "query"),
    })
    @PostMapping("/upload")
    @RequiresRoles(value = {"admin"})
    public Result postUpload(@RequestParam(value = "City",defaultValue = "") String city,
                             @RequestParam(value = "Images",defaultValue = "") String images){
        return exhibitionService.getUploading(
                 city
                ,images
                ,"/android/admin/upload");
    }
    /**
     * 通过uuid删除图片
     * @author HCY
     * @since 2020/11/20 9:40 上午
     * @param uuid: 序号
     * @return com.inet.code.utlis.Result
    */
    @ApiOperation("通过uuid删除校园图片")
    @ApiImplicitParams({
            @ApiImplicitParam(name="UUID",value="uuid",dataType="String", paramType = "query"),
    })
    @RequiresRoles(value = {"admin"})
    @GetMapping("/deleteImages")
    public Result getDeleteImages(@RequestParam(value = "UUID",defaultValue = "") String uuid){
        return exhibitionService.remobeByuuid(uuid,"/android/admin/deleteImages");
    }

    /**
     * 展示学生信息
     * @author HCY
     * @since 2020/11/19 8:12 下午
     * @param pagination:
     * @param entry:
     * @return com.inet.code.utlis.Result
    */
    @ApiOperation("展示学生信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="Pagination",value="页数",dataType="Integer", paramType = "query"),
            @ApiImplicitParam(name="Entry",value="条目数",dataType="Integer", paramType = "query"),
    })
    @GetMapping("/display")
    @RequiresRoles(value = {"admin"})
    public Result getDisplay(
             @RequestParam(value = "Pagination",defaultValue = "1") Integer pagination
            ,@RequestParam(value = "Entry",defaultValue = "10") Integer entry){
        return userService.getDisplay(pagination,entry,"/android/admin/display");
    }

    /**
     * 删除学生信息
     * @author HCY
     * @since 2020/11/19 9:55 下午
     * @param number: 用户的uuid
     * @return com.inet.code.utlis.Result
    */
    @ApiOperation("删除学生")
    @ApiImplicitParams({
            @ApiImplicitParam(name="Number",value="学号",dataType="String", paramType = "query"),
    })
    @GetMapping("/cancel")
    @RequiresRoles(value = {"admin"})
    public Result getCancel(
            @RequestParam(value = "Number",defaultValue = "") String number){
        return userService.getCancel(number,"/android/admin/cancel");
    }
}
