package com.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springdemo.entity.Student;
@Repository
public class StudentDAOImpl implements StudentDAO{

	//need to inject session factory
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	
	public List<Student> getStudents() {
		
		//get current hibernate session
		Session currentSession=sessionFactory.getCurrentSession();
		
		
		//create a query
		Query<Student> query= currentSession.createQuery("from Student order by firstName",Student.class);
		
		
		//execute query and  get list
		List<Student> students=query.getResultList();
		
		
		//return list
	return students;
	
	}

	@Override
	public void saveStudent(Student thestudent) {
		//get current hibernate session
		
		Session currentSession=sessionFactory.getCurrentSession();
		//save student
		currentSession.saveOrUpdate(thestudent);
	}

	@Override
	public Student getStudent(int theId) {
		
		//get current session
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		//get the student based on Id from DB
		Student thestudent=currentSession.get(Student.class, theId);
		return thestudent;
		
		
		
	
	}

	@Override
	public void deleteStudent(int theId) {
		
		
		Session currentSession=sessionFactory.getCurrentSession();
		Query theQuery=currentSession.createQuery("delete from Student where id=:studentId");
		theQuery.setParameter("studentId",theId);
		theQuery.executeUpdate();
		
	}

	@Override
	public List<Student> searchStudents(String theSearchName) {
		Session currentSession=sessionFactory.getCurrentSession();
		Query theQuery=null;
		if(theSearchName!=null && theSearchName.trim().length()>0) {
			theQuery=currentSession.createQuery("from Student where lower(firstName) like : theName or lower(lastName) like : theName",Student.class);
			theQuery.setParameter("theName","%" + theSearchName.toLowerCase()+"%");
		}
	    else {
            // theSearchName is empty ... so just get all customers
            theQuery =currentSession.createQuery("from Student", Student.class);            
        }
		   List<Student> students = theQuery.getResultList();
		return students;
		
	}
	

}
