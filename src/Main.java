import game.Game;
import game.screen.Display;
import game.screen.Termianl;

import java.io.*;

public class Main extends Termianl {
    public static void main(String[] args) {
        new Main().run();
    }

    void run() {
        Display.clearScreen();
        while (true) {
            // 맨 처음 시작할 때의 화면
            option = 0;
            optionCount = 4;
            systemOn();
            selectMenuItem();

            switch (option) {
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
}