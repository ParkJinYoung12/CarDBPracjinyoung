package carDBPrac;

import java.util.Scanner;

public class CarDBPracMain {

	public static void main(String[] args) {
		//메뉴의 번호를 입력받아 지정한 번호 이외 다른번호를 입력하면 잘못 입력하셨습니다 출력후 다시 입력받게 함 
		Scanner sc = new Scanner(System.in);
		
		while(true) {	
		System.out.println("===========================");
		System.out.println("번호를 입력하세요");
		System.out.println("1.자동차 정보 보기");
		System.out.println("2.자동차 정보 입력");
		System.out.println("3.자동차 정보 수정");
		System.out.println("4.자동차 정보 삭제");
		System.out.println("===========================");
		int inputNum= sc.nextInt();
		if(inputNum==1) { //자동차 정보 조회
			
			break;
		}
		else if(inputNum==2) { //자동차 정보 입력
			
			break;
		}
		else if(inputNum==3) { //자동차 정보 수정 
			
			break;
		}
		else if(inputNum==4) { // 자동차 정보 삭제 
			
			break;
		}else {				//다른거 입력했을때 다시입력 
			System.out.println("다시입력해주세요");
		}
		}//end while
		System.out.println("종료");
		
		sc.close();
		
		
	} //end main method

} //end CarDBPracMain class
