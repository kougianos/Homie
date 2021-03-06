package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entities.Student;
import jpautils.EntityManagerHelper;

public class StudentDAOImpl implements StudentDAO {
	
	@Override
	public List<Student> list() {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createNamedQuery("Student.findAll");
		@SuppressWarnings("unchecked")
		List<Student> students = query.getResultList();  
        return students;
	}

	@Override
	public Student find(Long id) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Student student = em.find(Student.class, id); 
        return student;
	}

}
