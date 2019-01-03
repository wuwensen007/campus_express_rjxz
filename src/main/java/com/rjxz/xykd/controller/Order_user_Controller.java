package com.rjxz.xykd.controller;

import com.rjxz.xykd.bean.Order;
import com.rjxz.xykd.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class Order_user_Controller {

    @Autowired
    private IOrderService orderService;

    //查看所有订单
    @GetMapping("/api/getUserAllOrders")
    public Object getUserAllOrders(long userId){
        return orderService.getUserAllOrders(userId);
    }

    //查看所有代买订单
    @GetMapping("/api/getAllBuyOrders")
    public Object getAllBuyOrders(long userId){
        return orderService.getUserAllBuyOrders(userId);
    }

    //查看所有代取订单
    @GetMapping("/api/getAllTakeOrders")
    public Object getAllTakeOrders(long userId){
        return orderService.getUserAllTakeOrders(userId);
    }

    //查看所有代送订单
    @GetMapping("/api/getAllSendOrders")
    public Object getAllSendOrders(long userId){
        return orderService.getUserAllSendOrders(userId);
    }

    //查看所有未接订单
    @GetMapping("/api/getAllUndoneOrders")
    public Object getAllUndoneOrders(long userId){
        return orderService.getUserUndoneOrders(userId);
    }

    //查看所有已接订单
    @GetMapping("/api/getAllDoneOrders")
    public Object getAllDoneOrders(long userId){
        return orderService.getUserDoneOrders(userId);
    }

    // 提交订单
    @PostMapping("/api/submitOrder")
    public Boolean submitOrder(Order  bean) throws IOException {
        return orderService.submitOrder(bean);
    }

    // 修改订单
    @PostMapping("/api/updateOrder")
    public Boolean updateOrder(Order bean) throws IOException {
        return orderService.updateOrder(bean);
    }
}
