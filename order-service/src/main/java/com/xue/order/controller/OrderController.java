package com.xue.order.controller;

import com.xue.order.pojo.Order;
import com.xue.order.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ficc")
@Tag(name = "订单管理", description = "订单的查询与更新接口")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Operation(summary = "根据订单ID查询订单", description = "通过订单ID查询订单详情，并包含关联的用户信息")
    @GetMapping("{orderId}")
    public Order queryOrderByUserId(
            @Parameter(description = "订单ID", required = true) @PathVariable("orderId") Long orderId) {
        return orderService.queryOrderById(orderId);
    }

    @Operation(summary = "更新订单", description = "根据传入的订单对象更新订单信息，返回操作结果")
    @PutMapping
    public String updateOrder(
            @Parameter(description = "订单对象，包含需要更新的字段") @RequestBody Order order) {
        orderService.updateOrder(order);
        return "success";
    }
}