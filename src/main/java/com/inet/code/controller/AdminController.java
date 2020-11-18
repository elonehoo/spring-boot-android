package com.inet.code.controller;

import com.inet.code.service.ExhibitionService;
import com.inet.code.service.PushService;
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
     * 上传校园图片
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

}
