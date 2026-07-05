package com.xue.order.service;

import com.xue.order.pojo.Order;

public interface OrderService {

    Order queryOrderById(Long orderId);

    void updateOrder(Order order);
}
