package jdbctest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {
public static void main(String[] args) {
         readfromDB();
		//insertIntoDB();
		//updateIntoDB();
       //deleteIntoDB();
	}
private static void deleteIntoDB() {
	// TODO Auto-generated method stub
	try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "1234");
			Statement	statement = connection.createStatement();) {
			
			int rowsDeleted = statement.executeUpdate("delete from account where accno=1;");
			System.out.println("Number of rows Deleted: "+rowsDeleted);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	
}
private static void updateIntoDB() {
	// TODO Auto-generated method stub
	try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "1234");
			Statement	statement = connection.createStatement();) {
			
			int rowsUpdated = statement.executeUpdate("update account set balance=15000 where accno=2;");
			System.out.println("Number of rows Updated: "+rowsUpdated);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	
}
private static void insertIntoDB() {
	// TODO Auto-generated method stub
	try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "1234");
			Statement	statement = connection.createStatement();) {
			
			int rowsInserted = statement.executeUpdate("insert into account values (2, 'Mary', 'Lucy', 150000);");
			System.out.println("Number of rows Inserted: "+rowsInserted);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	
}
private static void readfromDB() {
	try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "1234");
			Statement	statement = connection.createStatement();) {
			
			ResultSet resultSet = statement.executeQuery("select * from account");
			while (resultSet.next()) {				
				System.out.println(resultSet.getInt(1) + ", " + resultSet.getString(2) + ", " + resultSet.getString(3) + ", " + resultSet.getInt(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
}

}
