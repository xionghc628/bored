package com.springapp.mvc.testfastjson;

/**
 * Created by xionghuacheng on 2018/4/25.
 */
public class TestEntity {

    private String name;


    private Long age;


    private boolean isBoy;

    public boolean getIsBoy() {
        return isBoy;
    }

    public void setIsBoy(boolean isBoy) {
        this.isBoy = isBoy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }
}
