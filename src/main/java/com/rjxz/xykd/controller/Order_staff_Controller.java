package com.rjxz.xykd.controller;

import com.rjxz.xykd.bean.Order;
import com.rjxz.xykd.service.IActivitiesService;
import com.rjxz.xykd.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
public class Order_staff_Controller {

    @Autowired
    private IOrderService orderService;
    @Autowired
    private IActivitiesService activitiesService;

    //查看快递员个人所有已接订单
    @GetMapping("/api/staff/getStaffAllOrders")
    public Object getStaffAllOrders(long courierId){
        return orderService.getStaffDoneOrders(courierId);
    }

    //查看所有代买订单
    @GetMapping("/api/staff/getStaffAllBuyOrders")
    public Object getStaffAllBuyOrders(long courierId){
        return orderService.getStaffDoneBuyOrders(courierId);
    }

    //查看所有代取订单
    @GetMapping("/api/staff/getAllTakeOrders")
    public Object getAllTakeOrders(long courierId){
        return orderService.getStaffDoneTakeOrders(courierId);
    }

    //查看所有代送订单
    @GetMapping("/api/staff/getAllSendOrders")
    public Object getAllSendOrders(long courierId){
        return orderService.getStaffDoneSendOrders(courierId);
    }

    //查看所有未接订单
    @GetMapping("/api/staff/getAllUndoneOrders")
    public Object getAllUndoneOrders(String type){
        List<Order> list= Arrays.asList(orderService.getUndoneOrders());
        return list.stream().filter(e->e.getOrdertype().name().equals(type)).toArray();
    }

    // 修改订单(接单)
    @PostMapping("/api/staff/updateOrder")
    public Boolean updateOrder(Order bean) throws IOException {
        Order order=orderService.getOrderById(bean.getId());
        if(order.getCourierid()==null) {
            return orderService.updateOrder(bean);
        }else
            return false;
    }

    //订单撤销
    @PostMapping("/api/staff/cancelOrder")
    public Boolean cancelOrder(Order bean){
        Order order=orderService.getOrderById(bean.getId());
        if(order.getCourierid().toString().equals(bean.getCourierid().toString())){
            bean.setCourierid(null);
            return orderService.updateOrder(bean);
        }
        return false;
    }

    //获取个人活动记录
    @GetMapping("/api/staff/getActivities")
    public Object getActivities(String userId){
        if(userId!=null)
            return activitiesService.getActivities(Long.parseLong(userId));
        else
            return false;
    }

}
