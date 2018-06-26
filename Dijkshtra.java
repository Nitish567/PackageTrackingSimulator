import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;

class Dijkstra
  { 
//	static int SrcCity[] = new int[100000];
//	  static int DestCity[] = new int[100000];
	    
	
	static Vertex SrcCity[] = new Vertex[100000];
  static Vertex DestCity[] = new Vertex[100000];
  static Vertex PresCity[] = new Vertex[100000];
  
  
      public static void computePaths(Vertex source)
      {
          source.minDistance = 0.;
          PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
  	vertexQueue.add(source);
  
  		while (!vertexQueue.isEmpty()) {
  	    Vertex u = vertexQueue.poll();
  
              // Visit each edge exiting u
              for (Edge e : u.adjacencies)
              {
                  Vertex v = e.target;
                  double weight = e.weight;
                  double distanceThroughU = u.minDistance + weight;
                  	if (distanceThroughU < v.minDistance) {
                  		vertexQueue.remove(v);
                  		v.minDistance = distanceThroughU ;
                  		v.previous = u;
                  		vertexQueue.add(v);
                  	}
              }
          }
      }
  
      public static List<Vertex> getShortestPathTo(Vertex target)
      {
          List<Vertex> path = new ArrayList<Vertex>();
          for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
              path.add(vertex);
     
          Collections.reverse(path);
          return path;
      }
  
      public Vertex[] calldij()
      
      {  
//    	  System.out.println("in call");
		    Vertex v0 = new Vertex("Northborough");
		  	Vertex v1 = new Vertex("Edison");
		  	Vertex v2 = new Vertex("Pittsburgh");
		  	Vertex v3 = new Vertex("Allentown");
		  	Vertex v4 = new Vertex("Martinsburg");
		  	Vertex v5 = new Vertex("Charlotte");
		  	Vertex v6 = new Vertex("Atlanta");
		  	Vertex v7 = new Vertex("Orlando");
		  	Vertex v8 = new Vertex("Memphis");
		  	Vertex v9 = new Vertex("Grove City");
		  	Vertex v10 = new Vertex("Indianapolis");
		  	Vertex v11 = new Vertex("Detroit");
		  	Vertex v12 = new Vertex("New Berlin");
		  	Vertex v13 = new Vertex("Minneapolis");
		  	Vertex v14 = new Vertex("St.Louis");
		  	Vertex v15 = new Vertex("Kansas");
		  	Vertex v16 = new Vertex("Dallas");
		  	Vertex v17 = new Vertex("Houston");
		  	Vertex v18 = new Vertex("Denver");
		  	Vertex v19 = new Vertex("Salt Lake City");
		  	Vertex v20 = new Vertex("Phoenix");
		  	Vertex v21 = new Vertex("Los Angeles");
		  	Vertex v22 = new Vertex("Chino");
		  	Vertex v23 = new Vertex("Sacramento");
		  	Vertex v24 = new Vertex("Seattle");
  	
  
  	
  	
//  	v0.adjacencies = new Edge[]{ new Edge(v11,  586),
//  	                             new Edge(v3,  244),
//  	                           new Edge(v1,  200)};
		  	v0.adjacencies = new Edge[]{ new Edge(v11,  1),new Edge(v2,  1)};
		  	v1.adjacencies = new Edge[]{ new Edge(v0,  1),new Edge(v2, 1)};
		  	v2.adjacencies = new Edge[]{ new Edge(v3,  1),new Edge(v4,  1),new Edge(v1,  1)};
		 	v3.adjacencies = new Edge[]{new Edge(v2,  1), new Edge(v9, 1),new Edge(v11,  1)};
		 	v4.adjacencies = new Edge[]{new Edge(v8,  1),new Edge(v2,  1),new Edge(v5,  1)};
		 	v5.adjacencies = new Edge[]{new Edge(v4, 1),new Edge(v6,  1),new Edge(v10,  1)};
		 	v6.adjacencies = new Edge[]{new Edge(v7,  1),new Edge(v5,  1),new Edge(v8, 1)};
		 	v7.adjacencies = new Edge[]{new Edge(v1,  1),new Edge(v6,  1),new Edge(v17,1)};
		 	v8.adjacencies = new Edge[]{new Edge(v16, 1),new Edge(v6,  1), new Edge(v4,  1)};
		 	v9.adjacencies = new Edge[]{new Edge(v3, 1),new Edge(v10,  1) };
		 	v10.adjacencies = new Edge[]{new Edge(v5, 1),new Edge(v14,  1),new Edge(v9,1)};
		 	v11.adjacencies = new Edge[]{new Edge(v0,1),new Edge(v3,  1),new Edge(v12,  1)};
		 	v12.adjacencies = new Edge[]{new Edge(v13, 1 ),new Edge(v11,  1)};
		 	v13.adjacencies = new Edge[]{new Edge(v12,  1), new Edge(v19,  1),new Edge(v14, 1)};
		 	v14.adjacencies = new Edge[]{new Edge(v13, 1),new Edge(v15,  1),new Edge(v10,  1)};
		 	v15.adjacencies = new Edge[]{new Edge(v14, 1),new Edge(v18,  1)};
		 	v16.adjacencies = new Edge[]{new Edge(v18,  1),new Edge(v17, 1),new Edge(v8,  1)};
		 	v17.adjacencies = new Edge[]{new Edge(v16, 1),new Edge(v7,  1)};
		 	v18.adjacencies = new Edge[]{new Edge(v19, 1),new Edge(v20, 1),new Edge(v16, 1),new Edge(v15,  1)};
		 	v19.adjacencies = new Edge[]{new Edge(v18,  1),new Edge(v24,  1),new Edge(v23, 1),new Edge(v13,  1)};
		 	v20.adjacencies = new Edge[]{new Edge(v18,  1), new Edge(v22,  1)};
		 	v21.adjacencies = new Edge[]{ new Edge(v22,  1),new Edge(v23,  1)};
		 	v22.adjacencies = new Edge[]{ new Edge(v21,  1),new Edge(v20,  1)};
		 	v23.adjacencies = new Edge[]{new Edge(v19,  1),new Edge(v21, 1),new Edge(v24,  1)};
		 	v24.adjacencies = new Edge[]{ new Edge(v23,  1),new Edge(v19, 1)};
 	
		 	Vertex[] vertices = { v0, v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18, v19, v20, v21, v22, v23, v24 };
 
		    for(int a =0; a<vertices.length; a++){
		//    	 int k = new Random().nextInt(vertices.length);
		//    	 System.out.println("vertices");
		//    	 System.out.println(vertices.length);
		//    	 System.out.println(k);
		    	 SrcCity[a] = vertices[a];
		//    	 System.out.println(SrcCity[a]);
		//    	 int l = new Random().nextInt(vertices.length);
		    	 DestCity[a] = vertices[a];
		//    	 System.out.println(l);
		//    	 System.out.println(DestCity[a]);
		    	 
		    	
		    	//SrcCity[a] = (int)Math.random()*25;
		    	
		    	//DestCity[a] = (int)Math.random()*25;
		    	   
		     }
		//    System.out.println("vertices");
		  //       for (int i=0;i<25;i++){
		    //    	 
		        //	 computePaths(SrcCity[i]);
		      //  	
		        //	 for(int j=0; j<25; j++){
		        	// 
		        		// System.out.println("from "+SrcCity[i]+"Distance to " + DestCity[j] + ": " + DestCity[j].minDistance);
		          //  	 List<Vertex> path = getShortestPathTo(DestCity[j]);
		            //	 System.out.println("Path: " + path);     
		        	 //}	 
		   
		            	 
		         //}	
		    
		    
		         return vertices;
 
 
     }
      
      
      
      
      public List pathOf (Vertex src, Vertex dest,Vertex [] arr_city){
    //	  computePaths(src);
    //	  List<Vertex> path = getShortestPathTo(dest);
	//	return path;
    	  
    	  for (Vertex v : arr_city)
    	  {
    		  v.minDistance=Double.POSITIVE_INFINITY;
    		  v.previous=null;
    	  }
    	  computePaths(src);
    	 // System.out.println("Distance    : " + dest.minDistance + " " + "hops");
     	 List<Vertex> path = getShortestPathTo(dest);
     	// System.out.println("Path        : " + path);
      	return path;
      	
      }
      public Vertex getSrcCities(int i)
      {
    	  //System.out.println(SrcCity[i] +""+ i);
    	  return SrcCity[i];
      }
      public Vertex getDesCities(int i)
      {
    	  return DestCity[i];
      }
      
      
      
   
      
 }  