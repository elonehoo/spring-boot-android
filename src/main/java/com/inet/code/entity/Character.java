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
@TableName("tbl_character")
public class Character implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色序号
     */
    @TableId(value = "character_uuid",type = IdType.UUID)
    private String characterUuid;

    /**
     * 用户名字
     */
    @TableField(value = "character_number")
    private String characterNumber;

    /**
     * 权限uuid
     */
    @TableField(value = "character_role_uuid")
    private String characterRoleUuid;

    /**
     * 创建时间
     */
    @TableField(value = "character_creation")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date characterCreation;

    /**
     * 修改时间
     */
    @TableField(value = "character_modification",update = "NOW()",fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date characterModification;


}
