package util;

import java.time.LocalDate;

public class AgeCalculator {
	public static String calculate(String birthDate) {
		LocalDate date = LocalDate.parse(birthDate);
		
		int birthdayDayOfYear = date.getDayOfYear();
		int birthdayYear = date.getYear();
		
		date = LocalDate.now();
		
		int todayDayOfYear = date.getDayOfYear();
		int todayYear = date.getYear();
		
		int age = todayDayOfYear <= birthdayDayOfYear? todayYear - birthdayYear : todayYear - birthdayYear - 1;
		
		return String.valueOf(age);
	}
}