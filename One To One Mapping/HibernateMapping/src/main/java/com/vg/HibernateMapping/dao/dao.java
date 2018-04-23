package com.vg.HibernateMapping.dao;

import java.util.List;

import com.vg.HibernateMapping.model.Person;
import com.vg.HibernateMapping.model.PersonDetail;

public interface dao {
	public boolean regPerson(Person person);
	
	public List<Person> allPerson();

	public boolean regPersonDetail(PersonDetail person);
	
	public Person singlePerson(int id);
	
}
