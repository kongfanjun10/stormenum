package com.yan.entity;

/**
 * Created by yan on 2019/2/18.
 */
public class User {
    private Integer usId;
    private String usName;
    private Integer usAge;

    @Override
    public String toString() {
        return "User{" +
                "usId=" + usId +
                ", usName='" + usName + '\'' +
                ", usAge=" + usAge +
                '}';
    }

    public Integer getUsId() {
        return usId;
    }

    public void setUsId(Integer usId) {
        this.usId = usId;
    }

    public String getUsName() {
        return usName;
    }

    public void setUsName(String usName) {
        this.usName = usName;
    }

    public Integer getUsAge() {
        return usAge;
    }

    public void setUsAge(Integer usAge) {
        this.usAge = usAge;
    }

    public User() {
    }

    public User(Integer usId, String usName, Integer usAge) {
        this.usId = usId;
        this.usName = usName;
        this.usAge = usAge;
    }
}
