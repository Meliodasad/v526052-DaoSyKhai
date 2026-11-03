/** Lớp điểm 3D kế thừa từ Point2D. */
public class Point3D extends Point2D {
    private double z;

    public Point3D() {
        super();
        this.z = 0;
    }

    public Point3D(double x, double y, double z) {
        super(x, y);          // gọi constructor lớp cha
        this.z = z;
    }

    public double getZ() { return z; }
    public void setZ(double z) { this.z = z; }

    /** Tính khoảng cách giữa 2 điểm 3D (nạp chồng - overload). */
    public double distance(Point3D other) {
        double dx = x - other.x;
        double dy = y - other.y;
        double dz = z - other.z;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    /** Định nghĩa lại (override) hàm xác định điểm đối xứng qua gốc tọa độ. */
    @Override
    public Point3D symmetric() {
        return new Point3D(-x, -y, -z);
    }

    /** Tịnh tiến điểm đi một vị trí độ lệch (dx, dy, dz). */
    public void translate(double dx, double dy, double dz) {
        super.translate(dx, dy);   // tái sử dụng hàm của lớp cha
        this.z += dz;
    }

    @Override
    public String toString() {
        return String.format("Point3D(%.2f, %.2f, %.2f)", x, y, z);
    }
}
