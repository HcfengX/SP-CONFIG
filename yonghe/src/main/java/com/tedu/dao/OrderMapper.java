package com.tedu.dao;

import java.util.List;

import com.tedu.pojo.Order;


public interface OrderMapper {

	public List<Order> findAll();

	public void addOrder(Order order);

	public Order findById(Integer id);

	public int updateById(Order order);

	
}
