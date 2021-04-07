package PriceCode;

public class NewRelease implements PriceCode {

	@Override
	public double getPriceCode(int daysRented) {
		return (double)daysRented * 3;
	}

}
