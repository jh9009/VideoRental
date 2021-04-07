package PriceCode;

public class NewRelease implements PriceCode {

	@Override
	public double getCharge(int daysRented) {
		return (double)daysRented * 3;
	}

}
