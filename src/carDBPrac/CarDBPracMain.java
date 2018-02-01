package carDBPrac;

import java.util.ArrayList;
import java.util.Scanner;

public class CarDBPracMain {

	public static void main(String[] args)throws Exception {
		int count=0;
		//메뉴의 번호를 입력받아 지정한 번호 이외 다른번호를 입력하면 잘못 입력하셨습니다 출력후 다시 입력받게 함 
		Scanner sc = new Scanner(System.in);
		CarInfoDAO dao = new CarInfoDAO();
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
			ArrayList<CarInfo> list = dao.getCarInfoList();
			
			//조회한 데이터 뿌리기
			System.out.println("번호	이름	메이커 	가격");
			for (int i = 0; i < list.size(); i++) {
				CarInfo ci = list.get(i);
				
				System.out.print(ci.getCiNum()+"	");
				System.out.print(ci.getCiName()+"	");
				System.out.print(ci.getCiMaker()+"	");
				System.out.println(ci.getCiPrice()+"	");
				
				
			}
			//자동차 상세 정보 보기 상세보기할 정보가 없으면 잘못입력하셨습니다
			while(true) {
				System.out.println("상세보기할 번호를 입력하세요 0번은 종료입니다~~");
				int selectNum=sc.nextInt();							
				for (int i = 0; i < list.size(); i++) {
					//사용자가 선택한 번호와 list cinum 과 일치할때
					if(selectNum==list.get(i).getCiNum()) {
						//해당번호의 자동차 상세정보보기
						System.out.println("잘입력했네요");
						System.out.println("입력한 번호 : "+selectNum);
						//상세정보를 보여준다 .
							CarDetail cd = dao.getCarDetailInfo(selectNum);
							System.out.println("번호	이름	메이커	가격	컬러	너비	높이");
							System.out.println(cd.toString());
							
						count=list.get(i).getCiNum(); // 잘못된 번호 이면 count에 값이 저장되지않는다 . 
						break;
					}
				} 
				if(selectNum==0) {
					System.out.println("종료하셨습니다 .");
					break; //while 문 빠져나간다. 상세정보 보기 문 
				}else if(selectNum!=count) { // 잘못된 번호 이면 count에 값이 저장되지않는다 . 
					System.out.println(selectNum+"은 잘못입력된 숫자");
				}
				
				
			}
			
			
			
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
