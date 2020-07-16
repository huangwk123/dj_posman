package com.dj.ssm.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dj.ssm.pojo.User;
import com.fasterxml.jackson.annotation.JsonAlias;
import org.apache.logging.log4j.core.util.JsonUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class test {
    public static void main(String[] args) {
        //json格式字符串转对象
        String str = "{\"id\": 15,\"userName\": \"ls\",\"userPwd\": \"123456\" }";
        JSONObject jsonObject = JSONObject.parseObject(str);
        User user = jsonObject.toJavaObject(User.class);
        System.out.println(user.getId() + " - " + user.getUserName() + " - " + user.getUserPwd());
        //User user1 = JSONObject.parseObject(str, User.class);
        //对象转json字符串
        String s = JSONObject.toJSONString(user);
        System.out.println(s);
        //json数组转对象
        String arr = "[{ \"id\": 1, \"userName\": \"kkkk\", \"userPwd\": \"123456\" },{ \"id\": 4, \"userName\": \"khkhsss\", \"userPwd\": \"123\" },{ \"id\": 5, \"userName\": \"www\", \"userPwd\": \"123\" }]";
        JSONArray jsonArray = JSONArray.parseArray(arr);
        List<User> userList = jsonArray.toJavaList(User.class);
       // String s1 = jsonArray.toJSONString(userList);
        for (User u : userList) {
            System.out.println(u);
        }
        System.out.println("-------------------------------");
        //json格式字符串转List
        String str1 = "[ {\"id\": 1,\"userName\": \"kkkk\",\"hobby\": [\"篮球\",\"足球\"] }, {\"id\": 4,\"userName\": \"khkhsss\",\"hobby\": [\"篮球\",\"排球\"] }] ";
        JSONArray jsonArray1 = JSONArray.parseArray(str1);
        List<User> list = jsonArray1.toJavaList(User.class);
        for (User uu : list) {
            System.out.println(uu);
        }
        System.out.println("-------------------");
        //String 转List<map<string,object>>
        List<Map<String, Object>> listObjectFir = (List<Map<String, Object>>) JSONArray.parse(arr);
        for (Map<String, Object> mapList : listObjectFir) {
            for (Map.Entry entry : mapList.entrySet()) {
                System.out.println(entry.getKey() + " ---  " + entry.getValue());
            }
        }
        String json1 = JSON.toJSONString(listObjectFir);
        System.out.println(json1);
        System.out.println("---------------------------------------");
        //str转map<String,List<Object>>
        String bb = "{\n" + "\"1\":[{\"id\":4}, {\"id\":5}],\n" + "\"2\":[{\"id\":14}]\n" + "}";
        Map map = (Map) JSONObject.parseObject(bb);
        Set <String> set=map.keySet();
        for(String sss:set){
            System.out.println(sss+map.get(sss));}





    }


}

