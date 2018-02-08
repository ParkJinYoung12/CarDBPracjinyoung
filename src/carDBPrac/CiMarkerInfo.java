package carDBPrac;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.DriverManager;

public class CiMarkerInfo {
	private static final String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String ORACLE_USER_ID = "system";
	private static final String ORACLE_USER_PW = "1234";
	//접속 및 커리 처리에 필요한 객체들
	private Connection conn =null;
	private PreparedStatement pstmt =null;
	private ResultSet rs = null;
	private int Mnum;
	private String MnameKor;
	private String MnameEng;
	protected int getMnum() {
		return Mnum;
	}
	protected void setMnum(int mnum) {
		Mnum = mnum;
	}
	protected String getMnameKor() {
		return MnameKor;
	}
	protected void setMnameKor(String mnameKor) {
		MnameKor = mnameKor;
	}
	protected String getMnameEng() {
		return MnameEng;
	}
	protected void setMnameEng(String mnameEng) {
		MnameEng = mnameEng;
	}
	
	
}
