package com.tedu.dao;

import java.util.List;

import com.tedu.pojo.Door;

public interface Dao {
	//查询所有门店
	public List<Door> findAll();
	//新增门店
	public void addDoor(Door door);
	//删除门店
	public void doorDelete(Door door);
	//根据id查询门店信息
	public Door findById(Integer id);
	//根据id修改门店信息
	public void updateById(Door door);
		
}
