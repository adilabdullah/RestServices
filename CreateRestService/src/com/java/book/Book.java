package com.java.book;



import com.java.connection.DbConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.tomcat.jni.User;

import oracle.jdbc.OraclePreparedStatement;

import com.java.mapping.Challan;
import com.java.mapping.ResponseMap;

@Path("/Book")
public class Book {
List<Challan> arr=new ArrayList<Challan>();

public Book(){
arr.add(new Challan(1,81,9,10,"flyer","garden","pso","friday","may","43","19343"));
arr.add(new Challan(2,82,7,11,"flyer","garden","pso","friday","may","42","19263"));
arr.add(new Challan(3,83,5,12,"flyer","garden","pso","friday","may","41","19863"));
arr.add(new Challan(4,84,3,13,"flyer","garden","pso","friday","may","45","19433"));
arr.add(new Challan(5,85,1,14,"flyer","garden","pso","friday","may","40","19263"));
arr.add(new Challan(6,86,8,15,"flyer","garden","pso","friday","may","49","19873"));
arr.add(new Challan(7,87,9,16,"flyer","garden","pso","friday","may","48","19573"));
arr.add(new Challan(8,88,5,17,"flyer","garden","pso","friday","may","47","19873"));
arr.add(new Challan(9,89,2,18,"flyer","garden","pso","friday","may","46","19343"));
arr.add(new Challan(10,81,4,19,"flyer","garden","pso","friday","may","42","19663"));
arr.add(new Challan(11,82,7,20,"flyer","garden","pso","friday","may","43","19423"));	    
}
        @GET
	    @Path("/Test")
	    @Produces(MediaType.TEXT_PLAIN)
	    public String SayHelloXml()
	    {
	        return "This book is in xml format";
	    }
	    @GET
	    @Path("/GetData")
	    @Produces(MediaType.APPLICATION_JSON)
	    public List<Challan> SayJsonData()
	    {
	 //   	Connection conn=DbConnection.Conn();
			try{
				String sql="select * from challan where sno='2'";
				
	    		OraclePreparedStatement pst=(OraclePreparedStatement)DbConnection.Conn().prepareStatement(sql);
	    		ResultSet rs=pst.executeQuery();
	        	while(rs.next())
	        	{
	        		arr.add(new Challan(Integer.parseInt(rs.getString("sno")),Integer.parseInt(rs.getString("quantity")),
	        				Integer.parseInt(rs.getString("packets")),Integer.parseInt(rs.getString("challan_quantity")),
	        				rs.getString("day"),rs.getString("client"),rs.getString("address"),rs.getString("month"),rs.getString("c_date"),
	        				rs.getString("challan_no"),rs.getString("description")));
/*	        		ch.setSno(Integer.parseInt(rs.getString("sno")));
	        		ch.setCl_no(rs.getString("challan_no"));
	        		ch.setDesc(rs.getString("description"));
	        		ch.setQty(Integer.parseInt(rs.getString("quantity")));
	        		ch.setDay(rs.getString("day"));
	        		ch.setClient(rs.getString("client"));
	        		ch.setAddr(rs.getString("address"));
	        		ch.setMonth(rs.getString("month"));
	        		ch.setDat(rs.getString("c_date"));
	        		ch.setPkts(Integer.parseInt(rs.getString("packets")));
	        		ch.setCh_pkts(Integer.parseInt(rs.getString("challan_quantity")));  */
	        	//	return ch;
	        	}
			}
	        catch(Exception ex)
	        {ex.printStackTrace();
	        }
			return arr;
	    }  
	    @GET
	    @Path("/GetJsonData")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Challan SayHelloJson()
	    {
	    	Challan ch=new Challan();
    		ch.setSno(55);
    		ch.setCl_no("521478");
    		ch.setDesc("PSO Flyer");
    		ch.setQty(1000);
    		ch.setDay("Monday");
    		ch.setClient("PSO");
    		ch.setAddr("Clifton Karachi");
    		ch.setMonth("August");
    		ch.setDat("11");
    		ch.setPkts(50);
    		ch.setCh_pkts(50000);
    		return ch;
	    }
	    
	    @GET
	    @Path("/GetXmlData")
	    @Produces(MediaType.APPLICATION_XML)
	    public Challan SayHelloXml1()
	    {
	    	Challan ch=new Challan();
    		ch.setSno(55);
    		ch.setCl_no("521478");
    		ch.setDesc("PSO Flyer");
    		ch.setQty(1000);
    		ch.setDay("Monday");
    		ch.setClient("PSO");
    		ch.setAddr("Clifton Karachi");
    		ch.setMonth("August");
    		ch.setDat("11");
    		ch.setPkts(50);
    		ch.setCh_pkts(50000);
    		return ch;
	    }
	    
	    @GET
	    @Path("/AddData")
	    @Produces(MediaType.APPLICATION_JSON)
	    public ResponseMap AddChalan(@QueryParam("sno") int sno,@QueryParam("qty") int qty,
	    		@QueryParam("pkts") int pkts,@QueryParam("ch_pkts") int ch_pkts,
	    		@QueryParam("desc") String desc,@QueryParam("addr") String addr,
	    		@QueryParam("client") String client,@QueryParam("day") String day,
	    		@QueryParam("month") String month,@QueryParam("dat") String dat,
	    		@QueryParam("cl_no") String cl_no)
	    {
	    	arr.add(new Challan(sno,qty,pkts,ch_pkts,desc,addr,client,day,month,dat,cl_no));
	    /*	Challan ch=new Challan();
    		ch.setSno(55);
    		ch.setCl_no("521478");
    		ch.setDesc("PSO Flyer");
    		ch.setQty(1000);
    		ch.setDay("Monday");
    		ch.setClient("PSO");
    		ch.setAddr("Clifton Karachi");
    		ch.setMonth("August");
    		ch.setDat("11");
    		ch.setPkts(50);
    		ch.setCh_pkts(50000); */
	    	ResponseMap rmp=new ResponseMap();
	    	rmp.setCode(00);
	    	rmp.setDesc("Success");
    		return rmp;
	    }
	
	    
	    
	    @GET
	    @Path("/GetSpecific/{cusNo}")
	    @Produces(MediaType.APPLICATION_XML)
	    public Challan GetSno(@PathParam("cusNo") int no)
	    {
	    	Challan ch=arr.get(no);
	       return ch;
	    }
	    
	    @GET
	    @Path("/GetAll")
	    @Produces(MediaType.APPLICATION_XML)
	    public List<Challan> GetAll()
	    {
	    	return arr;
	    }
	    
	    
	    
	    
	    @POST
	    @Path("/GetPartData")
	    @Produces(MediaType.APPLICATION_XML)
	//    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	    public Challan PartData(@FormParam("challan_no") String clno,
	       @FormParam("sno") int id) throws IOException{
	    	try{
				String sql="select * from challan where sno="+id+" or challan_no='"+clno+"'";
				
	    		OraclePreparedStatement pst=(OraclePreparedStatement)DbConnection.Conn().prepareStatement(sql);
	    		ResultSet rs=pst.executeQuery();
	        	if(rs.next())
	        	{
	        		Challan cl=new Challan(Integer.parseInt(rs.getString("sno")),Integer.parseInt(rs.getString("quantity")),
	        				Integer.parseInt(rs.getString("packets")),Integer.parseInt(rs.getString("challan_quantity")),
	        				rs.getString("day"),rs.getString("client"),rs.getString("address"),rs.getString("month"),rs.getString("c_date"),
	        				rs.getString("challan_no")
	        				,rs.getString("description"));
	        		return cl;
	        	}
	    	}
	    	catch(Exception ex)
	    	{ex.printStackTrace();}
	    	return null;
	    	}
	    
	    @POST
	    @Path("/GetFormData")
	    @Produces(MediaType.APPLICATION_XML)
//	    @Consumes(MediaType.MULTIPART_FORM_DATA)
	    public Challan FormData(@PathParam("challan_no") String clno,
	    		@PathParam("sno") int id) throws IOException{
	    	try{
				String sql="select * from challan where sno="+id+" or challan_no='"+clno+"'";
				
	    		OraclePreparedStatement pst=(OraclePreparedStatement)DbConnection.Conn().prepareStatement(sql);
	    		ResultSet rs=pst.executeQuery();
	        	if(rs.next())
	        	{
	        		Challan cl=new Challan(Integer.parseInt(rs.getString("sno")),Integer.parseInt(rs.getString("quantity")),
	        				Integer.parseInt(rs.getString("packets")),Integer.parseInt(rs.getString("challan_quantity")),
	        				rs.getString("day"),rs.getString("client"),rs.getString("address"),rs.getString("month"),rs.getString("c_date"),
	        				rs.getString("challan_no")
	        				,rs.getString("description"));
	        		return cl;
	        	}
	    	}
	    	catch(Exception ex)
	    	{ex.printStackTrace();}
	    	return null;
	    	}  

}