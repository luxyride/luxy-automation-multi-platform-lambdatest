package common;

import java.util.Date;
import java.time.LocalDate;
import java.text.SimpleDateFormat;

public class GetCurrentDateTime {

	static Date dateTime;

	public static String getCurrentDateTime(String curDateTime) {
		try {
			dateTime = new Date();
			SimpleDateFormat formatTime = new SimpleDateFormat("ddMMyyyy_kkmmss");
			curDateTime = formatTime.format(dateTime);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return curDateTime;
	}

	public static String getMonthYear(String monthYear, String Scenario) {
		try {
			LocalDate today = LocalDate.now();
			int currMonth = today.getMonthValue();
			int currYear;
			if (Scenario.equalsIgnoreCase("addCard"))
				currYear = today.getYear() + 1;
			else
				currYear = today.getYear() + 2;

			String nextYear = String.valueOf(currYear);
			System.out.print(nextYear.substring(nextYear.length() - 2));

			monthYear = currMonth + "/" + nextYear.substring(nextYear.length() - 2);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return monthYear;
	}

	public static String getCurrentDate(String curYear) {
		try {
			dateTime = new Date();
			SimpleDateFormat formatTime = new SimpleDateFormat("ddMMyyyy");
			curYear = formatTime.format(dateTime);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return curYear;
	}

	public static String getCurrentYear(String curYear) {
		try {
			dateTime = new Date();
			SimpleDateFormat formatTime = new SimpleDateFormat("yyyy");
			curYear = formatTime.format(dateTime);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return curYear;
	}
}
