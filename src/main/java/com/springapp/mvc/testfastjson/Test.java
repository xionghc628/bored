package com.springapp.mvc.testfastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by xionghuacheng on 2018/4/25.
 */
public class Test {


    public static void main(String[] args) {
        TestEntity testEntity = new TestEntity();
        testEntity.setName("xionghuacheng");
        testEntity.setAge(11L);
        testEntity.setIsBoy(true);

        String s = JSON.toJSONString(testEntity);

        System.out.println(s);

        TestEntity testEntity1 = JSONObject.parseObject(s, TestEntity.class);

        System.out.printf(testEntity1.getName());
    }
}
