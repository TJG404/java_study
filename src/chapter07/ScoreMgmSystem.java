package chapter07;

import java.util.Scanner;

/*
 * - 학생 3명의 점수를 입력 받는다. 
 * - 한 명 입력 후 계속 입력 여부를 메시지로 출력 후 입력 받는다.
 */
public class ScoreMgmSystem {
	//Field
	String admin;
	Student student;
	Scanner scan = new Scanner(System.in);
	Student[] sList = new Student[10];
	int count = 0;
	
	//Constructor
	
	//Method
	/*
	 * 메뉴 선택
	 */
	public void showMenu() {
		System.out.println("-----------------------------------------");
		System.out.println("더조은 고등학교 성적관리 프로그램");		
		System.out.println("-----------------------------------------");
		System.out.println("1. 학생 등록");		
		System.out.println("2. 학생 리스트 출력");		
		System.out.println("3. 학생 성적 검색");		
		System.out.println("4. 학생 성적 수정");		
		System.out.println("5. 학생 삭제");		
		System.out.println("9. 프로그램 종료");		
		System.out.println("-----------------------------------------");
		
		System.out.print("메뉴선택(숫자)> ");
//		int menu = scan.nextInt();		
//		choiceMenu(menu);
		
		menuCheck(scan.nextInt());
	}
	
	/*
	 * 선택한 메뉴를 체크하여 기능별 메소드 호출
	 */
	public void menuCheck(int menu) {
		switch(menu) {
			case 1: 
				insert();
				showMenu();
				break;
			case 2: 
				showList();	
				showMenu();
				break;
			case 3: 
				search();	
				break;
			case 4: 
				update();	
				break;
			case 5: 
				remove();	
				break;
			case 9: 
				System.out.println("-- 성적관리 시스템 종료 --");
				System.exit(0);
				break;	
			default:
				System.out.println("=> 메뉴 준비 중~");
				showMenu();
		}		
	}
	
	public void insert() {
		System.out.println("=> 학생 정보 등록하세요");
		sList[count] = new Student();
		
		System.out.print("학생명> ");
		sList[count].name = scan.next();
		
		System.out.print("국어> ");
		sList[count].kor = scan.nextInt();
		
		System.out.print("영어> ");
		sList[count].eng = scan.nextInt();
		
		System.out.print("수학> ");
		sList[count].math = scan.nextInt();
		
		count++;
		System.out.println("=> 등록 완료!!");		
		
		System.out.print("계속 등록(아무키나), 종료(n)?> ");	
		if(scan.next().equals("n")) {
			showMenu();
		} else {
			insert();
		}
	}
	
	
	public void showList() {
		if(count != 0) {
			System.out.println("------------------------------------------");
			System.out.print("학생명\t국어\t영어\t수학\t총점\t평균\n ");
			System.out.println("------------------------------------------");	
			int i = 0;
			for(Student student : sList) {
				if(i < count) {
					System.out.print(student.name +"\t");
					System.out.print(student.kor +"\t");
					System.out.print(student.eng +"\t");
					System.out.print(student.math +"\t");
					System.out.print(student.getTot() +"\t");
					System.out.print(student.getAvg() +"\n");	
				}
				i++;
			}
			System.out.println("------------------------------------------");
		} else {
			System.out.println("=> 등록된 데이터 없음, 등록부터 진행해 주세요");
		}
	}
	
	
	public void update() {
		System.out.println("update");
	}
	
	public void remove() {
		System.out.println("remove");
	}
	
	public void search() {
		System.out.println("search");
	}	
	
}//class















