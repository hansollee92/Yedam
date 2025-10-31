package day2;

public class StringUtil {

	/**
	 * @author kym
	 * @since 1.4
	 * 
	 *        주민번호로 출생년도 추출
	 * @param id
	 * @return
	 */
	public static String getYear(String id) {
		// id가 없으면 반값 리턴
		if (id == null) {
			return "";
		}
		String result = id.substring(0, 4);
		return result;
	}

	// 년, 월, 일을 join해서 리턴 ...
	public static String getDate(String... date) {
//		return date[0] + "-" + date[1] + "-" + date[2];
		return String.join("-", date);
	}
	
	public static String getDate(String y, String m, String d) {
//		return y + "-" + m + "-" + d;
		return String.join("-", y,m,d);
	}
	
//	getSplitYear() // y-m-d 형식의 날짜문자열을 받아서 '-' 나누어서 연도만 리턴
	public static String getSplitYear(String y) {
		String[] result = y.split("-");
		return result[0];
	}
}
