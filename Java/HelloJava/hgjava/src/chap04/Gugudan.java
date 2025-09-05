package chap04;

public class Gugudan {

	public static void main(String[] args) {
		// p175 구구단
		
        // 단
		for(int dan=2; dan<10; dan++) {
			System.out.println("*** " + dan + "단 ***");
			for(int i=1; i<10; i++) {
				//System.out.println(dan + " × " + i + " = " + (dan*i));
				System.out.printf("%d x %d = %d\n", dan, i, dan*i);
			}
			System.out.println();
		}

		
		// #4-1.과제-4.구구단
		for(int dan=2; dan<10; dan++) {
			System.out.print(dan + "단\t");
			//System.out.printf("%3d단", dan);
		}
		System.out.println();
		for(int i=1; i<=9; i++) {
			for(int dan=2; dan<10; dan++) {
				System.out.printf("%dx%d=%2d\t", dan, i, dan*i);
			}
			System.out.println();
		}
		
		
		// p183 5번(print, for) ---------------------------------------------------------------------------------------
		for(int i=1; i<=4; i++) { //줄수
			for(int star=1; star<=i; star++) {  //별수 (줄 갯수만큼 별이 찍히면 됨)
				System.out.print("*");
			}
			System.out.println();
		}
		
		
		// p183 6번
		for(int i=1; i<=4; i++) {
			for(int j=1; j<=4-i; j++) {
				System.out.print(" ");
			}
			for(int star=1; star<=i; star++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}//end main

}//end class
