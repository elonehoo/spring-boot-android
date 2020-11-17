package com.inet.code.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author HCY
 * @since 2020-11-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tbl_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户序号
     */
    @TableId(value = "user_uuid",type = IdType.UUID)
    private String userUuid;

    /**
     * 用户姓名
     */
    @TableField(value = "user_name")
    private String userName;

    /**
     * 用户头像URL
     */
    @TableField(value = "user_buddha")
    private String userBuddha;

    /**
     * 用户电话号码
     */
    @TableField(value = "user_phone")
    private String userPhone;

    /**
     * 用户学号
     */
    @TableField(value = "user_number")
    private String userNumber;

    /**
     * 用户班级
     */
    @TableField(value = "user_class")
    private String userClass;

    /**
     * 创建时间
     */
    @TableField(value = "user_creation")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date userCreation;

    /**
     * 修改时间
     */
    @TableField(value = "user_modification",update = "NOW()",fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date userModification;

    @TableField(exist = false)
    private String roleName;


}
