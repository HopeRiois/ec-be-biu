package com.co.biu.ecommerce.utils;

import java.time.LocalDate;
import java.time.Period;

public class DateUtils {

	public static boolean hasFiftyYears(LocalDate date) {
		if (date == null) {
			return false;
		}

		LocalDate hoy = LocalDate.now();
		Period edad = Period.between(date, hoy);
		return edad.getYears() >= 15;
	}

}
