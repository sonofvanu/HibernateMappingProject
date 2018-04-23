package com.vg.HibernateMapping.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vg.HibernateMapping.model.Person;
import com.vg.HibernateMapping.model.PersonDetail;

@Repository
@Transactional
public class daoimpl implements dao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean regPerson(Person person) {
		// TODO Auto-generated method stub

		try {
			sessionFactory.getCurrentSession().save(person);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public List<Person> allPerson() {
		// TODO Auto-generated method stub
		List<Person> all = null;
		try {
			all = sessionFactory.getCurrentSession().createQuery("From Person").list();
			return all;
		} catch (Exception e) {
			// TODO: handle exception
			return all;
		}
	}

	@Override
	public boolean regPersonDetail(PersonDetail person) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(person);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public Person singlePerson(int id) {
		// TODO Auto-generated method stub
		try {
			return sessionFactory.getCurrentSession().get(Person.class, id);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

}
