package day4;

public class ThreadTest {
	public static void main(String[] args) throws InterruptedException {
	
		// ② 멀티스레드 - 1) extends 상속
		Job1 job1 = new Job1();
		job1.start();
		
		// ③ 멀티스레드 - 2) implements Runnable 인터페이스
		Thread thread = new Thread(new Job2());
		thread.start();
		
		// 람다표현식으로 바꿔보기
		Runnable run = () -> {
			for(int i=200; i<=210; i++) {
				System.out.println(i);
				try {
					Thread.sleep(400);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		Thread thread2 = new Thread(run);		
		thread2.start();

		
	}
}
