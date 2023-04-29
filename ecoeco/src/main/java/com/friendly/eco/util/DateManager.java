package com.friendly.eco.util;

import java.util.Calendar;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class DateManager {

	
	//Dday 구하기
	public long getResult(int year, int month, int date) {
		Calendar calendar=Calendar.getInstance();

		long toDay=calendar.getTimeInMillis();
		
		//원하는 날 등록
		calendar.set(year, month-1, date); 
		long setDay = calendar.getTimeInMillis(); 
				
		long dDay = (setDay - toDay) / (60*60*24*1000);
		
		return dDay;
		
	}
}
