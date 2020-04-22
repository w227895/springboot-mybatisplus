package com.kebo.springbootmybatisplus.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

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
}

