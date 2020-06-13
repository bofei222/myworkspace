package com.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class Test {
    public static void main(String[] args) {
        Group  group = new Group();
        group.setId(0L);
        group.setName("admin");
        
        User guestUser = new User();
        guestUser.setId(2L);
        guestUser.setName("guest");
        
        User rootUser = new User();
        rootUser.setId(3L);
        rootUser.setName("root");
        
        group.addUser(guestUser);
        group.addUser(rootUser);
        
        // Encode
        String jsonString = JSON.toJSONString(group);
        System.out.println(jsonString);
        
        // Decode
        JSONObject jsonObj = JSON.parseObject(jsonString);
        
        Group group2 = JSON.parseObject(jsonString, Group.class);
        System.out.println(group);
        
        
        JSONArray arr = new JSONArray();
        for (int i = 0; i < arr.size(); i++) {
             JSONObject jo = arr.getJSONObject(i);
             System.out.println();
        }
    }
}
    
        
        
       