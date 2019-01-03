package com.rjxz.xykd.aspect;

import com.rjxz.xykd.bean.Account;
import com.rjxz.xykd.bean.AccountType;
import com.rjxz.xykd.bean.Activities;
import com.rjxz.xykd.bean.Order;
import com.rjxz.xykd.service.IAccountService;
import com.rjxz.xykd.service.IActivitiesService;
import com.rjxz.xykd.service.IEmailService;
import com.rjxz.xykd.service.impl.AccountService;
import com.rjxz.xykd.util.IDGenerator;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;


/**
 * 活动记录类
 */
@Aspect
@Component
public class ActivityAdvice {

    @Autowired
    private IActivitiesService activitiesService;

    @Autowired
    private IEmailService emailService;


    private Activities generateActivity(){
        Activities activities = new Activities();
        activities.setId(IDGenerator.getInstance().getId());
        activities.setTime(LocalDateTime.now());
        return activities;
    }

    // 注册记录
    @Around(value = "execution(* com.rjxz.xykd.service.impl.AccountService.register(String,String,String,String,Long)) && args(email, nickname, regPassword,type,id)")
    public Object registerLog(ProceedingJoinPoint joinPoint, String email, String nickname, String regPassword, String type, Long id){

        Object obj = null;
        try {
            obj = joinPoint.proceed();
            Activities activities = generateActivity();
            activities.setType(type);
            activities.setUserid(id);
            activities.setActivity("注册#邮箱号为:"+email+"昵称为:"+nickname + "的信息已录入到数据库!");
            activitiesService.insertActivities(activities);
            emailService.sendRichEmail(email, "尊敬的用户" + nickname+",您好！感谢你在本系统注册账号。");

        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return obj;
    }

    // 登陆记录
    @Around(value = "execution(* com.rjxz.xykd.service.impl.AccountService.login(String,String)) && args(email, password)")
    public Account loginLog(ProceedingJoinPoint joinPoint, String email, String password){

        Account account = null;
        try {
            account = (Account)joinPoint.proceed();
            Activities activities = generateActivity();
            activities.setUserid(account.getId());
            activities.setType(account.getType().name());
            activities.setActivity("登录#用户"+account.getNickname() + "#登录本系统");
            activitiesService.insertActivities(activities);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return account;
    }


    // 用户提交订单记录
    @Around(value = "execution(* com.rjxz.xykd.service.impl.OrderService.submitOrder(com.rjxz.xykd.bean.Order)) && args(order)")
    public Object loginLog(ProceedingJoinPoint joinPoint, Order order){

       Object obj = null;
        try {
            obj = joinPoint.proceed();
            Activities activities = generateActivity();
            IAccountService accountService = new AccountService();
            Account account = accountService.getAccountById(order.getUserid());
            activities.setUserid(account.getId());
            activities.setType(account.getType().name());
            activities.setActivity("提交订单#用户"+account.getNickname() + "#提交了订单号为"+order.getId()+"的订单("+order.getOrdertype().name()+")");
            activitiesService.insertActivities(activities);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return obj;
    }

    // 快递员接单记录
    @Around(value = "execution(* com.rjxz.xykd.service.impl.OrderService.updateOrder(com.rjxz.xykd.bean.Order,com.rjxz.xykd.bean.AccountType)) && args(order, type)")
    public Object takeOrderLog(ProceedingJoinPoint joinPoint, Order order, AccountType type){
        Object obj = null;
        try {
            obj = joinPoint.proceed();
            Activities activities = generateActivity();
            IAccountService accountService = new AccountService();
            if (type == AccountType.STAFF) {

                Account account = accountService.getAccountById(order.getCourierid());
                activities.setUserid(account.getId());
                activities.setType(account.getType().name());
                activities.setActivity("接单#快递员"+account.getNickname() + "#接取了用户"+order.getUserid()+"的"+order.getId()+"订单("+order.getOrdertype().name()+")");
            }else if (type == AccountType.USER){
                Account account = accountService.getAccountById(order.getUserid());
                activities.setUserid(account.getId());
                activities.setType(account.getType().name());
                activities.setActivity("修改#用户"+account.getNickname() + "#修改了"+order.getId()+"的订单("+order.getOrdertype().name()+")");
            }
            activitiesService.insertActivities(activities);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return obj;
    }

    //修改密码记录
    @Around(value = "execution(* com.rjxz.xykd.controller.AccountController.updatePwd(String,javax.servlet.http.HttpServletRequest)) && args(password,req)")
    public boolean updatePwdLog(ProceedingJoinPoint joinPoint,String password,HttpServletRequest req){
        Object obj=null;
        try {
            obj = joinPoint.proceed();
            Activities activities = generateActivity();
            HttpSession session=req.getSession();
            Account account=(Account) session.getAttribute("account");
            activities.setUserid(account.getId());
            activities.setType(account.getType().name());
            activities.setActivity("修改#用户"+account.getNickname() + "#修改了密码，新密码为"+password);
            activitiesService.insertActivities(activities);

        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return obj!=null;
    }
}
