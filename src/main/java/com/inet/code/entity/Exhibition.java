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
 * 展示图片
 * </p>
 *
 * @author HCY
 * @since 2020-11-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tbl_exhibition")
public class Exhibition implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 校园展示的uuid
     */
    @TableId(value = "exhibition_uuid",type = IdType.UUID)
    private String exhibitionUuid;

    /**
     * 展示图片的地址
     */
    @TableField(value = "exhibition_city")
    private String exhibitionCity;

    /**
     * 展示图片的URL网址
     */
    @TableField(value = "exhibition_images")
    private String exhibitionImages;

    /**
     * 创建时间
     */
    @TableField(value = "exhibition_creation")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date exhibitionCreation;

    /**
     * 修改时间
     */
    @TableField(value = "exhibition_modification",update = "NOW()",fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date exhibitionModification;


}
