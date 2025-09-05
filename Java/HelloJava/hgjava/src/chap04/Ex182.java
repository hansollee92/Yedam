package chap04;

import java.util.Scanner;

public class Ex182 {

	public static void main(String[] args) {
		// p182 문제2번
		// 1에서 100까지 정수 중 3의 배수 합, 3의 배수의 갯수
//		int sum = 0;
//		int cnt = 0;
//		for(int i=1; i<=100; i++) {
//			if(i % 3 == 0) {
//				sum += i;
//				cnt++;
//			}
//		}
//		System.out.printf("합 : %d\n배수의 개수: %d\n------------\n", sum, cnt);
		
		// 누적변수의 개념 느껴질수 있도록 손코딩하면서 공부하기!
		
		
		// 25-07-16-수요일 ------------------------------------------------------------------------------------------
		// p183 문제3번
		// while문, Math.random() 메소드	
		// 추가+) 몇번만에 탈출했는지도 출력
//		int escapeCnt = 0;
//		while(true) {
//			int dice1 = (int)(Math.random()*6) + 1;
//			int dice2 = (int)(Math.random()*6) + 1;
//			escapeCnt++;
//			System.out.printf("(%d, %d)\n", dice1, dice2);
//			if(dice1 + dice2 == 5) {
//				break;
//			}
//		}
//		System.out.printf("%d번만에 탈출했어요!\n", escapeCnt);
		
		
		// p183 문제4
//		for(int x=1; x<=10; x++) {
//			for(int y=1; y<=10; y++) {
//				int result = 4*x + 5*y;
//				if(result == 60) {
//					System.out.printf("(%d, %d)\n", x, y);
//				}
//			}
//		}
		
		// p183 문제6
		// for문을 이용한 blank+* 출력
//		for(int i=1; i<=4; i++) { //줄수
//			for(int b=1; b<=(4-i); b++) { //빈칸
//				System.out.print(" ");				
//			}
//			for(int s=1; s<=i; s++) {   //별
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
		
		/*
		   i/j   4     3     2     1        
		    1                      *
		    2                *     *
		    3          *     *     *
		    4    *     *     *     *
		    
		    i=1, j=*(1)
		    i=2, j=**(2)
		    i=3, j=***(3)
		    i=4, j=****(4)	
		    
		    아래와 같은 형태로 나타나게 만들어라
		    if(i_j){
		       sysou ""
		    }else{
		       sysou ""
		    }		    		 
		 */
		
		//(!!) i와 j의 관계를 이용해서 별찍기 (for문을 사용하는 것보다 간단하게 표현가능)
//		for(int i=1; i<=4; i++) {
//			for(int j=4; j>=1; j--) {
//				if(i<j) {      // i가 j보다 크면 빈칸
//					System.out.print(" ");
//				}else {
//					System.out.print("*");
//				}	
//			}
//			System.out.println();
//		}
//		
		// (!!) 별모양찍기, 모래시계, 다이아몬드 별찍기 알고리즘 공부해보기 	
	
	
		
		
		
		
		
	}//end main

}//end class
