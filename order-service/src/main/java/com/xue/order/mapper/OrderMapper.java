package com.xue.order.mapper;

import com.xue.order.pojo.Order;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface OrderMapper {
    @Select("select * from tb_order where id = #{id}")
    Order findById(Long id);

    @Update("update tb_order set price = #{price}, name = #{name}, num = #{num}, user_id = #{userId} where id = #{id}")
    void update(Order order);
}
