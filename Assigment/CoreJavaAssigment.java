package assigment1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CoreJavaAssigment {
	
	Connection connection;
	PreparedStatement pStatement;
	ResultSet rSet;
	//Constructor
	public CoreJavaAssigment() throws ClassNotFoundException, SQLException {
		connection = MyConnection.getMyConnection();
		
	}
	
// * method for accessing/ fetching data from Employee table
public void display() throws SQLException {
	pStatement = connection.prepareStatement("select * from student");
	
	rSet = pStatement.executeQuery();
		while(rSet.next())
		{
			System.out.print(rSet.getInt(1)+"\t");
			System.out.print(rSet.getString(2)+"\t");
			System.out.print(rSet.getString(3)+"\t");
			System.out.print(rSet.getString(4)+"\t");
			System.out.print(rSet.getString(5)+"\t");
			System.out.print(rSet.getString(6)+"\t");
			System.out.println();
		}
	}

// * method for Updating data from customer table
public void update(int roll,String name,String contact,String city,String email,String standard) throws SQLException {
pStatement =connection.prepareStatement("update student set name = ?,contact= ?,city= ?,email= ?,standard= ? where roll = ?");
		pStatement.setString(1, name);
		pStatement.setString(2, contact);
		pStatement.setString(3, city);
		pStatement.setString(4, email);
		pStatement.setString(5, standard);
		pStatement.setInt(6, roll);
		int n=pStatement.executeUpdate();
		
		
	}
	
//* method for Deleting data from customer table
public void delete(int roll) throws SQLException {
pStatement =connection.prepareStatement("delete from student where roll = ?");
	pStatement.setInt(1, roll);
	int n=pStatement.executeUpdate();
	}

//* method for inserting data from student table
public void insertRecord(int roll,String name,String contact,String city,String email,String standard) throws SQLException {
		pStatement = connection.prepareStatement("insert into student values(?,?,?,?,?,?)");
		pStatement.setInt(1, roll);
		pStatement.setString(2, name);
		pStatement.setString(3, contact);
		pStatement.setString(4, city);
		pStatement.setString(5, email);
		pStatement.setString(6, standard);
		int n= pStatement.executeUpdate();
		
	}


	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		Scanner sc1=new Scanner(System.in);
		CoreJavaAssigment obj=new CoreJavaAssigment();
		char ch = 0;
		do {
		System.out.println("--------------------Menu---------------------");
		System.out.println("1. Add");
		System.out.println("2. Display");
		System.out.println("3. Update");
		System.out.println("4. Delete");
		System.out.println("5. Exit");
		System.out.println("----------------------------------------------");
		System.out.print("Enter the Choice : ");
		
		int choice=sc.nextInt();
		System.out.println("----------------------------------------------");
		switch(choice)
		{
		case 1:
		{
			do {
			System.out.print("Enter RollNo.: ");
			int rollno=sc.nextInt();
			System.out.print("Enter Name: ");
			
			String name=sc1.nextLine();
			System.out.print("Enter Contact No.: ");
			String contact=sc1.nextLine();
			System.out.print("Enter City: ");
			String city=sc1.nextLine();
			System.out.print("Enter Email ID: ");
			String email=sc1.nextLine();
			System.out.print("Enter Standard: ");
			String standard=sc1.nextLine();
			obj.insertRecord(rollno, name, contact, city, email, standard);
			System.out.println("----------------------------------------------");
			obj.display();
			System.out.println("----------------------------------------------");
			System.out.print("Do you want to add more records(Y/N): ");
			
			ch=sc.next().charAt(0);
			}while(ch=='y' || ch=='Y');
			System.out.println("----------------------------------------------");
			obj.display();
			System.out.println("----------------------------------------------");
			//call display method
		}
		break;
		case 2:
			System.out.println("----------------------------------------------");
			obj.display();
			break;
		case 3:
			System.out.print("Enter RollNo.: ");
			int rollno=sc.nextInt();
			System.out.print("Enter Name: ");
			
			String name=sc1.nextLine();
			System.out.print("Enter Contact No.: ");
			String contact=sc1.nextLine();
			System.out.print("Enter City: ");
			String city=sc1.nextLine();
			System.out.print("Enter Email ID: ");
			String email=sc1.nextLine();
			System.out.print("Enter Standard: ");
			String standard=sc1.nextLine();
			obj.update(rollno, name, contact, city, email, standard);
			System.out.println("----------------------------------------------");
			obj.display();
			System.out.println("----------------------------------------------");
			System.out.println("Record updated Successfully");
			break;
		case 4:
			
			obj.display();
			System.out.println("----------------------------------------------");
			System.out.print("Enter RollNo.: ");
			int rollNo=sc.nextInt();
			System.out.print("Are you sure want to Delete(Y/N): ");
			char c=sc1.next().charAt(0);
			System.out.println("----------------------------------------------");
			if(c=='y' || c=='Y')
			{
				obj.delete(rollNo);
			}
			obj.display();
			break;
		case 5:
			
			
			System.out.println("Exit Successfully");
			System.exit(0);
			break;
		}
		}while(ch!='n'|| ch!='N');
		//---------------------------------------------------------------
		CoreJavaAssigment p1= new CoreJavaAssigment();
		
	
		sc.close();
	}


}
