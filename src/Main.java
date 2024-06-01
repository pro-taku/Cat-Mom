import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import game.Game;

import game.terminal.Termianl;
import game.terminal.display.Display;
import game.terminal.event.Controller;

public class Main extends Termianl implements NativeKeyListener {
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    void run() {
        while (true) {
            // 맨 처음 시작할 때의 화면
            systemOn();
            startListening();
            while (getNowListening()) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            switch (option) {
                // 게임 실행
                case 0:
                    Game game = new Game();
                    game.initiate();
                    game.playing();
                    break;
                // 게임 설명
                case 1:
                    explainGame();
                    break;
                // 제작자 목록
                case 2:
                    showContributors();
                    break;
                // 시스템 종료
                case 3:
                    systemOff();
                    System.exit(0);
            }
        }
    }

    @Override
    public void previous() {}

    @Override
    public void next() {}

    @Override
    public void select() {}
}