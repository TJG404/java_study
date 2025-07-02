package chapter06;

import java.util.Scanner;

/*
 * 음식 주문/결제 프로그램(콘솔)
 * - 음식을 주문(1), 결제(2), 프로그램 종료(9)하는 메뉴로 구성된다.
 * - 프로그램 종료를 제외하고 나머지 메뉴는 반복 선택 가능하다.
 * - 메뉴 선택 시 체크하는 기능은 switch~case를 이용하여 구현한다.
 * 
 * << 추가 사항>>
 * (1) 예외사항 처리 
 * 	   : 메뉴 선택, 결제금액 입력 시 정수형 타입이 아닌 경우 메시지 출력 후 재입력을 유도함
 * (2) 입력값이 정확할 때까지 재입력을 유도하여 진행, flag 변수를 이용하여 반복
 * (3) 결제 금액이 부족한 경우 재입력을 통해 금액을 누적으로 계산하여 저장 후 결제
 */
public class LunchOrderTestVer3 {

	public static void main(String[] args) {		
		Scanner scan = new Scanner(System.in);
		boolean menuFlag = true;
		
		//주문 음식 리스트
		String[] menuList = {"햄버거(🍔)","피자(🍕)","라멘(🍜)","샐러드(🥗)"};
		int[] priceList = {100, 200, 300, 400};
	
		//주문 리스트 선언 및 생성
		String[] orderMenuList = new String[3]; 
		int[] orderPriceList = new int[3];
		int count = 0;		
		
		while(menuFlag) {
			System.out.println("******************************************");
			System.out.println("\t Welcome to Food Mart!!!");
			System.out.println("******************************************");
			System.out.println("\t 1. 음식 주문");		
			System.out.println("\t 2. 주문 리스트 출력");		
			System.out.println("\t 3. 음식 결제");		
			System.out.println("\t 9. 프로그램 종료");		
			System.out.println("******************************************");
			System.out.println("***** Food Mart에 오신것을 환영합니다");
			System.out.print("메뉴> ");
			int menu = scan.nextInt();
			
			switch(menu) {
				case 1:
//					System.out.println("=> 주문!!");
					//1. 메뉴 주문
					boolean orderFlag = true;
					while(orderFlag) {
						System.out.println("******************************************");
						System.out.println("\t 1. 햄버거(🍔):100\t 2. 피자(🍕):200");		
						System.out.println("\t 3. 라멘(🍜):300\t 4. 샐러드(🥗):400");		
						System.out.println("******************************************");
						System.out.print("주문 메뉴(숫자로)> ");
						if(scan.hasNextInt()) {
							int menuNo = scan.nextInt();
				
							switch(menuNo) { //주문 메뉴 선택
								case 1: 
									orderMenuList[count] = menuList[menuNo-1];
									orderPriceList[count] = priceList[menuNo-1];
									break;
								case 2: 
									orderMenuList[count] = menuList[menuNo-1];
									orderPriceList[count] = priceList[menuNo-1];
									break;
								case 3:	
									orderMenuList[count] = menuList[menuNo-1];
									orderPriceList[count] = priceList[menuNo-1];	
									break;
								case 4:	
									orderMenuList[count] = menuList[menuNo-1];
									orderPriceList[count] = priceList[menuNo-1];	
									break;
								default: 
									System.out.println("=> 메뉴 준비중 입니다.");
							}//switch	
							
							count++;
							
							System.out.print("계속 주문?(계속:아무키나, 종료:n)");
							if(scan.next().equals("n")) {
								orderFlag = false;
							}
				
						} else {
							System.out.println("=> 올바르지 않은 입력값입니다. 다시 입력해주세요");
							scan.next();
						}//if
					}//while - menuNo				
					break;
					
				case 2:
					if(count != 0) {
						System.out.println("-----------------------------------------");
						System.out.println("번호\t메뉴명\t가격");
						System.out.println("-----------------------------------------");
						for(int i=0;i<count;i++) {
							System.out.print((i+1) + "\t");
							System.out.print(orderMenuList[i]+"\t");
							System.out.print(orderPriceList[i]+"\n");
						}
						System.out.println("-----------------------------------------");
					} else {
						System.out.println("=> 주문 내역 없음!!");
					}
					break;
				case 9:
					System.out.println("-- 프로그램 종료 --");
					System.exit(0);
					break;
				default:
					System.out.println("=> 메뉴 준비중!!");
			}
			
		}//while-menuFlag

	}//main

}//class








