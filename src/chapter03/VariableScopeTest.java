package chapter03;

/*
 * 변수의 범위 설정 : Global(전역), Local(지역, 로컬)
 */
public class VariableScopeTest {
	
	//전역 변수
	static int gnumber = 10;
	
	//전역 상수 : START, END
	static final int START = 1;
	static final int END = 0;
	
	public static void main(String[] args) {
		//main method 지역 변수
		int number = 100;
		
		System.out.println("전역변수 : " + gnumber);
		System.out.println("전역상수 : " + START);
		System.out.println("전역상수 : " + END);
		System.out.println("지역변수 : " + number);
	}
}










