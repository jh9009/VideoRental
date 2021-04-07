import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Customer {
	private String name;

	private List<Rental> rentals = new ArrayList<Rental>();

	public Customer(String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Rental> getRentals() {
		return rentals;
	}

	public void setRentals(List<Rental> rentals) {
		this.rentals = rentals;
	}

	public void addRental(Rental rental) {
		rentals.add(rental);

	}

	public String getReport() {
		String result = "Customer Report for " + getName() + "\n";

		List<Rental> rentals = getRentals();

		double totalCharge = 0;
		int totalPoint = 0;

		for (Rental each : rentals) {
			double eachCharge = each.getCharge();
			int eachPoint = each.getPoint();

			result += each.getReport();

			totalCharge += eachCharge;

			totalPoint += eachPoint ;
		}

		result += "Total charge: " + totalCharge + "\tTotal Point:" + totalPoint + "\n";


		if ( totalPoint >= 10 ) {
			result += "Congrat! You earned one free coupon";
		}
		if ( totalPoint >= 30 ) {
			result += "Congrat! You earned two free coupon";
		}
		return result ;
	}

	public void returnVideo(String videoTitle) {
		for ( Rental rental: rentals ) {
			if ( rental.getVideo().getTitle().equals(videoTitle) && rental.getVideo().isRented() ) {
				rental.returnVideo();
				rental.getVideo().setRented(false);
				break ;
			}
		}
	}
	public void clearRentals() {
		rentals = new ArrayList<Rental>();
	}

	public void rentVideo(Video foundVideo) {
		Rental rental = new Rental(foundVideo) ;
		foundVideo.setRented(true);
		rentals.add(rental);
	}

	public String listInformation() {
		String log = "";
		log += "Name: " + getName() + "\tRentals: " + rentals.size() ;
		for ( Rental rental: rentals ) {
			log += "\tTitle: " + rental.getVideo().getTitle() + " " ;
			log += "\tPrice Code: " + rental.getVideo().getPriceCode() ;
		}
		return log;
	}
}
