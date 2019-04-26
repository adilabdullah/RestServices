package com.java.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.OraclePreparedStatement;

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

/*	public static void main(String[] args)
	{
	System.out.println(Conn());	
	String sql="select * from challan where sno='2'";
	OraclePreparedStatement pst;
	try {
		pst = (OraclePreparedStatement) Conn().prepareStatement(sql);
		ResultSet rs=pst.executeQuery();
		if(rs.next()){
		System.out.println(rs.getString(1));
		System.out.println(rs.getString(2));
		System.out.println(rs.getString(3));
		System.out.println(rs.getString(4));
		System.out.println(rs.getString(5));
		System.out.println(rs.getString(6));
	   }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	
	}   */
}
