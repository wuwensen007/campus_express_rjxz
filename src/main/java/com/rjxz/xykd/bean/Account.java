package com.rjxz.xykd.bean;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.rjxz.xykd.util.LongJsonDeserializer;
import com.rjxz.xykd.util.LongJsonSerializer;

import java.util.HashMap;

public class Account {

    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    private Long id;

    private String email;

    private String phone;

    private String nickname;

    private String password;

    private AccountType type;

    private HashMap<String, Object> spec = new HashMap<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public HashMap<String, Object> getSpec() {
        return spec;
    }

    public void setSpec(HashMap<String, Object> spec) {
        this.spec = spec;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", type=" + type +
                ", spec=" + spec +
                '}';
    }
}
