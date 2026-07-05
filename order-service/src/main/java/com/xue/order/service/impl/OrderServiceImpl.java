package com.xue.order.service.impl;

import com.xue.order.clients.UserClient;
import com.xue.order.dto.UserDTO;
import com.xue.order.mapper.OrderMapper;
import com.xue.order.pojo.Order;
import com.xue.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UserClient userClient;

    @Override
    public Order queryOrderById(Long orderId) {
        // 1. 查询订单
        Order order = orderMapper.findById(orderId);
        // 2. 通过 Feign 远程调用 user-service 查询用户信息
        UserDTO user = userClient.findById(order.getUserId());
        // 3. 封装 user 到 Order
        order.setUser(user);
        // 4. 返回
        return order;
    }

    @Override
    public void updateOrder(Order order) {
        orderMapper.update(order);
    }
}
