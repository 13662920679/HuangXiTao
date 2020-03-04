package com.huang.service;

import java.util.List;

import com.huang.dao.ClassMapper;
import com.huang.pojo.Cclass;

public class ClassServiceImpl implements ClassService{
	
	private ClassMapper classMapper;
	
	

	public ClassMapper getClassMapper() {
		return classMapper;
	}



	public void setClassMapper(ClassMapper classMapper) {
		this.classMapper = classMapper;
	}



	@Override
	public List<Cclass> showAllClassByCid() {
		List<Cclass> lc = classMapper.showAllClassByCid();
		return lc;
	}



	@Override
	public int delClass(String cid) {
		List<Cclass> lc = classMapper.selectClass(cid);
		Cclass c = new Cclass();
		for(Cclass cl:lc) {
			c=cl;
		}
		int num = c.getNum();
		System.out.println(num);
		if(num>0) {
			System.out.println("班级存在学生,不能被删除");
			
		}else {
			int delClass = classMapper.delClass(cid);
			return delClass;
		}
		
		return 0;
	}



	@Override
	public Cclass selectOneClass(String cid) {
		Cclass c = classMapper.selectOneClass(cid);
		return c;
	}



	@Override
	public int updClass(String ctJava, String ctPython, String ctC,String cid) {
		int updClass = classMapper.updClass(ctJava, ctPython, ctC, cid);
		return updClass;
	}
	
}
