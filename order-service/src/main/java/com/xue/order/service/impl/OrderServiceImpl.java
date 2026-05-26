package com.xue.order.service.impl;

import com.xue.order.mapper.OrderMapper;
import com.xue.order.pojo.Order;
import com.xue.order.service.OrderService;
import com.xue.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Order queryOrderById(Long orderId) {
//        return orderMapper.findById(orderId);
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        // 2.利用RestTemplate发起http请求，查询用户
        // 2.1.url路径
        String url = "http://userservice/user/" + order.getUserId();
        // 2.2.发送http请求，实现远程调用
        User user = restTemplate.getForObject(url, User.class);
        // 3.封装user到Order
        order.setUser(user);
        // 4.返回
        return order;
    }

    @Override
    public void updateOrder(Order order) {
        orderMapper.update(order);
    }
}
