package com.rjxz.xykd.controller;

import com.rjxz.xykd.bean.AccountType;
import com.rjxz.xykd.bean.OrderType;
import com.rjxz.xykd.bean.Order;
import com.rjxz.xykd.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class Order_admin_Controller {

    @Autowired
    private IOrderService orderService;

    //查看所有订单
    @GetMapping("/api/admin/getAllOrders")
    public Object getAllOrders(){
        return orderService.getAllOrder();
    }

    //查看所有代买订单
    @GetMapping("/api/admin/getAllBuyOrders")
    public Object getAllBuyOrders(){
        return orderService.getAllOrderByType(OrderType.BUY);
    }

    //查看所有代取订单
    @GetMapping("/api/admin/getAllTakeOrders")
    public Object getAllTakeOrders(){
        return orderService.getAllOrderByType(OrderType.TAKE);
    }

    //查看所有代送订单
    @GetMapping("/api/admin/getAllSendOrders")
    public Object getAllSendOrders(){
        return orderService.getAllOrderByType(OrderType.SEND);
    }

    //查看所有未接订单
    @GetMapping("/api/admin/getAllUndoneOrders")
    public Object getAllUndoneOrders(){
        return orderService.getUndoneOrders();
    }

    //查看所有已接订单
    @GetMapping("/api/admin/getAllDoneOrders")
    public Object getAllDoneOrders(){
        return orderService.getDoneOrders();
    }

    // 修改订单
    @PostMapping("/api/admin/order/update")
    public Boolean updateOrder(Order bean) throws IOException {
        return orderService.updateOrder(bean);
    }

    // 删除订单
    @PostMapping("/api/admin/order/delete")
    public Boolean deleteOrder(long id) throws IOException {
        return orderService.deleteOrder(id);
    }

}
