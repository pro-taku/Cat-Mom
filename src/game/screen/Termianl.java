package game.screen;

import game.objects.Cat;
import game.objects.Player;

import java.io.IOException;

public abstract class Termianl {
    private final Display display;
    private final UserInput userInput;

    public int option;
    public int optionCount;

    protected Termianl() {
        KeyboardListenCallback callback = new KeyboardListenCallback() {
            @Override
            public void changeMenuItem(Integer direction) {
                if (direction == 0) return;

                if (direction != null) {
                    option = (option + optionCount + direction) % optionCount;
                }
                systemOn();
            }
        };

        this.display = new Display();
        this.userInput = new UserInput(callback);
    }

    protected void waitBeforeEnter() {
        userInput.waitBeforePressingAny();
    }

    protected String input() {
        return userInput.setName();
    }

    protected int input(int begin, int end) {
        return userInput.setNumber(begin, end);
    }

    protected void selectMenuItem() {
        userInput.selectMenuItem();
    }

    protected void systemOn() {
        display.setCursorPosition(0, 0);
        display.systemOn();


        int row = 3 + option;
        int col = 17;
        display.setCursorPosition(row, col);
        try {
            display.writer.write(" [*]");
            display.writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected void systemOff() {
        display.systemOff();
    }

    protected void explainGame() {
        display.explainGame();
        userInput.waitBeforePressingAny();
    }

    protected void showContributors() {
        display.showContributors();
        userInput.waitBeforePressingAny();
    }

    protected void showDays(int days) {
        display.showDay(days);
    }

    protected void mainMenu() {
       display.mainMenu();
    }

    protected void showCatsName(Cat[] cats) {
        display.showCatsName(cats);
    }

    protected void showCatInfo(Cat cat) {
        display.showCatInfo(cat);
    }

    protected void showPlayerInfo(Player player) {
        display.showPlayerInfo(player);
    }

    protected void actionMenu() {
        display.actionMenu();
    }

    protected void catEvent(Cat cat, int action) {
        display.catEvent(cat, action);
    }

    protected void remainingActionChances(Player player) {
        display.remainingActionChances(player);
    }

    protected void warningCatStatus(Cat cat, int checkedValue) {
        display.warningCatStatus(cat, checkedValue);
    }

    protected void warningMessage(int warning) {
        display.warningMessage(warning);
        userInput.waitBeforeEnter();
    }

    protected void lose(int days) {
        display.lose(days);
        userInput.waitBeforeEnter();
    }

    protected void win(Player player, int days) {
        display.win(player, days);
        userInput.waitBeforeEnter();
    }
}
