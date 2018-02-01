package carDBPrac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class CarInfoDAO {
	// 오라클 DBMS 접속에 필요한 정보들
	
	
	private static final String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String ORACLE_USER_ID = "system";
	private static final String ORACLE_USER_PW = "1234";
	//접속 및 커리 처리에 필요한 객체들
	private Connection conn =null;
	private PreparedStatement pstmt =null;
	private ResultSet rs = null;
	
	//모든자동차 정보를 조회한다.
	public ArrayList<CarInfo> getCarInfoList() throws Exception{
		ArrayList<CarInfo> list = new ArrayList<>();
		
		try {
			//dbms 접속정보 읽어오기
			conn=DriverManager.getConnection(ORACLE_URL,ORACLE_USER_ID,ORACLE_USER_PW);
			//1.sql문을 String으로 준비
			String sql = " select * from carInfo"; //리터럴에 ; 이게(세미콜론) 들어가면 안된다 
			//2.쿼리 실행 준비
			pstmt = conn.prepareStatement(sql);
			//3.실행 결과를 ResultSet 객체에 담는다.
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				
				CarInfo cInfo=new CarInfo();
				cInfo.setCiNum(rs.getInt(1));
				cInfo.setCiName(rs.getString(2));
				cInfo.setCiMaker(rs.getString(3));
				cInfo.setCiPrice(rs.getInt(4));	
				cInfo.setCiColor(rs.getString(5));
				cInfo.setCiWidth(rs.getInt(6));
				cInfo.setCiHight(rs.getInt(7));
				list.add(cInfo);
				
			}
			
		} catch (Exception e) {
			
		}finally {
			conn.close();
			pstmt.close();
			rs.close();
		}
		
		return list;
	}
	
	
	
	
}//class end ~!
