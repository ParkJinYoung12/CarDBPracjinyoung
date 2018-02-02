package carDBPrac;

import java.util.ArrayList;
import java.util.Scanner;

public class CarDBPracMain {

	public static void main(String[] args) throws Exception {
		
		// 메뉴의 번호를 입력받아 지정한 번호 이외 다른번호를 입력하면 잘못 입력하셨습니다 출력후 다시 입력받게 함
		Scanner sc = new Scanner(System.in);//숫자 데이터 받는 스캐너 
		Scanner scStr = new Scanner(System.in); //문자 데이터 받는 스캐너
		CarInfoDAO dao = new CarInfoDAO();
		while (true) {
			int count = 0;
			System.out.println("===========================");
			System.out.println("번호를 입력하세요");
			System.out.println("1.자동차 정보 보기");
			System.out.println("2.자동차 정보 입력");
			System.out.println("3.자동차 정보 수정");
			System.out.println("4.자동차 정보 삭제");
			System.out.println("===========================");
			int inputNum = sc.nextInt();
			if (inputNum == 1) { // 자동차 정보 조회
				ArrayList<CarInfo> list = dao.getCarInfoList();

				// 조회한 데이터 뿌리기
				System.out.println("번호	이름	메이커 	가격");
				for (int i = 0; i < list.size(); i++) {
					CarInfo ci = list.get(i);

					System.out.println(ci.toString() + "	");
					

				}
				// 자동차 상세 정보 보기 상세보기할 정보가 없으면 잘못입력하셨습니다
				while (true) {
					System.out.println("상세보기할 번호를 입력하세요 0번은 종료입니다~~");
					int selectNum = sc.nextInt();
					for (int i = 0; i < list.size(); i++) {
						// 사용자가 선택한 번호와 list cinum 과 일치할때
						if (selectNum == list.get(i).getCiNum()) {
							// 해당번호의 자동차 상세정보보기
							System.out.println("잘입력했네요");
							System.out.println("입력한 번호 : " + selectNum);
							// 상세정보를 보여준다 .
							CarDetail cd = dao.getCarDetailInfo(selectNum);
							System.out.println("번호	이름	메이커	가격	컬러	너비	높이");
							System.out.println(cd.toString());

							count = list.get(i).getCiNum(); // 잘못된 번호 이면 count에 값이 저장되지않는다 .
							break;
						}
					}
					if (selectNum == 0) {
						System.out.println("종료하셨습니다 .");
						break; // while 문 빠져나간다. 상세정보 보기 문
					} else if (selectNum != count) { // 잘못된 번호 이면 count에 값이 저장되지않는다 .
						System.out.println(selectNum + "은 잘못입력된 숫자");
					}

				} // end while

				break;
			} // inputNum 이 1 일때 끝
			else if (inputNum == 2) { // 자동차 정보 입력
				/* 자동차 정보 조회 그대로 구현 */
				ArrayList<CarDetail> list = dao.getCarDetailInfoList();

				// 조회한 데이터 뿌리기
				System.out.println("번호	이름	메이커 	가격");
				for (int i = 0; i < list.size(); i++) {
					CarDetail ci = list.get(i);				
					System.out.println(ci.toString());
				}
				//				
				
				System.out.println("(1:새 data입력)(2:종료)");
				int selectNum = sc.nextInt();
				if(selectNum==1) {
					//새로 사용자가 입력받는 데이터들..
					System.out.println("차명을 입력하세요:");String cName=scStr.nextLine();
					System.out.println("제조사를 입력하세요:");String cMaker=scStr.nextLine();
					System.out.println("가격을 입력하세요:");int cPrice=sc.nextInt();
					System.out.println("색상을 입력하세요:");String cColor=scStr.nextLine();
					System.out.println("너비를 입력하세요:");int cWidth=sc.nextInt();
					System.out.println("높이를 입력하세요:");int cHight=sc.nextInt();
					CarDetail carDetailData = new CarDetail(cName,cMaker,cPrice,cColor,cWidth,cHight);
					//db에 접근해서 사용자가 입력받은 데이터 INSERT 시키기 
					dao.insertCarDetail(carDetailData);
					System.out.println("입력완료");
				}
				break;
			} 
			
			
			
			
			else if (inputNum == 3) { // 자동차 정보 수정
				ArrayList<CarDetail> list = dao.getCarDetailInfoList();

				// 조회한 데이터 뿌리기
				System.out.println("번호	이름	메이커 	가격");
				for (int i = 0; i < list.size(); i++) {
					CarDetail ci = list.get(i);				
					System.out.println(ci.toString());
				}
				System.out.println("(수정할 번호를 선택하시오)(해당 번호가 없으면 종료)");
				int select = sc.nextInt();
				if(isValidNum(select,list)){
				System.out.println(dao.getCarDetailInfo(select));
				System.out.println("차명을 입력하세요:");String cName=scStr.nextLine();
				System.out.println("제조사를 입력하세요:");String cMaker=scStr.nextLine();
				System.out.println("가격을 입력하세요:");int cPrice=sc.nextInt();
				System.out.println("색상을 입력하세요:");String cColor=scStr.nextLine();
				System.out.println("너비를 입력하세요:");int cWidth=sc.nextInt();
				System.out.println("높이를 입력하세요:");int cHight=sc.nextInt();
				CarDetail carDetailData = new CarDetail(cName,cMaker,cPrice,cColor,cWidth,cHight);
				//db에 접근해서 사용자가 입력받은 데이터 INSERT 시키기 
				dao.updateCarDetail(carDetailData,select); //인서트가 아니라 업데이트 
				System.out.println("수정완료");
			}else {
				System.out.println("해당번호 없음 , 종료");
			}
				break;
				
				
				
				
			} else if (inputNum == 4) { // 자동차 정보 삭제
				ArrayList<CarDetail> list = dao.getCarDetailInfoList();

				// 조회한 데이터 뿌리기
				System.out.println("번호	이름	메이커 	가격");
				for (int i = 0; i < list.size(); i++) {
					CarDetail ci  = list.get(i);				
					System.out.println(ci.toString());
				}
				System.out.println("선택번호:해당 내용삭제 0:종료");
				int select = sc.nextInt();
				if(isValidNum(select,list)){			
				//db에 접근해서 사용자가 입력받은 데이터 INSERT 시키기 				
				dao.deleteCarDetail(select); //인서트가 아니라 업데이트 
				System.out.println("삭제완료");
				
				
				break;
			} //4번일때 끝
			else { // 다른거 입력했을때 다시입력
				System.out.println("다시입력해주세요");
			} 
		} // end while
		System.out.println("종료");

		sc.close();}
		

	} // end main method
    //db 에 접근해서 사용자가 입력한 번호가 일치하는지 검사
	private static boolean isValidNum(int selectNum,ArrayList<CarDetail> list) {
		/*boolean isValid =false; 쓸필요없다~~~~~*/ 
//		list = new ArrayList<CarDetail>();
		for (int i = 0; i <list.size(); i++) {
			if(selectNum==list.get(i).getCiNum()) {
				
				return true;
			}
		}
		return false;
	}
	
} //end CarDBPracMain class
