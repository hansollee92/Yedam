package day2;

import java.time.LocalDate;
import java.util.Calendar;

public class DateUtil {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

		LocalDate date = LocalDate.now();
		System.out.println(date);

		LocalDate birth = LocalDate.of(1999, 03, 25);
		System.out.println(birth);
		
		String date1 = StringUtil.getDate("2025","10","29");
		System.out.println(date1);

		String regDate = "2025-10-10";
		String[] result = regDate.split("-");
		System.out.println(result[0]);

		String syear = StringUtil.getSplitYear("2025-10-29");
		System.out.println(syear); // 2025출력
	}
}
