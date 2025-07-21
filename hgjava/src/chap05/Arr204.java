package chap05;

public class Arr204 {

	public static void main(String[] args) {
		// 25-07-17-목
		// 배열 생성, 배열 데이터 활용 (p204 예제)
		
		int[] scores;                                   // scores 정수타입 배열 선언
		scores = new int[] {83, 90, 87};                // scores 배열에 데이터 넣기 (그냥 바로 넣으면 x, 오류)
		int sum1 = 0;                                   // sum1 변수 선언 및 초기화(0)
		for(int i=0; i<3; i++) {                        // for문으로 변수sum1에 배열 scores값들 더해주기
			sum1 += scores[i];
		}
		System.out.println("총합 : " + sum1);            // sum1변수 출력 : 
		
		
		
		int sum2 = add(new int[] {83, 90, 87});         // sum2변수에 add()메소드(=함수)에 매개변수로 배열 데이터 넣음 (아래에 add()메소드 있음)
		System.out.println("총합 : " + sum2);            // sum2변수 출력 
		System.out.println();
		
		
		
		
		
		// int 형의 배열 선언, 크기 : 5 ------------------------------------------------------------------------------------
		// 배열에 50~100사이의 수 5개 입력
		// 배열의 합 계산
		int[] num = new int[5];                         // int형의 num 배열 선언 (크기5)		
		int sumNum = 0;                                 // 배열에 들어갈 합 변수 sumNum 선언 및 초기화(0)
		
		for(int i=0; i<num.length; i++) {               // 배열의 길이만큼 for문 돌아가
			num[i] = (int)(Math.random()*51) + 50;      // 배열[0~4]까지 랜덤 수 발생하여 값 넣기
			sumNum += num[i];			                // sumNum에 배열인 랜덤수 더하기
		}
		System.out.println("5개의 랜덤 수 합: " + sumNum);  // sumNum변수 합 출력
		
		// 교수님의 답 
		int[] rans = new int[5];		
		for(int i=0; i<rans.length; i++) {
			rans[i] = (int)(Math.random() * 51) + 50;	
		}
		int result = add(rans);                         // add()메소드를 이용하여 result변수에 합 저장 (매개변수는 변수)
		System.out.println("배열 합 : " + result);
		System.out.println("배열 합 : " + add(rans));
		
		

		
		
		
		
		
		
	}//end main
	
	public static int add(int[] is) {               // add메소드
		int sum = 0;                       
		for(int i=0; i<is.length; i++) {
			sum += is[i];
		}
		return sum;
	}//end add

}//end class
