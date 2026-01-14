package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {

	public String getDataFromProperyFile(String str) throws IOException{
FileInputStream fis = new FileInputStream("./ConfigAppData/CommonData.properties");
		
		Properties pobj = new Properties();
		pobj.load(fis);
		String property=pobj.getProperty(str);
		return property;
		
		

		
	}
	
}
