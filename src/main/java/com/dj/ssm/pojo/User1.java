package com.dj.ssm.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data

public class User1 {

    private Integer id;

    private String userName;

    private String userPwd;

    private List<User> userList;

    private Integer money;
}
