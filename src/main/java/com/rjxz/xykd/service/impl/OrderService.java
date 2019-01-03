package com.rjxz.xykd.service.impl;

import com.rjxz.xykd.bean.AccountType;
import com.rjxz.xykd.bean.Order;
import com.rjxz.xykd.bean.OrderType;
import com.rjxz.xykd.dao.OrderMapper;
import com.rjxz.xykd.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public boolean submitOrder(Order order) {
        return orderMapper.insert(order) > 0;
    }

    @Override
    public Order[] getAllOrderByType(OrderType type) {
        return orderMapper.selectAllByType(type);
    }

    @Override
    public Order[] getAllOrder() {
        return orderMapper.selectAll();
    }

    @Override
    public Order[] getUserAllOrderByType(long userId, OrderType type) {
        return orderMapper.selectAllByUserIdAndType(userId, type);
    }

    @Override
    public boolean updateOrder(Order order) {
        return orderMapper.update(order) > 0;
    }

    @Override
    public boolean deleteOrder(Long id) {
        return orderMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public Order[] getUserUndoneOrders(long userId) {
        return (Order[]) (Arrays.asList(orderMapper.selectAllByUserId(userId)).stream().filter(it -> it.getCourierid() == null).toArray());
    }

    @Override
    public Order[] getUserAllOrders(long userId) {
        return orderMapper.selectAllByUserId(userId);
    }

    @Override
    public Order[] getUserAllBuyOrders(long userId) {
        return (Order[]) (Arrays.asList(orderMapper.selectAllByUserId(userId)).stream().filter(it -> it.getOrdertype() == OrderType.BUY).toArray());
    }

    @Override
    public Order[] getUserAllSendOrders(long userId) {
        return (Order[]) (Arrays.asList(orderMapper.selectAllByUserId(userId)).stream().filter(it -> it.getOrdertype() == OrderType.SEND).toArray());
    }

    @Override
    public Order[] getUserAllTakeOrders(long userId) {
        return (Order[]) (Arrays.asList(orderMapper.selectAllByUserId(userId)).stream().filter(it -> it.getOrdertype() == OrderType.TAKE).toArray());
    }

    @Override
    public Order[] getUserDoneOrders(long userId) {
        return (Order[]) (Arrays.asList(orderMapper.selectAllByUserId(userId)).stream().filter(it -> it.getCourierid() != null).toArray());
    }

    @Override
    public Order[] getUndoneOrders() {
        return orderMapper.selectNoCourierId();
    }

    @Override
    public Order[] getDoneOrders() {
        return orderMapper.selectHaveCourierId();
    }

    @Override
    public Order[] getStaffDoneOrders(long courierId) {
        return orderMapper.selectByCourierId(courierId);
    }

    @Override
    public Order[] getStaffDoneBuyOrders(long courierId) {
        return (Order[]) (Arrays.asList(orderMapper.selectByCourierId(courierId)).stream().filter(it -> it.getOrdertype() == OrderType.BUY).toArray());
    }

    @Override
    public Order[] getStaffDoneSendOrders(long courierId) {
        return (Order[]) (Arrays.asList(orderMapper.selectByCourierId(courierId)).stream().filter(it -> it.getOrdertype() == OrderType.SEND).toArray());
    }

    @Override
    public Order[] getStaffDoneTakeOrders(long courierId) {
        return (Order[]) (Arrays.asList(orderMapper.selectByCourierId(courierId)).stream().filter(it -> it.getOrdertype() == OrderType.TAKE).toArray());
    }

    @Override
    public Order getOrderById(long id) {
        return orderMapper.selectByPrimaryKey(id);
    }
}
