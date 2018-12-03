package com.wangc.service.impl;

import com.wangc.entity.Orders;
import com.wangc.mapper.OrdersMapper;
import com.wangc.service.OrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gnehcgnaw
 * @since 2018-12-03
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {

}
