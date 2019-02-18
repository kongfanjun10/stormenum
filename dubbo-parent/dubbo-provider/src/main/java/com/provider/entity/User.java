package com.provider.entity;

import java.io.Serializable;

/**
 * Created by yan on 2019/2/15.
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

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
