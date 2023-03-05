import java.util.Objects;

public class Currency {
    private double ratio;
    private String units;

    public Currency(double ratio, String units) {
        this.ratio = ratio;
        this.units = units;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Currency currency = (Currency) o;

        return Double.compare(currency.ratio, ratio) == 0 && units.equals(currency.units);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ratio, units);
    }
}
