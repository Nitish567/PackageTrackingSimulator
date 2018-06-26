import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

class Packetthread extends Thread {
	private Thread t;
   private String threadName;
   PackageAttributes pa;
  
   private Statement statement;
   java.sql.PreparedStatement pst;
   private ResultSet resultSet = null;
   static long id = 0;
   String[] cities = {"Northborough MA","Edison NJ","Pittsburgh PA","Allentown PABD Strap Endlinksth","Martinsburg WV","Charlotte NC", "Atlanta GA","Orlando FL","Memphis TN" ,"Grove City OH","Indianapolis IN","Detroit MI","New Berlin WI","Minneapolis MN","St. Louis MO","Kansas KS","Dallas TX","Houston TX","Denver CO","Salt Lake City UT","Phoenix AZ","Los Angeles CA","Chino CA","Sacramento CA","Seattle WA"};
   String[] parcel = {"packaging","post"};
   String[] signature_services = {"required","not required"};
   String[] specialhandling = {"required","not required"};
   String[] services = {"Home Delivery","Store Pick-up"};
   Packetthread( String name) {
      threadName = name;
      System.out.println("Creating " +  threadName );
   }
   
   public Packetthread() {
	// TODO Auto-generated constructor stub
}

   private static java.sql.Timestamp getCurrentTimeStamp() {

		java.util.Date today = new java.util.Date();
		return new java.sql.Timestamp(today.getTime());

	}
   public void attributes(){
	   float weightofpackage = 0;
		String dimensions = null;
		String packaging = null;
		String signatureservice = null;
		String service = null;
		String specialhandlingsection = null;
		String source = null;
		String destination = null;
		int items = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Weight of the package");
		weightofpackage = scan.nextFloat();
		System.out.println("Enter Dimensions");
		scan.nextLine();
		dimensions = scan.nextLine();
		System.out.println("Enter number of items");
		items= scan.nextInt();
//		scan.nextLine();
		System.out.println("Enter Packaging");
		for (int k=0;k<parcel.length; k++){
			System.out.printf("%d. %s\n", k, parcel[k]);
		}
		int parcel_index = scan.nextInt();
		packaging = parcel[parcel_index];
		System.out.println("Enter Signature Service");
		for (int l=0;l<signature_services.length; l++){
			System.out.printf("%d. %s\n", l, signature_services[l]);
		}
		int signature_index = scan.nextInt();
		signatureservice = signature_services[signature_index];
		System.out.println("Enter Service");
		for (int m=0;m<services.length; m++){
			System.out.printf("%d. %s\n", m, services[m]);
		}
		int services_index = scan.nextInt();
		service = services[services_index];
		System.out.println("Special Handling Section - Signature required");
		
		for (int n=0;n<services.length; n++){
			System.out.printf("%d. %s\n", n, specialhandling[n]);
		}
		int specialhandling_index = scan.nextInt();
		
		
		specialhandlingsection = specialhandling[specialhandling_index];
		System.out.println("Select source and destination from the list below");
		
		for(int i=0;i<25;i++){
			
			System.out.printf("%d. %s\n", i, cities[i]);
			
			
		}
		int sourceindex = scan.nextInt();
		source = cities[sourceindex];
		for(int i=0;i<25;i++){
			
			System.out.printf("%d. %s\n", i, cities[i]);
			
			
		}
		int destinationindex = scan.nextInt();
		destination = cities[destinationindex];
		
		
//		System.out.println("Northborough MA,Edison NJ,Pittsburgh PA,Allentown PABD Strap Endlinksth,Martinsburg WV,Charlotte NC, Atlanta GA,Orlando FL,Memphis TN ,Grove City OH,Indianapolis IN,Detroit MI,New Berlin WI,Minneapolis MN,St. Louis MO,Kansas KS,Dallas TX,Houston TX,Denver CO,Salt Lake City UT,Phoenix AZ,Los Angeles CA,Chino CA,Sacramento CA,Seattle WA");
//		System.out.println("Enter source");
//		source = scan.nextLine();
//		System.out.println("Enter Destination");
//		destination = scan.nextLine();
		
		pa = new PackageAttributes(weightofpackage,dimensions,items,packaging,signatureservice,service,specialhandlingsection,source,destination);
		Database db = new Database();
		db.connection();
		
		try {
			String query = "Select max(Tracking_ID) from feedback.package ";
			statement= db.connect.createStatement();
			resultSet  = statement.executeQuery(query);
			while(resultSet.next()){
				id = resultSet.getLong(1);
				id++;
				System.out.println("Tracking_ID = " + id);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
//		try {
//			statement = db.connect.createStatement();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		try {
			pst	 = db.connect.prepareStatement("insert into  feedback.package values (?, ?, ?, ?, ? , ?, ? , ? , ? , ? , ?, ?, ?)");
			pst.setLong(1,id);
			pst.setFloat(2, weightofpackage);
			pst.setString(3, dimensions);
			pst.setString(4, signatureservice);
			pst.setString(5, packaging);
			pst.setString(6, service);
			pst.setString(7, specialhandlingsection);
			pst.setInt(8,items);
			pst.setString(9, source);
			pst.setString(10, destination);
			pst.setTimestamp(11,getCurrentTimeStamp());
			pst.setTimestamp(12,getCurrentTimeStamp());
			pst.setString(13, source);
			pst.execute();
		
		
			db.disconnect();
			ActiveThread at = new ActiveThread(id, sourceindex, destinationindex);
			at.start();
			
			
//			for(int i=0; i<pathtotraverse.size();i++){
//				System.out.println(pathtotraverse.get(i));
//			}
			
		
//			start(id,source,destination);
		
		
		
		
		
		
		
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
   
   
   
   
   
   
   
   
   }
//	public void run(){
//		System.out.println("in-run");
//		try {
//			t.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//
//		
//		
//		
////		pa.Print();
//
//		
//	}
//   public void start (long id, String source, String destination) {
//      System.out.println("Starting " +  threadName );
////      if (t == null) {
//         t = new Thread (this, source);
//         t.start ();
////      }
//   }
//   public void run(){
//	   
//	   System.out.println("running");
//	   
//   }
//	  public int hashCode(){
//			double id = 17;
//			id = 31*id + pa.weight;
//			System.out.println(id);
//			return (int) id;
//			
//		}
   
}

