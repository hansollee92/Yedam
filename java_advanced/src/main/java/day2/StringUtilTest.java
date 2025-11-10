package day2;

public class StringUtilTest {
	public static void main(String[] args) {
		String year = StringUtil.getYear("19900801");
		System.out.println(year);

		String date = StringUtil.getDate("2025", "10", "29");
		System.out.println(date); // "2025-10-20"
	}
}
