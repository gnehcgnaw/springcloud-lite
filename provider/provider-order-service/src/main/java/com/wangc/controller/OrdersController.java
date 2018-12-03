package com.wangc.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wangc.entity.Orders;
import com.wangc.entity.User;
import com.wangc.service.OrdersService;
import com.wangc.service.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author gnehcgnaw
 * @since 2018-12-03
 */
@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private UserFeignClient userFeignClient ;
    @Autowired
    private OrdersService ordersService ;
    @GetMapping("get_all")
    public List getAll(){
        return ordersService.list(null);
    }

    @GetMapping("get_msg")
    public User getMsg( String phone ){

        Wrapper<Orders> queryMapper = new QueryWrapper<>();
       ((QueryWrapper<Orders>) queryMapper).eq("receiver_phone" ,phone);
        Orders orderById = ordersService.getOne(queryMapper);
        if (orderById!=null){
            return  userFeignClient.getUser(Long.parseLong(orderById.getReceiverPhone()));
        }else{
            return null ;
        }
    }
}
