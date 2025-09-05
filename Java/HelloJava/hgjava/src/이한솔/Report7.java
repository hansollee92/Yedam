package 이한솔;

public class Report7 {

	public static void main(String[] args) {
		// 3,6,9 게임 프로그램
		
		// 1~50까지 3,6,9가 들어가는 숫자마다 
		// 3,6,9가 들어가는 개수 만큼 ♥를 출력하는 프로그램
		
		// 실행결과
		// 1   2   ♥   4    5    ♥   7    8    ♥    10
		// 11  12  ♥   14   15   ♥   17   18   ♥    20
		// ..... 
		
		int num = 0;
		for(int i=1; i<=5; i++) { //줄수
			for(int j=1; j<=10; j++) {  //숫자
				num++;			
				
				int num1 = num % 10;  //1의 자리
				int num10 = num / 10; //10의 자리
				
				int cnt = 0;
				
				if(num1 == 3 || num1 == 6 || num1 ==9) {
					cnt++;
				}
				if(num10 == 3 || num10 == 6 || num10 == 9) {
					cnt++;
				}
				
				if(cnt > 0) {
					for(int k=1; k<=cnt; k++){
						System.out.print("♥");
					}
					System.out.print("\t");
				}else {
					System.out.printf("%d\t", num);
				}				
				
//				if(cnt == 0) {
//					System.out.printf("%d\t", num);
//				}else if(cnt == 1) {
//					System.out.print("♥\t");
//				}else {
//					System.out.print("♥♥\t");
//				}
			}
			System.out.println();
		}	
		
		// for문 하나씩만 나오게끔 할려면 if 10으로 나눴을때 줄바꿈이 일어나게끔 조건을 걸어주면 된다

	}//end main

}//end class
