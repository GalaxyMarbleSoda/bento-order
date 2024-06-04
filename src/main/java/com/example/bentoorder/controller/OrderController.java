// OrderController.java
package com.example.bentoorder.controller;

import com.example.bentoorder.dto.OrderDTO;
import com.example.bentoorder.service.OrderService;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

import org.apache.catalina.Host;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;
    
    @GetMapping("/get")
    public List<OrderDTO> getAllOrders() {
    	return orderService.getAllOrders();
    }

    @PostMapping("/submit")
    public String placeOrder(@RequestBody OrderDTO orderDTO, HttpServletRequest req) {
    	orderDTO.setIp(req.getRemoteAddr());
        orderService.saveOrder(orderDTO);
        System.out.println(req.getRemoteAddr());
        return "Order placed successfully!";
    }
    
//    @PostMapping("/check/{id}")
//    public String placeOrder(@RequestBody OrderDTO orderDTO, HttpServletRequest req) {
//    	orderDTO.setIp(req.getRemoteAddr());
//        orderService.saveOrder(orderDTO);
//        System.out.println(req.getRemoteAddr());
//        return "Order placed successfully!";
//    }
}
