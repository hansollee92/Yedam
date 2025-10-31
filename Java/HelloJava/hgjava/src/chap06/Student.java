package chap06;

public class Student {
	// 객체 생성 클래스
	// 일단 객체를 만들면 아래와 같이 '필드, 생성자, 메소드'를 미리 주석으로 만들어놓는다.
	// 우리는 성적처리하는 것을 만들 것인데 일단 '이름, 성적'이 필요할 것이다
	
	// 필드 : 객체의 속성(데이터)
		String name;                           //값을 넣으면 안됨, 값 넣으면 값이 고정되어 버리니
		int kor;
		int eng;
		int math;
	
	// 생성자 : 객체 생성시 속성값을 초기화
		Student(String name, int kor, int eng, int math){      
			this.name = name;                 //매개변수의 이름을 필드이름과 동일하게 설정하면 구분이 되지 않기 때문에 this로 구분! 
			this.kor = kor;                   //다르게 적으면 this를 적을 필욘 없지만 관례적으로 헷갈리지 않도록 이렇게 같게 설정한다.
			this.eng = eng;
			this.math = math;
		}
	
	// 메소드 : 객체의 기능
		// 총점을 구하는 메소드
		int tot() {   
			int sum = this.kor + this.eng + this.math;    //(?)여기서의 this는 위의 그 매개변수? 그건가
			return sum;
		}

		// 평균을 구하는 메소드
		double avg() {
			return this.tot() / 3.0;
		}
		
		// 등급을 구하는 메소드
		char grade() {
			char gradeChar;
			switch((int)(this.avg() / 10)) {
				case 10:
				case 9:	gradeChar = 'A'; break;
				case 8:	gradeChar = 'B'; break;		
				case 7: gradeChar = 'C'; break;
				case 6: gradeChar = 'D'; break;
				default: gradeChar = 'F';
			}
			return gradeChar;			
		}
		
		
		
		
		
}//end class
