package com.rjxz.xykd.service;

import com.rjxz.xykd.bean.Account;

public interface IAccountService {

    //登录
    Account login(String email, String password);

    //注册
    boolean register(String email, String nickname, String phone, String password, String type, Long id);

    //修改个人信息
    boolean update(Account account);

    //删除个人信息
    boolean delete(Long id);

    //获取所有账号信息
    Account[] getAllAccount();

    //获取所有快递员账号信息
    Account[] getAllStaff();

    //获取所有用户账号信息
    Account[] getAllUser();

    // 获取指定的账号信息
    Account getAccountById(long id);

    // 查看昵称是否重复
    boolean isNicknameExist(String nickname);

    //查询email获取用户
    Account getAccountByEmail(String email);
}
