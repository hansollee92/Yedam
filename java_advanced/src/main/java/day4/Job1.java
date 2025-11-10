package day4;

// ① Thread로 사용할려면 상속받아야함
public class Job1 extends Thread {

	// Thread의 run()메소드를 override함
	@Override
	public void run() {
		for(int i=1; i<=10; i++) {
			System.out.println(i);
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	
	
}
