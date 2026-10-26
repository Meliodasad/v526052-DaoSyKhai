package bai2.controller;

import bai2.model.Game;
import bai2.view.GameView;

public class GameController {
    private Game game;
    private GameView view;

    public GameController(Game game, GameView view) {
        this.game = game;
        this.view = view;
    }

    // Vòng lặp while điều khiển chương trình
    public void run() {
        boolean running = true;
        while (running) {
            view.showBoard(game);
            view.showMenu();
            int choice = view.readInt("Chọn: ");
            switch (choice) {
                case 1:
                    int row = view.readInt("Hàng (1-9): ") - 1;
                    int col = view.readInt("Cột (1-9): ") - 1;
                    int val = view.readInt("Giá trị (1-9, 0 để xóa): ");
                    if (!game.setValue(row, col, val)) {
                        view.showMessage("Dữ liệu không hợp lệ!");
                    } else if (!game.validateGame()) {
                        view.showMessage("Cảnh báo: nước đi này vi phạm luật Sudoku!");
                    } else if (game.isComplete()) {
                        view.showBoard(game);
                        view.showMessage("Chúc mừng! Bạn đã hoàn thành Sudoku.");
                        running = false;
                    }
                    break;
                case 2:
                    if (game.isComplete()) {
                        view.showMessage("Game đã hoàn thành và hợp lệ!");
                    } else if (game.validateGame()) {
                        view.showMessage("Hiện tại hợp lệ, chưa hoàn thành.");
                    } else {
                        view.showMessage("Game đang vi phạm luật!");
                    }
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    view.showMessage("Lựa chọn không hợp lệ!");
            }
        }
    }
}
