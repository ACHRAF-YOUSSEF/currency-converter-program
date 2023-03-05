public class Convertor {
    private Currency c1, c2;

    public Convertor(Currency c1, Currency c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    public Currency convert() {
        return  new Currency(0.0, "");
    }
}
