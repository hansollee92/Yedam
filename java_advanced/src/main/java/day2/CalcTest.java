package day2;

public class CalcTest {
	public static void main(String[] args) {
		Calcurator cal = new Calcurator(5, 6);
		cal.add();
		System.out.println(cal.result);
		cal.mul();
		System.out.println(cal.result);
	}
}
