package bai1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<ComplexNumber> list = new ArrayList<>();
        list.add(new ComplexNumber());          // 1.0 - 1.0i
        list.add(new ComplexNumber(3, 4));
        list.add(new ComplexNumber(-2, 0));
        list.add(new ComplexNumber(0.5, 2.5));
        list.add(new ComplexNumber(5, 0));

        // a) Hiển thị danh sách
        System.out.println("Danh sách số phức:");
        for (ComplexNumber z : list) {
            System.out.println("  " + z + "   |z| = " + String.format("%.4f", z.modulus()));
        }

        // b) Trung bình cộng
        ComplexNumber sum = new ComplexNumber(0, 0);
        for (ComplexNumber z : list) {
            sum = sum.add(z);
        }
        int n = list.size();
        ComplexNumber avg = new ComplexNumber(sum.getRe() / n, sum.getIm() / n);
        System.out.println("Trung bình cộng: " + avg);

        // c) Số phức có Modulus lớn nhất
        ComplexNumber max = list.get(0);
        for (ComplexNumber z : list) {
            if (z.modulus() > max.modulus()) {
                max = z;
            }
        }
        System.out.println("Số phức có Modulus lớn nhất: " + max
                + " (|z| = " + String.format("%.4f", max.modulus()) + ")");

        // d) Đếm số phức không có phần ảo
        int count = 0;
        for (ComplexNumber z : list) {
            if (z.hasNoImaginary()) count++;
        }
        System.out.println("Số lượng số phức không có phần ảo: " + count);
    }
}
