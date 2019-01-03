package com.rjxz.xykd.service.impl;

import com.rjxz.xykd.bean.Account;
import com.rjxz.xykd.bean.AccountType;
import com.rjxz.xykd.dao.AccountMapper;
import com.rjxz.xykd.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.regex.Pattern;

@Service
public class AccountService implements IAccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Account login(String username, String password) {
        String emailRegx="^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
        Pattern emailP=Pattern.compile(emailRegx);
        String phoneRegx="^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}$";
        Pattern phoneP=Pattern.compile(phoneRegx);

        if(emailP.matcher(username).matches()){
            return accountMapper.selectByEmailAndPwd(username, password);
        }else if(phoneP.matcher(username).matches()){
            return accountMapper.selectByPhoneAndPwd(username,password);
        }else {
            return accountMapper.selectByNicknameAndPwd(username,password);
        }
    }

    @Override
    public boolean register(String email, String nickname, String phone, String password, String type, Long id) {

        Account account = new Account();
        account.setId(id);
        account.setNickname(nickname);
        account.setPhone(phone);
        account.setPassword(password);
        account.setEmail(email);

        HashMap<String, Object> map = new HashMap<String,Object>();
        map.put("address", "黄山");
        map.put("jointime", LocalDateTime.now().toString());
        map.put("ordernum",0);
        map.put("finishnum",0);


        account.setSpec(map);

        if ("ADMIN".equalsIgnoreCase(type)){
            account.setType(AccountType.ADMIN);
        }else if ("STAFF".equalsIgnoreCase(type)) {
            account.setType(AccountType.STAFF);
        }else if ("USER".equalsIgnoreCase(type)){
            account.setType(AccountType.USER);
        }else {
            return false;
        }
        return accountMapper.insert(account) > 0;
    }

    @Override
    public boolean update(Account account) {
        return accountMapper.updateByPrimaryKey(account) > 0;
    }

    @Override
    public boolean delete(Long id) {
        return accountMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public Account[] getAllAccount() {
        return accountMapper.selectAll();
    }

    @Override
    public Account[] getAllStaff() {
        return accountMapper.selectAllByType(AccountType.STAFF);
    }

    @Override
    public Account[] getAllUser() {
        return accountMapper.selectAllByType(AccountType.USER);
    }

    @Override
    public Account getAccountById(long id) {
        return accountMapper.selectByPrimaryKey(id);
    }

    @Override
    public Account getAccountByEmail(String email) {
        return  accountMapper.selectByEmail(email);
    }

    @Override
    public boolean isNicknameExist(String nickname) {
        return accountMapper.selectByNickname(nickname) != null;
    }
}
