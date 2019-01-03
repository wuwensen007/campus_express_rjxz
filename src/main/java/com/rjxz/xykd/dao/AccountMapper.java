package com.rjxz.xykd.dao;

import com.rjxz.xykd.bean.Account;
import com.rjxz.xykd.bean.AccountType;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Param;

@CacheNamespace
public interface AccountMapper {

    Account[] selectAll();

    int insert(Account account);

    int updateByPrimaryKey(Account account);

    int deleteByPrimaryKey(Long id);

    Account[] selectAllByType(AccountType type);

    Account selectByPrimaryKey(Long id);

    Account selectByNickname(String nickname);

    Account selectByEmailAndPwd(@Param("email") String email, @Param("password") String password);

    Account selectByPhoneAndPwd(@Param("phone") String phone, @Param("password") String password);

    Account selectByNicknameAndPwd(@Param("nickname") String nickname, @Param("password") String password);

    Account selectByEmail(String email);
}
