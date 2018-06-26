import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.Statement;

public class ActiveThread extends Thread {
	
   long id = 0;
   int start = 0;
   int end = 0;
   private Thread t;
   private String threadName;
   private java.sql.Statement statement;
   private ResultSet resultSet = null;
   private List pathtotraverse;
	
	
	ActiveThread(long tracking_id, int source, int destination){
		this.id = tracking_id;
		this.start = source;
		this.end = destination;
		
	}
	
	public void start(){
		
		Dijkstra dj = new Dijkstra();
		Vertex [] varray = dj.calldij();
		pathtotraverse = dj.pathOf(dj.SrcCity[this.start],dj.DestCity[this.end],varray);
//		for(int i=0; i<pathtotraverse.size();i++){
//			System.out.println(pathtotraverse.get(i));
//		}
		
//		System.out.println("Starting " +  threadName );
	      if (t == null) {
	         t = new Thread(this);
	         t.start ();
	      }
	}
	public void run() {
//	      System.out.println("Running " +  threadName );
		 Database db = new Database();
	      db.connection();
	      try {
			statement= db.connect.createStatement();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	      for(int i=0; i<pathtotraverse.size();i++){
				System.out.println(pathtotraverse.get(i));
//			
			try {
				String sqlupdate = "update feedback.package SET Current_City = \""+ pathtotraverse.get(i)+"\" where Tracking_ID = "+ this.id;
				statement.executeUpdate(sqlupdate);
//				String query = "Select Current_City from feedback.package where Tracking_ID = "+ this.id;
				
//				resultSet  = statement.executeQuery(query);
//				while(resultSet.next()){
//					System.out.println(resultSet.getString(1));
//				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
	      
	      
	      
	      try {	         
	            Thread.sleep(10000);
	      }catch (InterruptedException e) {
	         System.out.println("Thread " +  threadName + " interrupted.");
	      }
	      
	    
	      
	 }
	      db.disconnect();  
	      
	      
	      
	      
	      
//	      System.out.println("Thread " +  threadName + " exiting.");
	   }
}
