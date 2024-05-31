package game.screen;

import game.objects.Cat;
import game.objects.Player;

public abstract class Termianl {
    private final Display display = new Display();
    private final UserInput userInput = new UserInput();

    protected void waitBeforeEnter() {
        userInput.waitBeforeEnter();
    }

    protected String input() {
        return userInput.input();
    }

    protected int input(int begin, int end) {
        return userInput.input(begin, end);
    }

    protected void systemOn() {
        display.systemOn();
    }

    protected void systemOff() {
        display.systemOff();
    }

    protected void explainGame() {
        display.explainGame();
        userInput.waitBeforeEnter();
    }

    protected void showContributors() {
        display.showContributors();
        userInput.waitBeforeEnter();
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

    protected void win(int days) {
        display.win(days);
        userInput.waitBeforeEnter();
    }
}
