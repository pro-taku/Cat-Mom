import game.Game;

import game.Tick;
import game.screen.Termianl;

public class Main extends Termianl {
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    void run() {
        while (true) {
            // 맨 처음 시작할 때의 화면
            systemOn();
            int input = input(1, 4);

            switch (input) {
                // 게임 실행
                case 1:
                    Game game = new Game();
                    game.initiate();
                    game.playing();
                    break;
                // 게임 설명
                case 2:
                    explainGame();
                    break;
                // 제작자 목록
                case 3:
                    showContributors();
                    break;
                // 시스템 종료
                case 4:
                    systemOff();
                    return;
            }
        }
    }
//    public static void main(String[] args) {
//        // Check if the console supports ANSI escape codes
//        if (System.console() == null) {
//            System.out.println("This console does not support ANSI escape codes.");
//            return;
//        }
//        clearScreen();
//        System.out.println("print");
//        // Set the cursor position to row 5, column 10
//        setCursorPosition(5, 10);
//        // Print a message at the new cursor position
//        System.out.println("               _ |\\_\n" +
//                "               \\` ..\\\n" +
//                "          __,.-\" =__Y=     asciiart.cc\n" +
//                "  aac   .\"        )\n" +
//                "  _    /   ,    \\/\\_\n" +
//                " ((____|    )_-\\ \\_-`\n" +
//                " `-----'`-----` `--`\n");
//
//    }
//    private static void setCursorPosition(int row, int col) {
//        // ANSI escape code to set cursor position
//        String escapeCode = "\u001B[" + (row + 1) + ";" + (col + 1) + "H";
//        // Print the escape code to move the cursor
//        System.out.print(escapeCode);
//    }
//    public static void clearScreen() {
//        System.out.print("\033[H\033[2J");
//        System.out.flush();
//    }
}