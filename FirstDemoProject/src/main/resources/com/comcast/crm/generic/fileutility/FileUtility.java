package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FileUtility {

	public String getDataFromProperyFile(String key) throws Exception {
		FileInputStream fis = new FileInputStream("./ConfigAppData/CommonData.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		
		String data = pObj.getProperty(key);
		return data;
		
			}
	

}
