package com.example.haihm.first_greeting;

/**
 * Created by haihm on 8/10/2017.
 */

public class List_Chat {
    String name;
    int avatar;

    public List_Chat(String name, int avatar) {
        this.name = name;
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }
}
