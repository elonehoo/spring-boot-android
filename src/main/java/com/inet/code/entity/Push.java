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
@TableName("tbl_push")
public class Push implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 推送信息的uuid
     */
    @TableId(value = "push_uuid",type = IdType.UUID)
    private String pushUuid;

    /**
     * 推送信息的标题
     */
    @TableField(value = "push_headline")
    private String pushHeadline;

    /**
     * 推送信息的内容
     */
    @TableField(value = "push_content")
    private String pushContent;

    /**
     * 创建时间
     */
    @TableField(value = "push_creation")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date pushCreation;

    /**
     * 修改时间
     */
    @TableField(value = "push_modification",update = "NOW()",fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date pushModification;


}
