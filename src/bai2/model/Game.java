package bai2.model;

public class Game {
    public static final int SIZE = 9;
    public static final int ZONE_SIZE = 3;

    private Node[][] board;

    // Khởi tạo game từ mảng tĩnh
    public Game(int[][] data) {
        board = new Node[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = new Node(i, j, data[i][j]);
            }
        }
    }

    public Node[][] getBoard() { return board; }

    public Node getNode(int row, int col) { return board[row][col]; }

    public boolean setValue(int row, int col, int value) {
        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) return false;
        if (value < 0 || value > 9) return false;
        board[row][col].setValue(value);
        return true;
    }

    // Kiểm tra 1 hàng: không có số trùng (bỏ qua ô trống = 0)
    public boolean validateRow(int row) {
        boolean[] seen = new boolean[SIZE + 1];
        for (int c = 0; c < SIZE; c++) {
            int v = board[row][c].getValue();
            if (v != 0) {
                if (seen[v]) return false;
                seen[v] = true;
            }
        }
        return true;
    }

    // Kiểm tra 1 cột
    public boolean validateColumn(int col) {
        boolean[] seen = new boolean[SIZE + 1];
        for (int r = 0; r < SIZE; r++) {
            int v = board[r][col].getValue();
            if (v != 0) {
                if (seen[v]) return false;
                seen[v] = true;
            }
        }
        return true;
    }

    // Kiểm tra 1 vùng 3x3 (zone 0..8, đánh số từ trái sang phải, trên xuống dưới)
    public boolean validateZone(int zone) {
        boolean[] seen = new boolean[SIZE + 1];
        int startRow = (zone / ZONE_SIZE) * ZONE_SIZE;
        int startCol = (zone % ZONE_SIZE) * ZONE_SIZE;
        for (int r = startRow; r < startRow + ZONE_SIZE; r++) {
            for (int c = startCol; c < startCol + ZONE_SIZE; c++) {
                int v = board[r][c].getValue();
                if (v != 0) {
                    if (seen[v]) return false;
                    seen[v] = true;
                }
            }
        }
        return true;
    }

    // Kiểm tra toàn bộ game (không vi phạm luật)
    public boolean validateGame() {
        for (int i = 0; i < SIZE; i++) {
            if (!validateRow(i) || !validateColumn(i) || !validateZone(i)) {
                return false;
            }
        }
        return true;
    }

    // Đã điền đầy đủ và hợp lệ
    public boolean isComplete() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j].getValue() == 0) return false;
            }
        }
        return validateGame();
    }
}
