
public class Fraction {
    private int numerator, denominator;
    
    public Fraction(int num, int den) {
        if (den == 0) {
            throw new IllegalArgumentException("Denominator cannot equal 0");
        }
        this.numerator = num;
        this.denominator = den;
        if (this.denominator < 0) {
            this.numerator = -this.numerator;
            this.denominator = -this.denominator;
        }
    }
    
    public Fraction(int num) {
        this.numerator = num;
        this.denominator = 1;
    }
    
    public Fraction() {
        this.numerator = 0;
        this.denominator = 1;
    }
    
    public int getNumerator() {
        return numerator;
    }   
    
    public int getDenominaotr() {
        return denominator;
    }
    
    public String toString() {
        if (denominator == numerator || numerator == 0 || denominator == 1) {
            return Integer.toString(numerator/denominator);
        }
        return numerator+"/"+denominator;
    }
    
    public double toDouble() {
        return (double)numerator/(double)denominator;
    }
    
    public Fraction add(Fraction frac) {
        if (this.denominator == frac.denominator) {
          this.numerator += frac.numerator;
          return this;
        }
        else {
            int temp = this.denominator;
            this.denominator *= frac.denominator;
            this.numerator *= frac.denominator;
            frac.denominator *= temp;
            frac.numerator *= temp;
            this.numerator += frac.numerator;
            return this;
        }
    }
    
    public Fraction subtract(Fraction frac) {
        if (this.denominator == frac.denominator) {
          this.numerator -= frac.numerator;
          return this;
        }
        else {
            int temp = this.denominator;
            this.denominator *= frac.denominator;
            this.numerator *= frac.denominator;
            frac.denominator *= temp;
            frac.numerator *= temp;
            this.numerator -= frac.numerator;
            return this;
        }
    }
    
    public Fraction multiply(Fraction frac) {
        this.numerator *= frac.numerator;
        this.denominator *= frac.denominator;
        return this;
    }
    
    public Fraction divide(Fraction frac) {
        this.numerator *= frac.denominator;
        this.denominator *= frac.numerator;
        return this;
    }
    
    public boolean equals(Object frac) {
        if (frac instanceof Fraction) {
            if (this.numerator/this.denominator == ((Fraction) frac).numerator/((Fraction) frac).denominator)
                return true;
            else {
                return false;
            }      
        }
        else {
            return false;
        }
    }
    
    public void toLowestTerms() {
        int a = this.numerator;
        int b = this.denominator;
        while (a != 0 && b != 0) {
            int remainder = a % b;
            a = b;
            b = remainder;
        }
        this.numerator = this.numerator/a;
        this.denominator = this.denominator/a;
    }
    public static int gcd(int num, int den) {
        while (num != 0 && den != 0) {
            int remainder = num % den;
            num = den;
            den = remainder;
        }
        return num;
    }
}

