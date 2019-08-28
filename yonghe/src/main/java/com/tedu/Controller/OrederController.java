package com.tedu.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tedu.dao.Dao;
import com.tedu.dao.OrderMapper;
import com.tedu.pojo.Door;
import com.tedu.pojo.Order;

@Controller
public class OrederController {
	@Autowired
	OrderMapper dao;
	@Autowired
	Dao doorDao;
	//查询所有门店信息
	@RequestMapping("orderList")
	public String OrderList(Model model) {
		//查询所有门店信息
		List<Door> dlist = doorDao.findAll();
		//将所有门店集合存入model集合中
		model.addAttribute("dlist",dlist);
		//查询所有订单信息
		List<Order> list = dao.findAll();
		for(Order o:list) {
			System.out.println(o);
		}
		model.addAttribute("olist",list);
		return "order_list";
	}
	
	@RequestMapping("toAddOrder")
	public String toAddOrder(Model model) {
		//查询所有门店信息
		List<Door> dlist = doorDao.findAll();
		//将所有门店集合存入model集合中
		model.addAttribute("dlist",dlist);
		return "order_add";
	}
	
	//新增订单信息
	@RequestMapping("orderAdd")
	public String orderAdd(Order order) {
		dao.addOrder(order);
		return "forward:/orderList";
	}
	
	@RequestMapping("orderInfo")
	public String orderInfo(Integer id,Model model) {
		List<Door> dlist = doorDao.findAll();
		//将所有门店集合存入model集合中
		model.addAttribute("dlist",dlist);
		//1.根据id查订单
		Order order =dao.findById(id);
		//将订单信息存入到moder中，带入jsp中
		model.addAttribute("o",order);
		return "order_update";
	}
	
	@RequestMapping("/orderUpdate")	
	public String orderUpdate(Order order) {
		int rows = dao.updateById(order);
		return"forward:/orderList";
	}
}
