package game.screen;

import game.objects.Cat;

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

    protected void mainMenu() {
       display.mainMenu();
    }

    protected void showCatProfile(Cat[] cats) {
        display.showCatProfile(cats);
    }

    protected void actionMenu() {
        display.actionMenu();
    }
}
