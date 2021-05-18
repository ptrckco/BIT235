import java.sql.*; 
import java.sql.Connection;
import java.sql.DriverManager;
public class StudentTable {
	static final String DB_URL = "jdbc:mysql://localhost:3306/emp";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "mysql";

// Method to create a new DB connection and display data from table
	   public static void getDBConn(){
	    	 Connection conn = null;
	  	     Statement stmt = null;
	  	     ResultSet rs = null;

	  	     
	  	   try{
	  	      //STEP 2: Register JDBC driver
	  	      Class.forName("com.mysql.jdbc.Driver");

	  	      //STEP 3: Open a connection
	  	      System.out.println("Connecting to database...");
	  	      conn = DriverManager.getConnection(DB_URL,USER,PASS);
	  	      System.out.println("Connected to database..."+conn.toString());


		  	 PreparedStatement sname = conn.prepareStatement("CREATE TABLE Students(id INT NOT NULL, first VARCHAR(255),last VARCHAR(255), PRIMARY KEY ( id ));");

		  	    int resultvalue = sname.executeUpdate();
	  			if (resultvalue>0) 
	  			System.out.println(resultvalue + " row(s) created successfully");
	  			else
	  			System.out.println("Error occured No row is inserted successfully");
	  			
	   
	  	      
	  	      //STEP 4: Execute a query
	  	      System.out.println("Creating statement...");
	  	      stmt = conn.createStatement();
	  	      String sql;
	  	      sql = "INSERT INTO Students VALUES (10001,  'Adam', 'Smith'), (10003, 'Jake', 'Blake'), (10004, 'Jones', 'David');";
	  	      stmt.execute(sql);
	  	      sql = "SELECT * FROM Students";
	  	      rs = stmt.executeQuery(sql);

	  	      
	  	      
	  	      //STEP 5: Extract data from result set
	  	      while(rs.next()){
	  	       //Retrieve by column name
	  	         int id  = rs.getInt("id");

	  	         String first = rs.getString("first");
	  	         String last = rs.getString("last");


	  	       //Display values
	  	         System.out.println("ID: " + id);

	  	         System.out.println("FIRST: " + first);
	  	         System.out.println("LAST: " + last);

	  	      }
	  	
	  	    	
	  	    	  
	  	      
	  	      
	  	      //STEP 6: Clean-up environment
	  	      //rs.close();
	  	      //stmt.close();
	  	      //conn.close();

	  	    
		     }catch(SQLException se){
		        //Handle errors for JDBC
		        se.printStackTrace();
		     }catch(Exception e){
		        //Handle errors for Class.forName
		        e.printStackTrace();
		     }
	  	   	finally {
		  		//STEP 6: Clean-up environment
		  		 if (rs != null) {
		  	        try {
		  	            rs.close();
		  	        } catch (SQLException e) {  }
		  	    }
		  	    if (stmt != null) {
		  	        try {
		  	            stmt.close();
		  	        } catch (SQLException e) {  }
		  	    }
		  	    if (conn != null) {
		  	        try {
		  	            conn.close();
		  	        } catch (SQLException e) {  }
		  	    }

		  	 }
	  	   



		     }//end try
	   

		    	
		    
		   //main 
		   public static void main(String[] args) {
			   getDBConn();
			   System.out.println("First database connection!");
	}//end main
		   
	}//end FirstExample


