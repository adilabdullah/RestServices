package ServiceConsume;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.Node;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


public class UrlContentConsume {

	public static void urlpostcontent() throws IOException {
		
		  try {
		  
		  URL url = new URL(
		  "http://203.215.160.147/Alfalah/ALTDemo/Alfalah.asmx?wsdl");
		  URLConnection con = url.openConnection();
		  
		  con.setDoInput(true); con.setDoOutput(true);
		  con.setConnectTimeout(20000); con.setReadTimeout(20000);
		  con.setUseCaches(false); con.setDefaultUseCaches(false);
		  
		  con.setRequestProperty("Content-Type", "text/xml");
		  
		  InputStreamReader reader = new InputStreamReader(
		  con.getInputStream());
		  
		  StringBuilder buf = new StringBuilder(); char[] cbuf = new
		  char[2048]; int num; while (-1 != (num = reader.read(cbuf))) {
		  buf.append(cbuf, 0, num); }
		  
		  String result = buf.toString();
		  System.err.println("\nResponse from server after POST:\n" + result);
		  
		  } catch (Exception ex) {
		  
		  System.out.println("ERROR : " + ex); }
		  
		  try {

				File fXmlFile = new File("XMLtest.xml");
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory
						.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(fXmlFile);

				// optional, but recommended
				// read this -
				// http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
				doc.getDocumentElement().normalize();

				System.out.println("Root element :"
						+ doc.getDocumentElement().getNodeName());

				NodeList nList = doc.getElementsByTagName("tem:TranToEnglish");

				System.out.println("----------------------------");

				for (int temp = 0; temp < nList.getLength(); temp++) {

					Node nNode = (Node) nList.item(temp);

					System.out.println("\nCurrent Element :" + nNode.getNodeName());

					if (nNode.getNodeType() == Node.ELEMENT_NODE) {

						Element eElement = (Element) nNode;

						String urdu = eElement
								.getElementsByTagName("tem:fatherName_IN").item(0)
								.getTextContent();
						byte[] byteText = urdu.getBytes(Charset.forName("UTF-8"));
						// To get original string from byte.
						String originalString = new String(byteText, "UTF-8");

						// byte[] array = originalString.getBytes("UTF-8");
						// convert the byte array back to a string as UTF-8
						// String s = new String(array, Charset.forName("UTF-8"));
						// System.out.println(s);
						// forcing strings encoded as UTF-8 as an incorrect encoding
						// like
						// say ISO-8859-1 causes strange and undefined behavior
						// String sISO = new String(array,
						// Charset.forName("ISO-8859-1"));
						// System.out.println(sISO);

						// Writing Process
						BufferedWriter writer = null;
						try {
							byte[] bytes = new byte[10];

							String str = new String(byteText,
									Charset.forName("UTF-8"));

							System.out.println(str);

							writer = new BufferedWriter(new FileWriter("test.txt"));

							originalString = originalString
									.replaceAll("\u0152", "");

							writer.write(originalString);

						} catch (IOException e) {
						} finally {
							try {
								if (writer != null)
									writer.close();
							} catch (IOException e) {
							}
						}
						
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} 
	}
	
}
