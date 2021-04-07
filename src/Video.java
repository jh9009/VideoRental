import VideoType.CD;
import VideoType.DVD;
import VideoType.VHS;
import VideoType.VideoType;
import PriceCode.PriceCode;
import PriceCode.Regular;
import PriceCode.NewRelease;

import java.util.Date;

public class Video {
	private String title ;

	private int priceCode ;
	public static final int REGULAR = 1 ;
	public static final int NEW_RELEASE =2 ;

	private VideoType type;
	private PriceCode code;
	public static final int VHS = 1 ;
	public static final int CD = 2 ;
	public static final int DVD = 3 ;

	private Date registeredDate ;
	private boolean rented ;

	public Video(String title, int videoType, int priceCode, Date registeredDate) {
		this.setTitle(title) ;
		this.setVideoType(videoType) ;
		this.setPriceCode(priceCode) ;
		this.registeredDate = registeredDate ;
	}

	public int getLateReturnPointPenalty() {
		return type.getLateReturnPointPenalty();
	}

	public int getPriceCode() {
		return priceCode;
	}

	public double getPriceCode(int daysRented) {
		return code.getPriceCode(daysRented);
	}

	public void setPriceCode(int priceCode) {
		this.priceCode = priceCode;
		switch(priceCode) {
			case REGULAR: code = new Regular(); break;
			case NEW_RELEASE: code = new NewRelease(); break;
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isRented() {
		return rented;
	}

	public void setRented(boolean rented) {
		this.rented = rented;
	}

	public Date getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}

	public void setVideoType(int videoType) {
		switch(videoType) {
			case VHS:	type = new VHS();	break;
			case CD:	type = new CD();	break;
			case DVD:	type = new DVD();	break;
		}
	}

	public int getDaysRentedLimit() {
		return type.getDaysRentedLimit();
	}
}
