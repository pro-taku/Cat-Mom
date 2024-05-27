public class Main {
    public static void main(String[] args) {
        while (true) {
            Display.systemOn();
            int input = Display.input(1, 4);

            switch (input) {
                case 1:
                    Game game = new Game();
                    game.initiate();
                    game.playing();
                    break;
                case 2:
                    Display.explainGame();
                    break;
                case 3:
                    Display.showContributors();
                    break;
                case 4:
                    Display.systemOff();
                    return;
            }
        }
    }
}