package day2;

public class Calcurator {
	// 필드
	int n1;
	int n2;
	int result;

	// 생성자
	// 기본생성자
	public Calcurator() {
	}

	// n1, n2 초기화 생성자
	public Calcurator(int n1, int n2) {
		this.n1 = n1;
		this.n2 = n2;
	}

	// 더하기
	void add() {
		result = n1 + n2;
	}

	// 곱하기
	void mul() {
		result = n1 * n2;
	}

}
