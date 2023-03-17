public class CurrencyConverterClass {
    private final String fromTo;
    private final double ratio;

    CurrencyConverterClass(String fromTo, double ratio) {
        this.fromTo = fromTo;
        this.ratio = ratio;
    }

    public String getFromTo() {
        return fromTo;
    }

    public double convertFromTo(double cu) {
        return cu * ratio;
    }

    @Override
    public String toString() {
        return fromTo;
    }
}
