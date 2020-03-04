package com.huang.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.huang.pojo.Cclass;



public interface ClassMapper {
	
	public List<Cclass> showAllClassByCid();
	
	public int delClass(@Param("cid")String cid);
	
	public List<Cclass> selectClass(@Param("cid")String cid);
	
	public Cclass selectOneClass(@Param("cid")String cid);
	
	public int updClass(@Param("ctJava")String ctJava,@Param("ctPython")String ctPython,@Param("ctC")String ctC,@Param("cid")String cid);

}
