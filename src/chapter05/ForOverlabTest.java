package chapter05;

import java.util.Scanner;

public class ForOverlabTest {


	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int start=0, end =0;
		
		System.out.print("start> ");
		start = scan.nextInt();
		
		System.out.print("end> ");
		end = scan.nextInt();
		
		for(int i=1; i<=9; i++) {
			for(int j=start ; j<=end ; j++) {
				System.out.print(j + "*" + i + "=" + (i*j) + "\t");
			}
			System.out.println();
		}

	}

}
