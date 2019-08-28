package com.tedu.Controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.tedu.dao.Dao;
import com.tedu.pojo.Door;

public class TestMybatis {
	/*测试mybatis的运行环境
	 */
	public static void main(String[] args) throws IOException {
		//查询所有门店信息
		
		//1.读取maybatis-config.xml核心文件
		InputStream in = Resources.getResourceAsStream("mybatis/mybatis-config.xml");
		//2.获取工厂对象
		SqlSessionFactory Factory = new SqlSessionFactoryBuilder().build(in);
		//3.获取sqlsession对象
		SqlSession session = Factory.openSession();
		//4.执行sql语句
		System.out.println(111);
		Dao mapper = session.getMapper(Dao.class);
		List<Door> list = mapper.findAll();
		//5.输出结果
		for(Door d:list) {
			System.out.println(d);
		}
	}
}
