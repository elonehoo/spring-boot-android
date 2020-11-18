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
 * @since 2020-11-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tbl_default")
public class Default implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 默认头像的uuid
     */
    @TableId(value = "default_uuid",type = IdType.UUID)
    private String defaultUuid;

    /**
     * 默认头像的URL地址
     */
    @TableField(value = "default_url")
    private String defaultUrl;

    /**
     * 创建时间
     */
    @TableField(value = "default_creation")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date defaultCreation;

    /**
     * 修改时间
     */
    @TableField(value = "default_modification",update = "NOW()",fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date defaultModification;


}
