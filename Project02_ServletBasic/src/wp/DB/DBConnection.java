package wp.DB;
import java.sql.*;
public class DBConnection {
	public static Connection CreateConnection(){
		Connection conn= null;

		String url="jdbc:mysql://localhost:3306/guestbook";
		String username="root";
		String password="lich";

		try {
			// load Driver
			Class.forName("com.mysql.jdbc.Driver");
			
			// create connection
			conn = DriverManager.getConnection(url,username,password);
			
			System.out.println("Connected successfully ...");
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(SQLException ex){
			ex.printStackTrace();
			System.out.println("Error connection " + ex);
		}

		// create connection
		return conn;
	}
//	public static Connection CreateConnection(){
//	Connection conn= null;
//
//	String url="jdbc:mysql://localhost:3306/webtoeic";
//	String username="root";
//	String password="1234";
//	
////	String url="jdbc:mysql://172.16.87.152/webtoeic";
////	String username="dinhthai";
////	String password="3306";
//
//	try {
//		// load Driver
//		Class.forName("com.mysql.jdbc.Driver");
//		
//		// create connection
//		conn = DriverManager.getConnection(url,username,password);
//		
//		System.out.println("Connected successfully hihi...");
//	} 
//	catch (ClassNotFoundException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	catch(SQLException ex){
//		ex.printStackTrace();
//		System.out.println("Error connection " + ex);
//	}
//
//	// create connection
//	return conn;
//}

public static Connection CreateConnection(String hostName, String sqllnstanceName,String database, String userName, String password){
		
		Connection conn= null;

		try {
			// load Driver
			Class.forName("com.mysql.jdbc.Driver");
			
			String url="jdbc:mysql://" + sqllnstanceName +"/"+database;
			
			// create connection
			conn = DriverManager.getConnection(url,userName,password);
			
			System.out.println("Connected successfully hihi...");
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(SQLException ex){
			ex.printStackTrace();
			System.out.println("Error connection " + ex);
		}

		// create connection
		return conn;
	}
	
	public static Connection getConnection() throws SQLException,ClassNotFoundException{
		String hostName = "";
		String sqllnstanceName = "";
		String database = "";
		String userName="";
		String password="";
		
		return CreateConnection(hostName,sqllnstanceName,
				database,userName,password);
	}

}
