package com.kebo.springbootmybatisplus.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Date;

/**
 * @description:
 * @author: kb
 * @create: 2020-04-22 21:34
 **/
@Data
public class User {
    //@TableId(type = IdType.AUTO)
    //设置主键自增
    private Long id;
    private String name;
    private Integer age;
    private String email;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}

