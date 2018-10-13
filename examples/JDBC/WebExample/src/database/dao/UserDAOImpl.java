package database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.entities.User;

public class UserDAOImpl implements UserDAO 
{
	private static final String SQL_FIND_BY_ID = "SELECT id, email, firstname, lastname, birthdate FROM User WHERE id = ?";
	private static final String SQL_LIST_ORDER_BY_ID = "SELECT id, email, firstname, lastname, birthdate FROM User ORDER BY id";
	private static final String SQL_INSERT = "INSERT INTO User (email, password, firstname, lastname, birthdate) VALUES (?, MD5(?), ?, ?, ?)";
    
    private ConnectionFactory factory;
    
    public UserDAOImpl(boolean pool)
    {
    	factory = ConnectionFactory.getInstance(pool);
    }

	@Override
	public User find(Long id) {
		User user = null;
		
		try (
			Connection connection = factory.getConnection();
			PreparedStatement statement = DAOUtil.prepareStatement(connection,SQL_FIND_BY_ID, false, id);
	        ResultSet resultSet = statement.executeQuery();)
		{
	        if (resultSet.next()) 
	            user = map(resultSet);
		} 
		catch (SQLException e) {
			System.err.println(e.getMessage());
		}
     
        return user;
	}

	@Override
	public List<User> list() {
		List<User> users = new ArrayList<>();

        try (
            Connection connection = factory.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_LIST_ORDER_BY_ID);
            ResultSet resultSet = statement.executeQuery();
        ) {
            while (resultSet.next()) {
                users.add(map(resultSet));
            }
        } 
        catch (SQLException e) {
        	System.err.println(e.getMessage());
        }

        return users;
	}

	@Override
	public int create(User user) 
	{
		int ret = -1;
		Object[] values = { user.getEmail(), user.getPassword(), user.getFirstname(), user.getLastname(),
				DAOUtil.toSqlDate(user.getBirthdate()) };

		try (Connection connection = factory.getConnection();
				PreparedStatement statement = DAOUtil.prepareStatement(connection, SQL_INSERT, true, values);) 
		{
			int affectedRows = statement.executeUpdate();
			ret = affectedRows;
			if (ret == 0) {
				System.err.println("Creating user failed, no rows affected.");
				return ret;
			}

			try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					user.setId(generatedKeys.getLong(1));
					return ret;
				} 
				else {
					System.err.println("Creating user failed, no generated key obtained.");
					return -1;
				}
			}
		} 
		catch (SQLException e) {
			System.err.println("Creating user failed, no generated key obtained.");
			return ret;
		}
	}
	
	private static User map(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getLong("id"));
        user.setEmail(resultSet.getString("email"));
        user.setFirstname(resultSet.getString("firstname"));
        user.setLastname(resultSet.getString("lastname"));
        user.setBirthdate(resultSet.getDate("birthdate"));
        return user;
    }
	

}
