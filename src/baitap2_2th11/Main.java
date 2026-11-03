import java.util.ArrayList;
import java.util.List;

public class Main {
    /** Tổng khoảng cách giữa các điểm liên tiếp trong danh sách điểm 2D. */
    static double total2D(List<Point2D> list) {
        double sum = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            sum += list.get(i).distance(list.get(i + 1));
        }
        return sum;
    }

    /** Tổng khoảng cách giữa các điểm liên tiếp trong danh sách điểm 3D. */
    static double total3D(List<Point3D> list) {
        double sum = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            sum += list.get(i).distance(list.get(i + 1));
        }
        return sum;
    }

    public static void main(String[] args) {
        // 1. Danh sách chứa cả điểm 2D và 3D (đa hình)
        List<Point2D> points = new ArrayList<>();
        points.add(new Point2D(0, 0));
        points.add(new Point2D(3, 4));
        points.add(new Point2D(6, 8));
        points.add(new Point3D(1, 2, 2));
        points.add(new Point3D(4, 6, 2));
        points.add(new Point3D(4, 6, 10));

        // 2. Tách ra 2 danh sách để tính tổng khoảng cách
        List<Point2D> list2D = new ArrayList<>();
        List<Point3D> list3D = new ArrayList<>();
        for (Point2D p : points) {
            if (p instanceof Point3D) {
                list3D.add((Point3D) p);
            } else {
                list2D.add(p);
            }
        }
        System.out.printf("Tong khoang cach cac diem 2D: %.2f%n", total2D(list2D));
        System.out.printf("Tong khoang cach cac diem 3D: %.2f%n", total3D(list3D));

        // 3. Đưa các điểm đối xứng vào danh sách (duyệt trên bản sao để tránh lỗi sửa list khi lặp)
        for (Point2D p : new ArrayList<>(points)) {
            points.add(p.symmetric());   // gọi đúng hàm theo kiểu thực của đối tượng
        }

        // 4. Hiển thị danh sách
        System.out.println("\nDanh sach cac diem:");
        for (int i = 0; i < points.size(); i++) {
            System.out.println((i + 1) + ". " + points.get(i));
        }

        // Thử tịnh tiến
        Point3D p = new Point3D(1, 1, 1);
        p.translate(2, 3, 4);
        System.out.println("\nSau khi tinh tien (2,3,4): " + p);
    }
}
