package com.java.rest.consume;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.client.ClientResponse;

public class ConsumeRest {
public static void main(String[] args)
{
Client client=ClientBuilder.newClient();
WebTarget traget=client.target("https://bookme.pk/REST/API/rest_api.php?play_movies");
System.out.println(traget.request(MediaType.TEXT_XML).get(String.class));

//WebResource webResource = client.resource("https://bookme.pk/REST/API/rest_api.php?play_movies");
////MultivaluedMap formData = new MultivaluedMapImpl();
////formData.add("name1", "val1");
////formData.add("name2", "val2");
//ClientResponse response = traget.type("application/x-www-form-urlencoded").post(ClientResponse.class,"api-key","0724d9f9941803425ebac3e6659fd1af");


/*Client client=Client.create();
WebResource webres=client.resource("https://bookme.pk/REST/API/rest_api.php?play_movies");
ClientResponse cresp=webres.accept("text/html").get(ClientResponse.class);
if(cresp.getStatus()==200)
{
	String output=cresp.getEntity(String.class);
}  */


/*URL url;
try {
	url = new URL("https://bookme.pk/REST/API/rest_api.php?play_movies");

HttpURLConnection conn;
	conn = (HttpURLConnection) url.openConnection();
	conn.setDoOutput(true);
	conn.setRequestMethod("POST");
	conn.setRequestProperty("Authorization", "b1ea54317dc0663164ca6ca897254bd6f497bb392b0565a0116f87829a81d029");
	conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
System.out.println(conn.getOutputStream().toString());
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}  */

}
}
