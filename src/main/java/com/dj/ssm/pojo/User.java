package com.dj.ssm.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * 用户
 */
@Data
@TableName("user")
public class User {

    /**
     * 用户id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户密码
     */
    @TableField("user_pwd")
    private String userPwd;

    /**
     * 用户年龄
     */
    @TableField("user_age")
    private Integer userAge;

    /**
     * 用户性别
     */
    @TableField("user_sex")
    private Integer userSex;

    /**
     * 手机号
     */
    private Integer phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 爱好
     */
  /*  private String hobby;*/

    List<String> hobby;


}
