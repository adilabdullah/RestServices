package com.java.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	public static Connection Conn()
	{
		Connection conn=null;
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","alhamd","alhamdpress786");
		
	}
	catch(Exception e)
	{
	System.err.println(e);
	}
	return conn;
	}

}
