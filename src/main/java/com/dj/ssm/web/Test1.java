package com.dj.ssm.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dj.ssm.pojo.User;
import com.dj.ssm.pojo.User1;


import java.util.List;

public class Test1 {
              /*  1，{"userName":"q","userPwd":"123"}
                2、[1,2,3]
                3、[{"userName":"qa","userPwd":"123"},{"userName":"qb","userPwd":"123"},{"userName":"qc","userPwd":"123"},{"userName":"qw","userPwd":"123"}]
                4、{"userList":[{"userName":"qa","userPwd":"123"},{"userName":"qb","userPwd":"123"}],"money" : "120"}
                5、[{"userList":[{"userName":"qa","userPwd":"123"},{"userName":"qb","userPwd":"123"}],"money" : "120"},{"userName":"qa","userPwd":"123"},{"userName":"qb","userPwd":"123"}]*/
    public static void main(String[] args) {
        String str = "{\"userName\":\"q\",\"userPwd\":\"123\"}";
        JSONObject jsonObject = JSONObject.parseObject(str);
        User user1 = jsonObject.toJavaObject(User.class);
        System.out.println(user1.getUserName() +"--"+ user1.getUserPwd());
        User user = JSONObject.parseObject(str, User.class);
        String s = JSONObject.toJSONString(User.class);
        System.out.println(s);
        String arr = "[1,2,3]";
        JSONArray jsonArray = JSONArray.parseArray(arr);
        System.out.println(jsonArray.size());
        String st = "[{\"userName\":\"qa\",\"userPwd\":\"123\"},{\"userName\":\"qb\",\"userPwd\":\"123\"},{\"userName\":\"qc\",\"userPwd\":\"123\"},{\"userName\":\"qw\",\"userPwd\":\"123\"}]";
        JSONArray jsonArray1 = JSONArray.parseArray(st);
        List<User> users = jsonArray1.toJavaList(User.class);
        System.out.println(users.size());
        String s1 = jsonArray1.toJSONString(users);
        System.out.println(s1);

        String strra = "{\"userList\":[{\"userName\":\"qa\",\"userPwd\":\"123\"},{\"userName\":\"qb\",\"userPwd\":\"123\"}],\"money\" : \"120\"}";
        User1 u = JSONObject.parseObject(strra, User1.class);
        System.out.println(u);
    }
}
