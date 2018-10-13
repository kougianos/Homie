package dao;

import java.util.List;

import entities.Student;

public interface StudentDAO {

	List<Student> list();
	Student find(Long id);

}
