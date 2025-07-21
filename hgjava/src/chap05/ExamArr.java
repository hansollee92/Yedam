package chap05;

public class ExamArr {

	public static void main(String[] args) {
		// 배열에 저장된 값들의 합, 최대값, 최소값 구하기
		
		// 배열값 : 1에서 100까지의 난수 10개 배열에 저장
		// 배열 값 출력
		// 배열 값의 합계, 최대값, 최소값
		
		int[] numArr = new int[10];                             // numArr 배열(크기10) 선언 및 힙영역 int타입으로 10개 방 잡아!
		int sum = 0;                                            
		int min = 100;                                          // 최소값을 100으로 두고 비교하기 (배열의 첫번째 값으로 넣어도 됨)
		int max = 0;                                            // 최대값을 0으로 두고 비교하기   (배열의 첫번째 값으로 넣어도 됨)
		for(int i=0; i<numArr.length; i++) {                    // numArr 배열에 이 배열의크기만큼(10) 랜덤수,최소값,최대값을 위한 for문
			numArr[i] = (int)(Math.random()*100) + 1;           // numArr 배열에 랜덤수 발생
			sum += numArr[i];                                   // sum 변수에 numArr 배열 값 합치기
			
			if(min > numArr[i]) {                               // numArr 값과 비교하여 min의 값이 클경우 작은값(numArr)을 min에 저장
				min = numArr[i]; 
			}
			if(max < numArr[i]) {                               // numArr 값과 비교하여 max의 값이 작을 경우 큰값(numArr)을 max에 저장
				max = numArr[i];
			}
		}
		System.out.printf("합 : %d\n최소값 : %d\n최대값 : %d\n", sum, min, max);		
		
		
		
		
		// (추가문제) 배열의 요소 중 4의 배수 출력
		// 4의 배수 갯수 출력
		System.out.println("---------------------------------------------------------");
		int cnt = 0;
		for(int i=0; i<numArr.length; i++) {
			if(numArr[i] % 4 == 0) {
				System.out.print(numArr[i] + " ");
				cnt++;
			}
		}
		System.out.print("\n4의 배수 갯수 :" + cnt + "\n");	
		
		
		
		
		
		// 2차원 배열 --------------------------------------------------------------------------------------------------
		// 배열 선언 
		System.out.println("---------------------------------------------------------");
		int[][] twoArr = {
				{80,90},          // 행 0
				{70,60,50}        // 행 1
		}; // 일렬로 적는 것보다 위와 같이 띄어서 쓰면 좀 더 파악하기 쉽다
		
		// 2차원 배열 출력
		for(int i=0; i<twoArr.length; i++) {                  //행
			for(int j=0; j<twoArr[i].length; j++) {           //열 
				System.out.printf("| %d |", twoArr[i][j]);
			}
			System.out.println();
		}
		
		
		
		// 과제 2번 
		// 배열 = {{1,2,3}, {1,2}, {1}, {1,2,3}}	
		System.out.println("---------------------------------------------------------");
		int[][] report2 = {
				{1,2,3},
				{1,2},
				{1},
				{1,2,3}
		};
		for(int i=0; i<report2.length; i++) {
			for(int j=0; j<report2[i].length; j++) {
				System.out.printf("| %d |", report2[i][j]);
			}
			System.out.println();
		}
		
		
		
		
		// 과제 3번 
		// 현재 관객의 수 출력 
		
		// 관객이 있는 좌석은 1, 없는 좌석은 0 : 난수 이용
		// 극장의 자리는 1줄에 10좌석씩 3줄 (3행 10열)
		// 3행 10열의 배열에 0또는 1 저장 -> 값 출력
		// 관객수 계산하기 -> 현재 관객수는 00명		
		
		//3행 10열 배열 생성
		// 안에 난수 0-1까지의 난수 넣기
		// 배열의 합 = 관객수
		
		System.out.println("---------------------------------------------------------");
		int[][] person = new int[3][10];         //3행 10열의 2차원 배열 생성
		int pplSum = 0;
		for(int i=0; i<person.length; i++) {
			
			for(int j=0; j<person[i].length; j++) {
				
				person[i][j] = (int)(Math.random()*2);   //person배열에 0-1 난수 발생
				pplSum += person[i][j];
				System.out.printf("| %d |", person[i][j]);
			}
			System.out.println();
		}
		System.out.println("관객수 : " + pplSum);
				
				
		
		
		// 문제4번 
		// 학생별 평균 계산하기 
		
		// 학생3명(행), 한 학생당 다섯개의 점수 
		// 점수 무작위~ (50<= 점수 <=100)
		// 학생별 평균 계산 출력
		// 점수는 소수점 2자리로 나타나게 
		System.out.println("---------------------------------------------------------");
		int[][] student = new int[3][5];
		int sum1 = 0;
		int sum2 = 0;
		int sum3 = 0;
		for(int i=0; i<student.length; i++) {
			for(int j=0; j<student[i].length; j++) {
				student[i][j] = (int)(Math.random()*51)+50;
				System.out.printf("%-3d ", student[i][j]);
				if(i == 0) {
					sum1 += student[i][j];
				}else if(i == 1) {
					sum2 += student[i][j];
				}else {
					sum3 += student[i][j];
				}
			}
			System.out.println();
		}
		
		// (★★) 행번호의 랜스 로 나눠야하고
		System.out.printf("1번 학생 평균 = %.2f\n", (double) sum1 / student[0].length);
		System.out.printf("2번 학생 평균 = %.2f\n", (double) sum2 / student[1].length);
		System.out.printf("3번 학생 평균 = %.2f\n", (double) sum3 / student[2].length);

		
		// (★★) 계산출력하는 for문 으로 돌려야함
//		for(int i=0; i<student.length; i++) {
//			for(int j=0; j<student[i].length; j++) {
//				if(i == 0) {
//					sum1 += student[i][j];
//				}else if(i == 1) {
//					sum2 += student[i][j];
//				}else {
//					sum3 += student[i][j];
//				}
//			}
//		}
		
		
		
		
		// 과제 문제5
		// 배열 2개 , 4개 / 13개
		// 무작위로 0123 / 0-12 수가 나와야함 
		// 그래서 랜덤하게 선택하는 코드 
		System.out.println("---------------------------------------------------------");
		String[] card = {"Clubs", "Diamonds", "Hearts", "Spades"};
		String[] cardNum = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
		
		for(int i=0; i<5; i++) {
			int cardRan = (int)(Math.random()*4);
			int cardnumRan = (int)(Math.random()*13);
			System.out.printf("%s의 %s\n", card[cardRan], cardNum[cardnumRan]);
		}
				
		
		
		
		
		// 과제 문제6
		// 3행 5열 크기 2차원 배열 생성
		// 5개의 정수 1을 랜덤한게 배치 		
		// 행렬값을 랜덤으로 받아서 > 중복발생할 수 있으니  
		
		System.out.println("---------------------------------------------------------");
		int[][] ranNum = new int[3][5];
		
		for(int i=0; i<5; i++) {
			int room1 = (int)(Math.random()*3);
			int room2 = (int)(Math.random()*5);
			if(ranNum[room1][room2] == 1) {
				//흠...
			}else {				
				ranNum[room1][room2] = 1;
			}
		}
		for(int i=0; i<ranNum.length; i++) {
			for(int j=0; j<ranNum[i].length; j++) {
				System.out.printf("%d ", ranNum[i][j]);
			}
			System.out.println();
		}
		
		// 중복 어떻게....??? 
		
		

	}//end main

}//end class
