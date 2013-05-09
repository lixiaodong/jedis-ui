package com.jedisui.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	public static String formatYyyyMMdd(Date date){
		return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(date);
	}
}
