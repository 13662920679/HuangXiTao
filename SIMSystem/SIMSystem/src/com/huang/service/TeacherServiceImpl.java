package com.huang.service;

import java.util.List;

import com.huang.dao.TeacherMapper;
import com.huang.pojo.Teacher;

public class TeacherServiceImpl implements TeacherService{
	
	private TeacherMapper teacherMapper;
	

	public TeacherMapper getTeacherMapper() {
		return teacherMapper;
	}


	public void setTeacherMapper(TeacherMapper teacherMapper) {
		this.teacherMapper = teacherMapper;
	}


	@Override
	public List<Teacher> showAllTeacher() {
		List<Teacher> showAllTeacher = teacherMapper.showAllTeacher();
		return showAllTeacher;
	}


	

}
