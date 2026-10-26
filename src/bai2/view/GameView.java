package bai2.view;

import bai2.model.Game;
import java.util.Scanner;

public class GameView {
    private Scanner sc = new Scanner(System.in);

    // Hiển thị game
    public void showBoard(Game game) {
        System.out.println();
        System.out.println("    1 2 3   4 5 6   7 8 9");
        for (int i = 0; i < Game.SIZE; i++) {
            if (i % 3 == 0) System.out.println("  +-------+-------+-------+");
            System.out.print((i + 1) + " ");
            for (int j = 0; j < Game.SIZE; j++) {
                if (j % 3 == 0) System.out.print("| ");
                int v = game.getNode(i, j).getValue();
                System.out.print((v == 0 ? "." : String.valueOf(v)) + " ");
            }
            System.out.println("|");
        }
        System.out.println("  +-------+-------+-------+");
    }

    public void showMenu() {
        System.out.println("\n1. Điền số vào ô");
        System.out.println("2. Kiểm tra game");
        System.out.println("0. Thoát");
    }

    // Nhập dữ liệu
    public int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên!");
            }
        }
    }

    public void showMessage(String msg) {
        System.out.println(msg);
    }
}
