package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Student;

public class StudentDAOImpl implements StudentDAO {

	private static final String SQL_FIND_BY_ID = "SELECT id, "
			+ "fname, mname, lname"
			+ " FROM student WHERE id = ?";
	private static final String SQL_LIST_ORDER_BY_ID = "SELECT * FROM student ORDER BY id";
	
	private ConnectionFactory factory;
    
    public StudentDAOImpl(boolean pool)
    {
    	factory = ConnectionFactory.getInstance(pool);
    }
	
	@Override
	public List<Student> list() {
		List<Student> students = new ArrayList<>();

        try (
            Connection connection = factory.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_LIST_ORDER_BY_ID);
            ResultSet resultSet = statement.executeQuery();
        ) {
            while (resultSet.next()) {
                students.add(map(resultSet));
            }
        } 
        catch (SQLException e) {
        	System.err.println(e.getMessage());
        }
        
		return students;
	}

	@Override
	public Student find(Long id) {
		Student student = null;
		
		try (
				Connection connection = factory.getConnection();
				PreparedStatement statement = DAOUtil.prepareStatement(connection,SQL_FIND_BY_ID, false, id);
		        ResultSet resultSet = statement.executeQuery();)
			{
		        if (resultSet.next()) {
		        	
		            student = map(resultSet);
		            CourseDAO cdao = new CourseDAOImpl(true);
		            student.setCourses(cdao.getCoursesOfStudent(student.getId()));
		            
		        }
			} 
			catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		
		return student;
	}
	
	
	private static Student map(ResultSet resultSet) throws SQLException {
        Student student = new Student();
        student.setId(resultSet.getLong("id"));
        student.setFname(resultSet.getString("fname"));
        student.setMname(resultSet.getString("mname"));
        student.setLname(resultSet.getString("lname"));
        return student;
    }

}
