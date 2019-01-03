package com.rjxz.xykd.service;

import com.rjxz.xykd.bean.AccountType;
import com.rjxz.xykd.bean.Order;
import com.rjxz.xykd.bean.OrderType;

public interface IOrderService {

    //提交代买订单
    boolean submitOrder(Order order);

    // 获取某类型的所有订单
    Order[] getAllOrderByType(OrderType type);

    // 获取所有订单
    Order[] getAllOrder();

    //查看个人某类型的所有订单
    Order[] getUserAllOrderByType(long userId, OrderType type);

    //修改订单
    boolean updateOrder(Order order);

    //删除订单
    boolean deleteOrder(Long id);

    //用户查看未接订单
    Order[] getUserUndoneOrders(long userId);

    //用户查看未接订单
    Order[] getUserAllOrders(long userId);

    //用户查看代买订单
    Order[] getUserAllBuyOrders(long userId);

    //用户查看代送订单
    Order[] getUserAllSendOrders(long userId);

    //用户查看代取订单
    Order[] getUserAllTakeOrders(long userId);

    //用户查看已接订单
    Order[] getUserDoneOrders(long userId);

    // 管理员快递员查看未接订单
    Order[] getUndoneOrders();

    // 管理员查看已接订单
    Order[] getDoneOrders();

    //快递员查看已接订单
    Order[] getStaffDoneOrders(long courierId);

    //快递员查看已接代买订单
    Order[] getStaffDoneBuyOrders(long courierId);

    //快递员查看已接代送订单
    Order[] getStaffDoneSendOrders(long courierId);

    //快递员查看已接代取订单
    Order[] getStaffDoneTakeOrders(long courierId);

    // 获取指定订单
    Order getOrderById(long id);

}
