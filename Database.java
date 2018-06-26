import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	 public  Connection connect = null;
	 private static Statement statement = null;
	 private static PreparedStatement pst = null;
	 private static ResultSet resultSet = null;
	 
	 public void connection(){
	
	 try {
		 try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/feedback?", "root", "root");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
//		pst	 = connect
//                    .prepareStatement("insert into  feedback.package values (?, ?, ?, ?, ? , ?, ? , ? , ? , ?)");
		
//		String query = "SELECT "+ builder.toString()+ "feedback.comments";
//		statement = connect.createStatement();
		//pst = connect.prepareStatement(query);
		//pst.setDate(1, sqlDate);
//		pst.setString(2, new_row[1]);
//		pst.setString(3, new_row[2]);
//		pst.setString(4, new_row[3]);
//		pst.setString(5, new_row[4]);
//		pst.setString(6, new_row[5]);
//		pst.setString(7, new_row[6]);
//		pst.setString(8, new_row[7]);
//		pst.setString(9, new_row[8]);
//		pst.setString(10, new_row[9]);
//		pst.execute();
		//pst.executeUpdate();
		
//		  statement = connect.createStatement();
		 
//         resultSet = statement.executeQuery("SELECT * from feedback.comments");
//         writeResultSet(resultSet,new_row);
		
		
		
	
		
		
		
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	 

	 	


	 
	 }
	 public void disconnect(){
		 try {
			connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }


}
