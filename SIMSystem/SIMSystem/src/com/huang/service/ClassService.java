package com.huang.service;

import java.util.List;

import com.huang.pojo.Cclass;

public interface ClassService {
	
	public List<Cclass> showAllClassByCid();
	
	public int delClass(String cid);
	
	public Cclass selectOneClass(String cid);
	
	public int updClass(String ctJava,String ctPython,String ctC,String cid);
	
}
