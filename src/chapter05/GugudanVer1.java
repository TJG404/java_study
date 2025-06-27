package chapter05;

import java.util.Scanner;

public class GugudanVer1 {

	public static void main(String[] args) {
		// 출력하는 구구단을 콘솔로 입력받아 실행
		Scanner scan = new Scanner(System.in);
		int dan = 0;
		
		System.out.print("dan> ");
		dan = scan.nextInt();
		
		System.out.println(dan + "단");
		System.out.println("-------------");
		for(int i=1; i<=9 ; i++) {
			System.out.println(dan + " * " + i +" = " + (i*dan));
		}

	}

}








