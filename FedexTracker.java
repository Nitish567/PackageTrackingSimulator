import java.util.Scanner;

public class FedexTracker {
	
	public static void main (String[] args){
		Packetthread pt = new Packetthread();
		Query query = new Query();
		Scanner scan = new Scanner (System.in);
		
		
		
		while (true){
				System.out.println("1. New Package");
				System.out.println("2. Query Package");
				System.out.println("3. Exit");
				
				switch (scan.nextInt()){
				
				case (1): pt.attributes();
					break;			
				case (2): 
					System.out.println("Enter tracking number");
					long q_id = scan.nextLong();
					String[] cities = query.queryset(q_id);
//					System.out.println(cities[0]);
//					System.out.println(cities[1]);
//					
					break;
				case (3):
//					System.err.println("Exit");
					System.exit(0);
					 
				
				
				}
				
				
		}
		
		
		
		
//		
//		Packetthread packet1;
//		//Packetthread packet2;
////		for (int i =0; i<2;i++){
//		packet1 = new Packetthread("Packet1");
//	//	packet2 = new Packetthread("Packet-2");
//		packet1.start();
//		//packet2.start();
////		}
		
	}

}
