package com.rjxz.xykd.dao;

import com.rjxz.xykd.bean.Order;
import com.rjxz.xykd.bean.OrderType;
import org.apache.ibatis.annotations.CacheNamespace;

@CacheNamespace
public interface OrderMapper {

    Order[] selectAll();

    int insert(Order order);

    int update(Order order);

    int deleteByPrimaryKey(Long id);

    Order[] selectAllByType(OrderType type);

    Order selectByPrimaryKey(Long id);

    Order[] selectAllByUserIdAndType(Long id, OrderType type);

    Order[] selectAllByUserId(Long userid);

    Order[] selectNoCourierId();

    Order[] selectHaveCourierId();

    Order[] selectByCourierId(Long courierid);

}
