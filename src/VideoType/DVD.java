package VideoType;

public class DVD implements VideoType {
    @Override
    public int getLateReturnPointPenalty() {
        return 3;
    }

    @Override
    public int getDaysRentedLimit() {
        return 2;
    }
}
