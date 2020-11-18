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
@TableName("tbl_registration")
public class Registration implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 签到用户的uuid
     */
    @TableId(value = "registration_uuid",type = IdType.UUID)
    private String registrationUuid;

    /**
     * 签到用户的学号
     */
    @TableField(value = "registration_number")
    private String registrationNumber;

    /**
     * 签到用户的签到状态
     */
    @TableField(value = "registration_state")
    private String registrationState;

    /**
     * 签到的开始时间
     */
    @TableField(value = "registration_start")
    private LocalDateTime registrationStart;

    /**
     * 签到的结束时间
     */
    @TableField(value = "registration_finish")
    private LocalDateTime registrationFinish;

    /**
     * 签到的总时间
     */
    @TableField(value = "registration_total")
    private Long registrationTotal;

    /**
     * 创建时间
     */
    @TableField(value = "registration_creation")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date registrationCreation;

    /**
     * 修改时间
     */
    @TableField(value = "registration_modification",update = "NOW()",fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date registrationModification;


}
