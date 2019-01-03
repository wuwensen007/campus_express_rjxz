package com.rjxz.xykd.controller;

import com.rjxz.xykd.bean.Account;
import com.rjxz.xykd.service.IAccountService;
import com.rjxz.xykd.service.IEmailService;
import com.rjxz.xykd.util.IDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class AccountController {

    @Autowired
    private IAccountService accountService;
    @Autowired
    private IEmailService emailService;

    // 注册
    @PostMapping("/api/register")
    public Object register(String email, String nickname, String phone,String regPassword, String type){
        return accountService.register(email, nickname, phone, regPassword, type, IDGenerator.getInstance().getId());
    }

    // 登录
    @GetMapping("/api/login")
    public Object login(String email, String password){
        return accountService.login(email, password);
    }

    // 修改账号
    @PostMapping("/api/update")
    public Object updateAccount(Account bean){
        return accountService.update(bean);
    }

    // 删除账号
    @PostMapping("/api/delete")
    public Object updateAccount(Long id){
        return accountService.delete(id);
    }

    // 获取所有账号
    @GetMapping("/api/allAccount")
    public Object getAll(){
        return accountService.getAllAccount();
    }

    // 获取所有用户账号
    @GetMapping("/api/allUserAccount")
    public Object getAllUser(){
        return accountService.getAllUser();
    }

    // 获取所有员工账号
    @GetMapping("/api/allStaffAccount")
    public Object getAllStaff(){
        return accountService.getAllStaff();
    }

    // 昵称查重
    @GetMapping("/api/checkNickname")
    public Object getAllStaff(String nickname){
        return accountService.isNicknameExist(nickname);
    }

    //申请邮箱验证码
    @GetMapping("/api/setEmailCode")
    public boolean setEmailCode(String email, HttpServletRequest request){
        String emailCode =""+ (int)((Math.random()*9+1)*100000);
        Account account=accountService.getAccountByEmail(email);
        if(account!=null){
            try {
                emailService.sendRichEmail
                        (email,"尊敬的用户"+account.getNickname()+",您正在使用校园快递忘记密码服务，验证码是"+emailCode+"，若非本人操作，请忽视本条信息");
                HttpSession session = request.getSession();
                session.setAttribute("code",emailCode);
                session.setAttribute("account",account);
                return true;
            } catch (MessagingException e) {
                 e.printStackTrace();
            }
        }
        return false;
    }

    // 对比验证码
    @GetMapping("/api/getEmailCode")
    public boolean getEmailCode(String code,HttpServletRequest req){
        HttpSession session=req.getSession();
        String trueCode=session.getAttribute("code").toString();
        return trueCode.equals(code);
    }

    //修改密码
    @PostMapping("/api/updatePwd")
    public boolean updatePwd(String password,HttpServletRequest req){
        HttpSession session=req.getSession();
        Account account=(Account) session.getAttribute("account");
        account.setPassword(password);
        return accountService.update(account);
    }
}
