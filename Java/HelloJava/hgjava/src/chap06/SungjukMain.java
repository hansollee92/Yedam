package chap06;

public class SungjukMain {
	// 이름을 잘 못 적었을 경우 : 오른쪽마우스 > Refactor > Rename을 눌러서 바꿔야함
	// 그냥 바꿀 경우 관계된 것까지 이상하게 될 수 있으니 이렇게 바꿔줘야한다
	// [TRY] StudentMain 이름을 SungjukMain으로 바꿔보자

	public static void main(String[] args) {
	// class를 만들었는데 main을 까먹으면 main쓰고 [Ctrl]+[Space]눌러서 불러올 수 있다	
	
		// 객체 생성
//		Student st1 = new Student("홍길동", 100, 100, 100);           //학생(st1)객체 생성 : 여기에는 필드와 메소드가 있음
		// new 가 붙으면 Student생성자를 이용해서 힙영역에 객체를 만든다
		// 즉, 홍길동, 100, 100, 100을 생성자 매개변수로 넣고, 그것들을 필드에 넣는다!
		// 힙에 name = 홍길동; kor = 100; eng = 100; math = 100; 으로 넣는다는 말!
	    /*     힙
	         name 홍길동     - 50번지        >>>> new Student("홍길동", 100, 100, 100); 가 그 번지를 st1을 메인메모리에 넣음! 
	         kor  100
	         eng  100
	         math 100
	     */
		
//		Student st1 = new Student("홍길동", 100, 100, 100);
//		Student st2 = new Student("강길동", 90, 90, 90);
//		Student st3 = new Student("이길동", 100, 50, 100);
//		Student st4 = new Student("황길동", 100, 40, 100);
//		Student st5 = new Student("고길동", 70, 100, 100);	
		
		
		// 객체생성 => 배열에 저장
		// 위의 방식대로 만들었더니 상당히 출력할 때 불편하다! 그래서 배열에 저장해보자!
//		Student[] students = {
//				new Student("홍길동", 100, 100, 100),
//				new Student("강길동", 90, 40, 90),
//				new Student("이길동", 100, 50, 100),
//				new Student("황길동", 100, 40, 50),
//				new Student("고길동", 70, 100, 100),
//				new Student("성춘향", 89, 100, 95),
//				new Student("김춘향", 90, 90, 90),
//				new Student("이춘향", 30, 50, 25),
//				new Student("황춘향", 75, 40, 88),
//				new Student("고춘향", 70, 99, 45)
//		};	
		
		
		
		// 객체 사용
//		System.out.printf("%s\t %d\t %d\t %d\t %d\t %.1f\t %s\n", 
//				st1.name, st1.kor, st1.eng, st1.math, st1.tot(), st1.avg(), st1.grade());
//		System.out.printf("%s\t %d\t %d\t %d\t %d\t %.1f\t %s\n", 
//				st2.name, st2.kor, st2.eng, st2.math, st2.tot(), st2.avg(), st2.grade());
//		System.out.printf("%s\t %d\t %d\t %d\t %d\t %.1f\t %s\n", 
//				st3.name, st3.kor, st3.eng, st3.math, st3.tot(), st3.avg(), st3.grade());
//		System.out.printf("%s\t %d\t %d\t %d\t %d\t %.1f\t %s\n", 
//				st4.name, st4.kor, st4.eng, st4.math, st4.tot(), st4.avg(), st4.grade());
		
		// st1.이렇게 치면 아래에 hashCode, toString... 이런애들이 뜨는데
		// 가장 위에 있는 object의 클래스가 가지고 있는 것을 상속받는데 이것들을 모두 사용할 수 있음
//		System.out.println(st1.kor);
//		System.out.println(st1.eng);
//		System.out.println(st1.math);
//		System.out.println(st1.tot());
//		System.out.println(st1.avg());
//		System.out.println(st1.grade());
		
		
		
		
		
		// 객체 사용(출력) 
		// for문 안돌리면 위에처럼... 상당히 지저분하게 출력해야하니~ 배열에 넣어서 for문을 돌리자!
//		for(int i=0; i<students.length; i++) {
//			System.out.printf("%s\t %d\t %d\t %d\t %d\t %.1f\t %s\n", 
//			students[i].name, 
//			students[i].kor, students[i].eng, students[i].math, 
//			students[i].tot(), students[i].avg(), students[i].grade());
//		}
		
		
		
		
		// 편하게 만들었긴 하지만
		// 만약에 데이터가 10000만개 된다고 생각해보자... 
		// 그러면 프로그램 볼려면 쭈우우우우욱 내려서 봐야함
		// 그래서 데이터를 따로 관리하는걸 만드는 게 좋음! >> Class 생성 > StudentDao만들기(Dao이름 많이 붙임)
		
		
		
		//객체생성 => 배열 데이터를 받아옴
		StudentDao stdao = new StudentDao();
		Student[] students = stdao.stData();		
		
		for(int i=0; i<students.length; i++) {
		System.out.printf("%s\t %d\t %d\t %d\t %d\t %.1f\t %s\n", 
			students[i].name, 
			students[i].kor, students[i].eng, students[i].math, 
			students[i].tot(), students[i].avg(), students[i].grade());
		}
		
		
		
		// 1)객체생성 class
		// 2)객체data생성 class
		// 3)실행class 
		// 1),2),3)만 있으면 이것들을 잘 조립해서 하는게 이게 바로 객체지향 프로그램! 
		
		
		
		
		
	
	}//end main
	
}//end class
