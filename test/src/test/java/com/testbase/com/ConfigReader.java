package com.testbase.com;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
public Properties pro;
	
	public ConfigReader()
	{
		try {
			
			File srcs=new File("D:\\PAMS_24_08_2016\\test\\src\\test\\java\\com\\testbase\\com\\ConfigReader.java");
			FileInputStream fis=new FileInputStream(srcs);
			pro=new Properties();
			pro.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception is=="+e.getMessage());
		} 
		
		
	}
	         public String getgeckho()
	       {
		     String Gpath=pro.getProperty("GeckoDriver");
		     return Gpath;
	        }
	        public String getChromePath()
	      {
		    String path=pro.getProperty("chromepath");
		    return path;
	      }
	          public String getApplicationUrl()
	        {
		      String url=pro.getProperty("baseUrl");
		      return url;
	         }
	          public String getOrigin()
		        {
			      String From=pro.getProperty("From");
			      return From;
		         }
	          public String getDestination()
		        {
			      String Destination=pro.getProperty("To");
			      return Destination;
		         }

}
