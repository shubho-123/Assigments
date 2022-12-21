package assigment1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Connectivity {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		//register Driver
		//Class.forName("com.mysql.cj.jdbc.Driver"); //you can use also but for mysql 8 we can skip that but  for other framwork we required
		
		//establish connection
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/mornbatch", "root", "shubho123");
		
		//create Statement
		Statement statement= con.createStatement();
		
		//Execute Statement
		ResultSet reSet= statement.executeQuery("select * from student");
		
		//retrieve result
		while(reSet.next())
		{
			System.out.print(reSet.getInt("roll")+"\t");
			System.out.print(reSet.getString("name")+"\t");
			System.out.print(reSet.getString("contact")+"\t");
			System.out.print(reSet.getString("city")+"\t");
			System.out.print(reSet.getString("email")+"\t");
			System.out.print(reSet.getString("standard")+"\t");
			//System.out.print(reSet.getFloat("salary"));
			System.out.println();
		}
		//close connection
		statement.close();
		con.close();
	}
}
