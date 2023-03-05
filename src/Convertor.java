public class Convertor {
    private Currency c1, c2;

    public Convertor(Currency c1, Currency c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    public Currency convertC1ToC2() {
        double res = c1.getRatio() / c2.getRatio();

        return  new Currency(res, c2.getUnits());
    }

    public Currency convertC2ToC1() {
        double res = c1.getRatio() * c2.getRatio();

        return  new Currency(res, c1.getUnits());
    }
}
