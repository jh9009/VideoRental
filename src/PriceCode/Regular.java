package PriceCode;

public class Regular implements PriceCode{

    @Override
    public double getPriceCode(int daysRented) {
        double charge = 2;
        if (daysRented > 2)
            charge += (double)(daysRented - 2) * 1.5;
        return charge;
    }
}
