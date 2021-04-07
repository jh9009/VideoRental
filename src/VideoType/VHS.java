package VideoType;

public class VHS implements VideoType {
    @Override
    public int getLateReturnPointPenalty() {
        return 1;
    }

    @Override
    public int getDaysRentedLimit() {
        return 5;
    }
}
