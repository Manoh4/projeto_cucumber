package br.com.cucumber.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static Date obterDataComDiferencaDeDias(Integer dias) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, dias);
		return cal.getTime();
	}
}
