package ru.rrozhkov.easykin.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	private static final DateFormat SDF = new SimpleDateFormat("dd.MM.yyyy");
	
	public static Date parse(String date){
		try{
			return SDF.parse(date);
		}catch(Exception e){
			return null;
		}
	}
	
	public static String format(Date date){
		return SDF.format(date);
	}
}