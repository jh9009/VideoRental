package VideoType;

public class CD implements VideoType {
    @Override
    public int getLateReturnPointPenalty() {
        return 2;
    }

    @Override
    public int getDaysRentedLimit() {
        return 3;
    }
}
