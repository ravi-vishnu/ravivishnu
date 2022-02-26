package org.rocket.openshiftdemo;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.rocket.util.Util;

public class DBC11011 {

//--------------------------------------------------------	
//Please configure appropriate to you database and table
//-------------------------------------------------------------

	public static String serverName = "rs28"; // serverName
	public static int port = 3880; // port
	public static String databaseName = "RS27DDS1"; // databasename
	public static int driverType = 4; // drivertype 4 or 2
	public static int traceLevel = -1; // -1 trace All, more info at More info at
										// https://www.ibm.com/support/pages/node/82091
	
	public static String user = "ts3167"; // username
	public static String password = "maa1234"; // password
	
	public static String SQLQUERY = "SELECT BLOBVAL FROM " + "dbc_test"  ;
	
	
	

	
//-----------------------------------------------------------------	
	 public static final String NEW_LINE = System.getProperty("line.separator");
	private static String className = DBC11011.class.getSimpleName();
	
	private static String userDir() {
		 return System.getProperty("user.dir");
	}

//--------------------------------------------------------	


	
	
	
	private static String getDBUrl() {

		String URL = "jdbc:db2://";
		URL += serverName + ":";
		URL += port + "/";
		URL += databaseName + ":";
		URL += "user=" + user + ";";
		URL += "password=" + password + ";";

		URL += "traceLevel=" + traceLevel + ";";
		
		//String traceFile = userDir() + File.separatorChar +  DBC11011.class.getSimpleName() + "_jccTrace.txt";
		//URL += "traceFile=" + traceFile + ";";
		

		// ---------------------------------
		// Configuration relevant to DBC11011

		//URL += "progressiveStreaming=" + "no" + ";";
		//URL += "fullyMaterializeLobData=" + false + ";";
		//URL += "streamBufferSize=" + (Integer.MAX_VALUE-10) + ";";

		// ----------------------------------

		return URL;
	}


	
	  public static void  youQuery(java.sql.Connection con) throws Exception {
			
			
	    	
			String sqlQuery = "SELECT BLOBVAL FROM " + "dbc_test"  ;
			
			java.sql.PreparedStatement pstmt = null;
			pstmt = con.prepareStatement(sqlQuery);
			pstmt.setQueryTimeout(1);
			
			java.sql.ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				 
				Blob blob = rs.getBlob(1);
				 long blobLength = blob.length();
				  
				  byte [] buff = blob.getBytes(1, (int)blobLength);
				  
				  if(buff.length != blobLength) {
					  throw new SQLException("blobLength = " + blobLength + "Not equal to " + buff.length);
				  }
			}
		
			
			rs.close();
			pstmt.close();
		
				
		}
	    

	
	public static void dbCall(StringBuilder builder)  {

		
		try {
		
		
		Class.forName("com.ibm.db2.jcc.DB2Driver").newInstance();
		String url = getDBUrl();
		java.sql.Connection con = DriverManager.getConnection(url);
		builder.append("Got Connection "+ con);
		builder.append("Executing query SQLQUERY: " + SQLQUERY  + " ---with Connection "+ con);
		
		youQuery(con);
		con.close();
		
			
		String traceFile = userDir() + File.separatorChar +  DBC11011.class.getSimpleName() + "_jccTrace.txt";
		builder.append("Please collect the logs from " + traceFile + "Post it to Rocket for further assistance" );
		builder.append("Application finished...Thank you");
		}
		catch(Exception e) {
			builder.append(NEW_LINE).append(Util.getCursomStackTrace("exp", e).toString());;
		}
		
	

	
	}
}
