/** Lớp điểm 2D. */
public class Point2D {
    // protected: lớp con (Point3D) truy cập trực tiếp được, bên ngoài thì không
    protected double x;
    protected double y;

    public Point2D() {
        this(0, 0);
    }

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() { return x; }
    public double getY() { return y; }
    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }

    /** Tính khoảng cách giữa 2 điểm 2D. */
    public double distance(Point2D other) {
        double dx = x - other.x;
        double dy = y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    /** Xác định điểm đối xứng qua gốc tọa độ. */
    public Point2D symmetric() {
        return new Point2D(-x, -y);
    }

    /** Tịnh tiến điểm đi một vị trí độ lệch (dx, dy). */
    public void translate(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    @Override
    public String toString() {
        return String.format("Point2D(%.2f, %.2f)", x, y);
    }
}
