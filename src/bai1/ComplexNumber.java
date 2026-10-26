package bai1;

public class ComplexNumber {
    private double re; // phần thực
    private double im; // phần ảo

    // Hàm tạo mặc định: phần thực 1.0, phần ảo -1.0
    public ComplexNumber() {
        this(1.0, -1.0);
    }

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() { return re; }
    public double getIm() { return im; }
    public void setRe(double re) { this.re = re; }
    public void setIm(double im) { this.im = im; }

    // (a + bi) + (c + di) = (a + c) + (b + d)i
    public ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber(this.re + other.re, this.im + other.im);
    }

    // |z| = sqrt(a^2 + b^2)
    public double modulus() {
        return Math.sqrt(re * re + im * im);
    }

    // Số phức không có phần ảo
    public boolean hasNoImaginary() {
        return Math.abs(im) < 1e-9;
    }

    @Override
    public String toString() {
        return String.format("%.2f %s %.2fi", re, im < 0 ? "-" : "+", Math.abs(im));
    }
}
