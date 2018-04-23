package com.vg.HibernateMapping.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vg.HibernateMapping.model.College;
import com.vg.HibernateMapping.model.Student;

@Repository
@Transactional
public class daoimpl implements dao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean insertCollege(College college) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(college);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public College singleCollege(int id) {
		// TODO Auto-generated method stub
		try {
			return sessionFactory.getCurrentSession().get(College.class, id);

		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public boolean inseretStudent(Student student) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(student);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public List<Student> allStudents() {
		// TODO Auto-generated method stub
		try {
			return sessionFactory.getCurrentSession().createQuery("From Student").list();

		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public List<College> allCollege() {
		// TODO Auto-generated method stub
		try {
			return sessionFactory.getCurrentSession().createQuery("From College").list();

		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

}
