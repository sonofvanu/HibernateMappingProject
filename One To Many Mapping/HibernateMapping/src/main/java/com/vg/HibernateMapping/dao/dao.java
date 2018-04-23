package com.vg.HibernateMapping.dao;

import java.util.List;

import com.vg.HibernateMapping.model.College;
import com.vg.HibernateMapping.model.Student;



public interface dao {

	
	public boolean insertCollege(College college);
	
	public College singleCollege(int id);
	
	public boolean inseretStudent(Student student);
	
	public List<Student> allStudents();
	
	public List<College> allCollege();
	
	
}
