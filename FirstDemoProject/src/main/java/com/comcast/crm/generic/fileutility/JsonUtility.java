package com.comcast.crm.generic.fileutility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtility {

	public String getDataFromJSONFile(String str) throws FileNotFoundException, IOException, ParseException {
	JSONParser parser = new JSONParser();
	Object object= parser.parse(new FileReader("./ConfigAppData/AppCommonData.json"));
	
	JSONObject map = (JSONObject)object;
	
	String data =map.get(str).toString();
	return data;
	}
	
}
