package vending_machine_ver1;

import commons.Menu;

public class VendingMachine {
	String[] nameList = {"☕ 밀크커피","☕ 아메리카노","🍋 유자차","🥛 초코우유"};
	int[] priceList = {300, 400, 300, 200};
	Menu[] menuList;
	Menu[] orderMenuList; 	//user가 주문가능한 메뉴 
	int orderMenuCount = 0;

	String title;
	User user;
	int totalCoin;
	
	
	public VendingMachine(User user) {
		this("막심", user);
	}
	public VendingMachine(String title, User user) {
		this.title = title;
		this.user = user;
		createMenuList();
		showMenuList();
		checkInsertCoin();
	}
	
	/*
	 * 메뉴 체크
	 */
	public boolean menuCheck(int menuNo) {
		boolean result = false;		
		for(int i=0; i<orderMenuCount; i++) {
			Menu menu = orderMenuList[i];
			if(menu.getNo() == menuNo) result = true;
		}		
		return result;
	}
	
	/*
	 * 메뉴 선택
	 */
	public void selectMenu() {  //정확한 메뉴 선택!!!
		System.out.println("=> 메뉴를 선택해 주세요.");
		int menuNo = user.selectMenu();
		if(menuCheck(menuNo)) {
			placeOrder(menuNo);
		} else {
			selectMenu();
		}
	}
	
	/*
	 * 주문
	 */
	public void placeOrder(int menuNo) {
		
	}
	
	/*
	 * 결제
	 */
	public void processPayment() {
		
	}
	
	/*
	 * 종료
	 */
	public void finalCheck() {
		//잔돈이 최소 주문금액보다 크면 계속 주문
	}
		
	
	/*
	 * 입력되는 동전 체크 
	 */
	public void checkInsertCoin() {
		System.out.println("=> 동전을 투입해 주세요.");
		int coin = user.insertCoin();		
		if(coin == 100 || coin == 500) { //사용가능 동전 체크
			totalCoin += coin;
			System.out.println("총 투입금액 : " + totalCoin);
			
			if(totalCoin < 200) {	//메뉴 선택 최소 금액 체크
				System.out.println("=> 최소 금액 부족!!");
				checkInsertCoin();
			} else {
				//메뉴 선택 여부 체크
				System.out.print("=> 메뉴선택(n), 동전투입계속(아무키)> ");
				if(user.scan.next().equals("n")) {
					createOrderMenuList(totalCoin);		
					showMenuList("주문 가능 메뉴 리스트");
					selectMenu();					
				}
				else	checkInsertCoin();
			}
		} else {
			System.out.println("=> 동전은 100원, 500원만 사용 가능합니다. 동전 반환!!");
			checkInsertCoin();
		}		
	}
	
	/*
	 * 주문가능한 메뉴 리스트 생성
	 */
	public void createOrderMenuList(int totalCoin) {
		orderMenuList = new Menu[menuList.length];
		
		//orderMenuCount 변수를 이용하여 향상된 for문 사용
		for(Menu menu : menuList) {
			if(menu.getPrice() <= totalCoin) {
				orderMenuList[orderMenuCount] = menu;
				orderMenuCount++;
			}
		}		
		
		/*
		for(int i=0; i<menuList.length; i++) {
			Menu menu = menuList[i];				
			if(menu.getPrice() <= totalCoin) {
				orderMenuList[i] = menu;
			}
		}
		*/
	}
	
	
	/*
	 * 총 투입금액에 맞춘 메뉴 출력
	 */
	public void showMenuList(String msg) {		
		System.out.println("--------------------------------------------------");
		System.out.println("  ☕🍵🥤 "+ title + " Coffee Machine");
		System.out.println("--------------------------------------------------");	
		System.out.println("\t" + msg);
		System.out.println("--------------------------------------------------");	
		for(int i=0; i<orderMenuCount; i++) {
			Menu menu = orderMenuList[i];
			System.out.print(menu.getNo() +".\t");
			System.out.print(menu.getName() +"\t\t");
			System.out.print(String.format("%,d", menu.getPrice()) +"원\n");		
		}
		System.out.println("--------------------------------------------------");	
	}
	
	/*
	 * 전체 메뉴 출력
	 */
	public void showMenuList() {		
		System.out.println("--------------------------------------------------");
		System.out.println("  ☕🍵🥤 "+ title + " Coffee Machine");
		System.out.println("--------------------------------------------------");		
		for(Menu menu : menuList) {
			System.out.print(menu.getNo() +".\t");
			System.out.print(menu.getName() +"\t\t");
			System.out.print(String.format("%,d", menu.getPrice()) +"원\n");			
		}
		System.out.println("--------------------------------------------------");	
	}
	
	/*
	 * 메뉴 리스트 생성
	 */
	public void createMenuList() {
		menuList = new Menu[nameList.length];
		for(int i=0; i<nameList.length; i++) {
			int no = i + 1;
			String name = nameList[i];
			int price = priceList[i];
			
			Menu menu = new Menu(no, name, price);
			menuList[i] = menu;
		}		
	}

}//class - VendingMachine











