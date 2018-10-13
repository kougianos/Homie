package dao;

import java.util.List;

import entities.Course;

public interface CourseDAO {
	
	List<Course> getCoursesOfStudent(Long id);

}
