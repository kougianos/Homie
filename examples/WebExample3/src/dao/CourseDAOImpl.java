package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Course;

public class CourseDAOImpl implements CourseDAO {
	
	private static final String SQL_FIND_COURSES_OF_STUDENT = "SELECT c.id,"
			+ " c.name, c.description, sc.grade "
			+ "FROM student s, course c, studentcourse sc WHERE "
			+ "c.id = sc.course_id AND s.id = sc.student_id "
			+ "AND s.id = ?";
	
	private ConnectionFactory factory;
    
    public CourseDAOImpl(boolean pool)
    {
    	factory = ConnectionFactory.getInstance(pool);
    }
	
	@Override
	public List<Course> getCoursesOfStudent(Long id) {
		List<Course> courses = new ArrayList<>();
		
		try (
				Connection connection = factory.getConnection();
				PreparedStatement statement = DAOUtil.prepareStatement(connection, SQL_FIND_COURSES_OF_STUDENT, false, id);
		        ResultSet resultSet = statement.executeQuery();)
		{
        	while (resultSet.next()) 
        		courses.add(map(resultSet));
		} 
		catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		
		return courses;
	}
	
	private static Course map(ResultSet resultSet) throws SQLException {
        Course course = new Course();
        course.setId(resultSet.getLong("id"));
        course.setName(resultSet.getString("name"));
        course.setDescription(resultSet.getString("description"));
        course.setGrade(resultSet.getDouble("grade"));
        return course;
    }

}
