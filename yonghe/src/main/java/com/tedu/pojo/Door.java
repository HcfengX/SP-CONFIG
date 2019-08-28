package com.tedu.pojo;

public class Door {
	private String name;
	private Integer id;
	private String tel;
	private String addr;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "Door [name=" + name + ", id=" + id + ", tell=" + tel + ", addr=" + addr + "]";
	}
	
	
 }
