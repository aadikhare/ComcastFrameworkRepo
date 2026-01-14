package com.comcast.crm.generic.webDriverUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	SimpleDateFormat sdf=null;
	
	public int getRandomNumber() {
		Random random = new Random();
		int randomNum=random.nextInt(5000);
		return randomNum;
	}
		public String getSystemDate(){
			Date dateObj = new Date();
			sdf = new SimpleDateFormat("yyyy-MM-dd");
			String date=sdf.format(dateObj);
			return date;
		}
		
		
		public String getrequiredDate(int day){
			
			
			Date dateObj = new Date();
			sdf = new SimpleDateFormat("yyyy-MM-dd");
			sdf.format(dateObj);
			Calendar cal1=sdf.getCalendar();
			cal1.add(Calendar.DAY_OF_MONTH, day);
			String requiredDate=sdf.format(cal1.getTime());
			return requiredDate;
		}
		
		
	
		
		
	}


