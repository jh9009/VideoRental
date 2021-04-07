import java.util.Date;

public class Rental {
	private Video video ;
	private int status ; // 0 for Rented, 1 for Returned
	private Date rentDate ;
	private Date returnDate ;

	public Rental(Video video) {
		this.video = video ;
		status = 0 ;
		rentDate = new Date() ;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public int getStatus() {
		return status;
	}

	public void returnVideo() {
		if ( status == 1 ) {
			this.status = 1;
			returnDate = new Date() ;
		}
	}
	public Date getRentDate() {
		return rentDate;
	}

	public void setRentDate(Date rentDate) {
		this.rentDate = rentDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public int getDaysRented() {
		long diff;
		if (getStatus() == 1) {
			diff = getReturnDate().getTime() - getRentDate().getTime();
		} else {
			diff = new Date().getTime() - getRentDate().getTime();
		}
		return (int) (diff / (1000 * 60 * 60 * 24)) + 1;
	}

	public int getDaysRentedLimit() {
		int limit = 0 ;
		int daysRented = getDaysRented();
		if ( daysRented <= 2) return limit ;

		limit = video.getDaysRentedLimit();
		return limit ;
	}

	public double getCharge() {
		double charge = 0;
		int daysRented = getDaysRented();
		charge = getVideo().getPriceCode(daysRented);
		return charge;
	}

	public int getPoint() {
		int point = 1;
		int daysRented = getDaysRented();

		if ((getVideo().getPriceCode() == Video.NEW_RELEASE) )
			point++;

		if ( daysRented > getDaysRentedLimit() )
			point -= Math.min(point, getVideo().getLateReturnPointPenalty());
		return point;
	}

	public String getReport() {
		double eachCharge = getCharge();
		int eachPoint = getPoint();
		int daysRented = getDaysRented();;

		String result = "\t" + getVideo().getTitle() + "\tDays rented: " + daysRented + "\tCharge: " + eachCharge
				+ "\tPoint: " + eachPoint + "\n";
		return result;
	}
}
