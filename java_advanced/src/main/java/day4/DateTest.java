package day4;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

public class DateTest {
	public static void main(String[] args) {
		
		LocalDate date = LocalDate.now();
		
		LocalDate birth = //LocalDate.of(1992, 10, 16);
						  LocalDate.parse("1992-10-16");
		
		Period period = Period.between(birth, date);
		System.out.println("내가 살아온 날은 " + period.getYears() + "년 " + period.getMonths() + "월 " + period.getDays() + "일"); 
		
		// 시간
		LocalTime stime = LocalTime.of(9, 10);  // 9시 10분 출근
		LocalTime etime = LocalTime.of(16, 30); // 4시 30분 퇴근
		Duration duration = Duration.between(stime, etime);
		System.out.println("오늘 일한 시간은 " + duration.toHours() + "시간 " + (duration.toMinutes() % 60) + "분");
		
		// 한번에 나타내고 싶으면 LocalDate로 표현 가능
		
	}
}
