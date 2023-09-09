package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Product;

public class UserDao {
	
	private static String url="jdbc:postgresql://localhost:5432/productuser";
	private static String user1="postgres";
	private static String password="root";

	void saveProduct(User user2)
	{
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection=DriverManager.getConnection(url,user1,password);
			PreparedStatement preparedStatement=connection.prepareStatement("insert into userr values(?,?,?,?,?)");
			preparedStatement.setInt(1, user2.getId());
			preparedStatement.setString(2, user2.getUsername());
			preparedStatement.setString(3, user2.getPassword());
			preparedStatement.setString(4, user2.getEmail());
			preparedStatement.setLong(5, user2.getPhno());
			preparedStatement.execute();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void updateUser(User user2)
	{
		User existingUser =findById(user2.getId());
		if(existingUser!=null)
		{
			if(user2.getUsername()!=null)
				existingUser.setUsername(user2.getUsername());
			if(user2.getPassword()!=null)
				existingUser.setPassword(user2.getPassword());
			if(user2.getEmail()!=null)
				existingUser.setEmail(user2.getEmail());
			if(user2.getPhno()!=0)
				existingUser.setPhno(user2.getPhno());
			
			try {
				Class.forName("org.postgresql.Driver");
				Connection connection=DriverManager.getConnection(url, user1, password);
				PreparedStatement preparedStatement=connection.prepareStatement("update userr set username=?,password=?,email=?,phno=? where id=?");
				preparedStatement.setString(1, existingUser.getUsername());
				preparedStatement.setString(2, existingUser.getPassword());
				preparedStatement.setString(3, existingUser.getEmail());
				preparedStatement.setLong(4, existingUser.getPhno());
				preparedStatement.setInt(5, existingUser.getId());
				preparedStatement.executeUpdate();
				connection.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
				
		}
	}
	
	User findById(int id) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection=DriverManager.getConnection(url,user1,password);
			PreparedStatement preparedStatement=connection.prepareStatement("select * from userr where id=?");
			preparedStatement.setInt(1, id);
		ResultSet resultSet=preparedStatement.executeQuery();
		resultSet.next();
		int id1=resultSet.getInt(1);
		String username=resultSet.getString(2);
		String password=resultSet.getString(3);
		String email=resultSet.getString(4);
		long phno=resultSet.getLong(5);
		return new User(id1,username,password,email,phno);
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	User findUserByEmailPassword(String email,String password2) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection=DriverManager.getConnection(url,user1,password);
			PreparedStatement preparedStatement=connection.prepareStatement("select * from userr where email=? and password=?");
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password2);
		ResultSet resultSet=preparedStatement.executeQuery();
		resultSet.next();
		int id1=resultSet.getInt(1);
		String username=resultSet.getString(2);
		String password1=resultSet.getString(3);
		String email1=resultSet.getString(4);
		long phno=resultSet.getLong(5);
		return new User(id1,username,password1,email1,phno);
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	List<User> displayAll()
	{
		List<User> list = new ArrayList<User>();

		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection(url, user1, password);
			PreparedStatement preparedStatement = connection.prepareStatement("select * from userr");
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String password = resultSet.getString(3);
				String email = resultSet.getString(4);
				long phno = resultSet.getLong(5);
				User user = new User(id, name, password, email,phno);
				list.add(user);
				connection.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	void deleteUser(int id) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection(url, user1, password);
			PreparedStatement preparedStatement = connection.prepareStatement("delete from userr where id=?");
			preparedStatement.setInt(1, id);
			preparedStatement.execute();
			System.out.println("Data deleted ");

			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
}
