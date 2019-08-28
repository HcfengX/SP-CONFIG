package com.tedu.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tedu.dao.Dao;
import com.tedu.pojo.Door;

@Controller
public class TestController {
		@RequestMapping("/TestSpringMVC")
		public String testSpringmvc() {
			System.out.println("成功运行springmvc");
			return "test";
		}
		
		//在spring配置文件中配置了接口扫描器，spring会为da下的所有接口匹配实现类，也会创建实例，根据类型匹配
		//将创建好的Doormapper接口的实例赋给dao
		@Autowired 
		private Dao dao;
		
		@RequestMapping("/testssm")
		public String testssm() {
			System.out.println("成功发射天宫三号");
			//查询所有门店信息
			List<Door> list=dao.findAll();
			for (Door door : list) {
				System.out.println(door);
			}
			return "test";
		}
}
