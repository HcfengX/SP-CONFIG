package com.tedu.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tedu.dao.Dao;
import com.tedu.pojo.Door;
@Controller
public class DoorController {
	@Autowired
	Dao dao;
	
	@RequestMapping("{p}")
	public String pang(@PathVariable String p) {
		return p;
	}
	/*
	 * 访问doorList执行doorList方法。查询所有门店信息带到door_List.jsp进行显示
	 */
	
	@RequestMapping("/doorList")
	public String doorList(Model model) {
		//查询所有门店信息
		List<Door> list = dao.findAll();
		model.addAttribute("list",list);
		//将门店集合存入model中
		return "door_list";
	}
	
	/*
	 * 2.新增门店信息管理
	 */
	@RequestMapping("doorAdd")
	public String doorAdd(Door door) {
		//通过在方法上声明一个door对象，用于接收浏览器发过来的name.tell.addr参数的值
		//调用dao的门店添加门店的方法
		dao.addDoor(door);
		return "forward:/doorList";
	}
	
	//删除门店
	@RequestMapping("doorDelete")
	public String doorDelete(Door door,Model model) {
		dao.doorDelete(door);
		 return doorList(model);
	}
	
	/*4.根据id修改门店信息，先根据id查询门店
	 */
	@RequestMapping("doorInfo")
	public String doorInfo(Integer id,Model model) {
		//根据id查询门店信息
		Door door = dao.findById(id);
		//将门店对象存入model中
		model.addAttribute("door",door);
		//转发门店修改页面，将数据进行回显
		return"door_update";
	}
	//根据id修改门店信息
	@RequestMapping("/doorUpdate")
	public String doorUpdate(Door door) {
		//调用dao去修改门店信息
		dao.updateById(door);
		//转向门店页面
		return "forward:/doorList" ;
	}
	
	
}
