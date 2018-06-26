import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QueryThread extends Thread{
	
	private String start = null;
	private String finish = null;
	private String current = null;
	private String current_city = null;
	private List<Object> pathtotraverse;
	private long tracking_id = 0;
	private int source_index = 0;
	private int destination_index = 0;
	private Thread t;
	private java.sql.Statement statement;
	private ResultSet resultSet = null;
	private List<Object>currentcity;
	private ArrayList<String> cCity = new ArrayList<String>();
//	private String[] current_cities = null;
	
	public QueryThread(long id,String source, String destination, String current_location) {
		// TODO Auto-generated constructor stub
		this.start = source;
		this.finish = destination;
		this.current = current_location;
		this.tracking_id = id;
		intermediate();
	
	}

	public void intermediate (){
		
		Packetthread pa = new Packetthread();
		for (int i =0; i<pa.cities.length;i++){
			if (start.equals(pa.cities[i])){
				source_index = i;
			}
			if (finish.equals(pa.cities[i])){
				destination_index = i;
			}
		}
	}
	public void start(){
		
		Dijkstra dj = new Dijkstra();
		Vertex [] varray = dj.calldij();
		pathtotraverse = dj.pathOf(dj.SrcCity[this.source_index],dj.DestCity[this.destination_index],varray);
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
//	      for(int i=0; i<pathtotraverse.size();i++){
//				System.out.println(pathtotraverse.get(i));
//			
			try {
//				String[] current_cities = null;
//				String sqlupdate = "update feedback.package SET Current_City = \""+ pathtotraverse.get(i)+"\" where Tracking_ID = "+ this.id;
//				statement.executeUpdate(sqlupdate);
				String query = "Select * from feedback.package where Tracking_ID = "+ this.tracking_id;
				resultSet = statement.executeQuery(query);
				
//				resultSet  = statement.executeQuery(query);
				while(resultSet.next()){
					System.out.print(resultSet.getLong(1)+ ", ");
					System.out.print(resultSet.getFloat(2)+ " ,");
					System.out.print(resultSet.getString(3)+ " ,");
					System.out.print(resultSet.getString(4)+ " ,");
					System.out.print(resultSet.getString(5)+ " ,");
					System.out.print(resultSet.getString(6)+ ", ");
					System.out.print(resultSet.getString(7)+ " ,");
					System.out.print(resultSet.getInt(8)+ " ,");
					System.out.print(resultSet.getString(9)+ " ,");
					System.out.print(resultSet.getString(10)+ " ,");
					System.out.print(resultSet.getTimestamp(12)+ " ,");
					System.out.print(resultSet.getTimestamp(11)+ " ,");
					System.out.print(resultSet.getString(13)+ " ");
					System.out.println();
					
					current_city = resultSet.getString(13);
				}
				for (int i1 =0; i1<pathtotraverse.size();i1++){
//					System.out.println(pathtotraverse.get(i1).toString());
					if (pathtotraverse.get(i1).toString().equals(current_city)){
//						System.out.println(pathtotraverse.get(i1).toString());
						cCity.add(pathtotraverse.get(i1).toString());
						
//						System.out.println("inside-if");
						break;
					}
					else {
//						System.out.println(i1);
//						System.out.println(currentcity.get(i1).toString());
//						currentcity.add(i1, pathtotraverse.get(i1));
//						System.out.println(pathtotraverse.get(i1).toString());
						cCity.add(pathtotraverse.get(i1).toString());
//						System.out.println("In-progress");
//						current_cities[i1] = pathtotraverse.get(i1).toString();
					}
					
//				if (pathtotraverse.contains(current_city)){
//				for(int j = 0; j<currentcity.size(); j++){
//					System.out.println(currentcity.get(j).toString());
//				}
					
				}
//				for (String l : cCity){
//					System.out.println(l);
////					if(l.equals(cCity.size()-1)){
////						System.out.println("Delivered");
////					}
////					else{
////						System.out.println("In-progress");
////					}
//					
//				}
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
	      
	      
	      
	      try {	         
	            Thread.sleep(10000);
	      }catch (InterruptedException e) {
	         System.out.println("Thread  interrupted.");
	      }
	      
	    
	      
//	 }
	      db.disconnect();  
	      
	      
	      
	      
	      
//	      System.out.println("Thread " +  threadName + " exiting.");
	   }


}
