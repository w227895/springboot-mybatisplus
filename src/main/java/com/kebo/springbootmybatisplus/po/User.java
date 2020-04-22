package com.kebo.springbootmybatisplus.po;

import lombok.Data;

/**
 * @description:
 * @author: kb
 * @create: 2020-04-22 21:34
 **/
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}

