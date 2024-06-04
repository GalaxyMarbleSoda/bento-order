package com.example.bentoorder.service;

import org.springframework.jdbc.core.RowMapper;

import com.example.bentoorder.dto.OrderDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class OrderRowMapper implements RowMapper<OrderDTO> {
    @Override
    public OrderDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        OrderDTO order = new OrderDTO();
        order.setId(rs.getInt("id"));
        order.setCustomerName(rs.getString("customer_name"));
        order.setOrderItems(Arrays.asList(rs.getString("order_items").split(",")));
        order.setTotalAmount(rs.getInt("total_amount"));
        order.setRemark(rs.getString("remark"));
        order.setTimeStamp(rs.getTimestamp("time_stamp"));
        return order;
    }
}