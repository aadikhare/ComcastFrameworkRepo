package com.comcast.crm.generic.fileutility;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonUtility {

	public  String getDataFromJson(String key) throws Exception {
		
		FileReader fileR = new FileReader("./ConfigAppData/AppCommonData.json");
		JSONParser pObj = new JSONParser();
		
		Object obj = pObj.parse(fileR);
		JSONObject map = (JSONObject)obj;
		
		String data=(String)map.get(key);
		return data;
		
		
		
		
		
		

	}

}
