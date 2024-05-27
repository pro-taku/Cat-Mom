public class Main {
    public static void main(String[] args) {
        while (true) {
            // 맨 처음 시작할 때의 화면
            Display.systemOn();
            int input = Display.input(1, 4);

            switch (input) {
                // 게임 실행
                case 1:
                    Game game = new Game();
                    game.initiate();
                    game.playing();
                    break;
                // 게임 설명
                case 2:
                    Display.explainGame();
                    break;
                // 제작자 목록
                case 3:
                    Display.showContributors();
                    break;
                // 시스템 종료
                case 4:
                    Display.systemOff();
                    return;
            }
        }
    }
}