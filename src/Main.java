import game.Game;

import game.screen.Termianl;

public class Main extends Termianl {
    public static void main(String[] args) {
        new Main().run();
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
}