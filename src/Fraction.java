//1
package fraction;

import java.util.Objects;

public class Fraction implements Fractionable {
    private int numerator;
    private int denominator;
    private Double cachedValue = null; // кэш вещественного значения

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) throw new IllegalArgumentException("Знаменатель не может быть 0");
        if (denominator < 0) { // нормализация
            numerator = -numerator;
            denominator = -denominator;
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public double getValue() {
        if (cachedValue == null) cachedValue = (double) numerator / denominator;
        return cachedValue;
    }

    @Override
    public void setNumerator(int numerator) {
        this.numerator = numerator;
        cachedValue = null; // инвалидируем кэш
    }

    @Override
    public void setDenominator(int denominator) {
        if (denominator == 0) throw new IllegalArgumentException("Знаменатель не может быть 0");
        if (denominator < 0) {
            this.numerator = -this.numerator;
            denominator = -denominator;
        }
        this.denominator = denominator;
        cachedValue = null;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fraction)) return false;
        Fraction f = (Fraction) o;
        return this.numerator * f.denominator == this.denominator * f.numerator;
    }

    @Override
    public int hashCode() {
        int gcd = gcd(Math.abs(numerator), denominator);
        return Objects.hash(numerator / gcd, denominator / gcd);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
}
