public class CurrencyConvertorClass {
    private final String fromTo;
    private final double ratio;

    private CurrencyConvertorClass(String fromTo, double ratio) {
        this.fromTo = fromTo;
        this.ratio = ratio;
    }

    public String getFromTo() {
        return fromTo;
    }

    public double convertFromTo(double cu) {
        return cu * ratio;
    }
}
