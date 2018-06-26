import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Query {

	
	static Statement statement;
	java.sql.PreparedStatement pst;
	static ResultSet resultSet = null;
	private long tracking_id = 0;
	
	   
	  public  String[] queryset(long id){
		String source = null;
		String destination = null;
		String current_location = null;
		String[] cities = new String [2] ;
		this.tracking_id = id;
		Database db = new Database();
		db.connection();
	   
	   try {
		String query = "Select source,destination,Current_City from feedback.package where Tracking_ID = " + "'"+ id + "'";
		statement= db.connect.createStatement();
		resultSet  = statement.executeQuery(query);
//		System.out.println(resultSet.);
		
		while(resultSet.next()){
//			System.out.println(resultSet.getString(8));
//			System.out.println(resultSet.getInt(9));
//			for (int i=0; i<2; i++){
//			System.out.println(resultSet.getString(i+1));
//			cities[i] = resultSet.getString(i+1);
////			cities[i] =resultSet.getString(i+1);
//			System.out.println(cities[i]);
////			System.out.println(resultSet.getString(2));
////			cities[1] = resultSet.getString(2);
//			}
		
//			System.out.println(resultSet.getString(1));
//			System.out.println(resultSet.getString(2));
			source = resultSet.getString(1);
			destination = resultSet.getString(2);
			current_location = resultSet.getString(3);
		
		}
		
		
		
//		while(resultSet.next()){
//			id = resultSet.getLong(1);
//			id++;
//			System.out.println(id);
//		}
		 db.disconnect();
		 QueryThread qt = new QueryThread(tracking_id, source, destination, current_location);
		 qt.start();
		 
//		 cities[0] = source;
//		 cities[1] = destination;
			
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
//	  cities[1]=source;
//	  cities[2]= destination;
	  return (cities);
}
}
