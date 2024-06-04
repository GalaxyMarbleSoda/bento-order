// OrderService.java
package com.example.bentoorder.service;

import com.example.bentoorder.dto.OrderDTO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void saveOrder(OrderDTO orderDTO) {
        String sql = "INSERT INTO orders (customer_name, order_items, total_amount, remark, ip) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, orderDTO.getCustomerName(), String.join(", ", orderDTO.getOrderItems()), orderDTO.getTotalAmount(), orderDTO.getRemark(), orderDTO.getIp());
    }
    
    public List<OrderDTO> getAllOrders(){
    	String query = "SELECT id, customer_name, order_items, total_amount, remark, time_stamp FROM orders";
//    	System.out.println(jdbcTemplate.query(query, new OrderRowMapper()).get(0));
    	return jdbcTemplate.query(query, new OrderRowMapper());
    }
    
    public void paidChecked(int id, boolean isChecked) {
    	String sql = "UPDATE orders SET is_checked=? WHERE id=?";
    	jdbcTemplate.update(sql, isChecked, id);
	}
}
