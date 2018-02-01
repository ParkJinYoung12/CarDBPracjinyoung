package carDBPrac;

public class CarDetail {
	private int ciNum;
	private String ciName;
	private String ciMaker;
	private int ciPrice;
	private String ciColor;
	private int ciWidth;
	private int ciHight;
	protected int getCiNum() {
		return ciNum;
	}
	protected void setCiNum(int ciNum) {
		this.ciNum = ciNum;
	}
	protected String getCiName() {
		return ciName;
	}
	protected void setCiName(String ciName) {
		this.ciName = ciName;
	}
	protected String getCiMaker() {
		return ciMaker;
	}
	protected void setCiMaker(String ciMaker) {
		this.ciMaker = ciMaker;
	}
	protected int getCiPrice() {
		return ciPrice;
	}
	protected void setCiPrice(int ciPrice) {
		this.ciPrice = ciPrice;
	}
	protected String getCiColor() {
		return ciColor;
	}
	protected void setCiColor(String ciColor) {
		this.ciColor = ciColor;
	}
	protected int getCiWidth() {
		return ciWidth;
	}
	protected void setCiWidth(int ciWidth) {
		this.ciWidth = ciWidth;
	}
	protected int getCiHight() {
		return ciHight;
	}
	protected void setCiHight(int ciHight) {
		this.ciHight = ciHight;
	}
	public String toString() {
		return ciNum+"	"+ciName+'	'+ciMaker+'	'+ciPrice+'	'+ciColor+'	'+ciWidth+'	'+ciHight;
		
	}
}
