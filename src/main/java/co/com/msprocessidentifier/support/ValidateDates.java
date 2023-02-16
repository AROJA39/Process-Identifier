package co.com.msprocessidentifier.support;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class ValidateDates {

	public static HashMap<String, String> prepareData() {
		HashMap<String, String> dates = new HashMap<>();
		dates.put("1221", "1221");
		return dates;
	}

	public static boolean dateValidation(String date) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyMM");
			String formatToday = format.format(new Date());
			Date expirationDate = format.parse(date); 
			Date today;
			today = format.parse(formatToday);
			HashMap<String, String> data = prepareData();
			if (data.containsKey(date)) {
				return true;
			}
			if (expirationDate.after(today)) {
				return true;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return false;
	}
}
