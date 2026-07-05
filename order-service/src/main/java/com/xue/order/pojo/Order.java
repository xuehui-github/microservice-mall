package com.xue.order.pojo;

import com.xue.order.dto.UserDTO;
import lombok.Data;

@Data
public class Order {
    private Long id;
    private Long price;
    private String name;
    private Integer num;
    private Long userId;
    private UserDTO user;
}
