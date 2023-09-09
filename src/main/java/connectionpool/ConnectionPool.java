package connectionpool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
	private static List<Connection> connectionsPool=new ArrayList<>();
	private static String driverPath="org.postgresql.Driver";
	private static String url="jdbc:postgresql://localhost:5432/DBName";
	private static String user="postgres";
	private static String password="root";
	
	private static final int POOL_SIZE=5;
	
	//to create Connection Object and store it in pool
	static Connection createConnection() {
		Connection connection=null;
		try {
			connection=DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	static {
		try {
			Class.forName(driverPath);
			for(int i=0;i<POOL_SIZE;i++)
			{
				Connection connection=createConnection();
				connectionsPool.add(connection);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	//get and utilize connection object from pool
	public static Connection getConnectionObject() {
		if(!connectionsPool.isEmpty())
		{
			return connectionsPool.remove(0);
		}
		else
		{
			return createConnection();
		}
	}
	
	
	//receive and store back connection object in pool
	public static void receiveConnectionObject(Connection connection) {
		if(connectionsPool.size()<POOL_SIZE) {
			connectionsPool.add(connection);
		}
		else {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
			
	}
}
