package game.terminal;

import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import game.dto.Cat;
import game.dto.Player;
import game.terminal.event.*;
import game.terminal.display.Display;

public abstract class Termianl implements SelectingOptionCallback {
    private final Display display;
    private final UserInput userInput;
    private final Controller controller;

    public static int option;
    public static int optionCount;

    private static int initRow, initCol;
    private static int cursorRow, cursorCol;
    private static boolean menuDirection;

    protected Termianl() {
        this.display = new Display();
        this.userInput = new UserInput();
        this.controller = new Controller(new SelectingOptionCallback() {
            @Override
            public void previous() {
                option = (option - 1 + optionCount) % optionCount;
                changeMenuItem();
            }

            @Override
            public void next() {
                option = (option + 1) % optionCount;
                changeMenuItem();
            }

            @Override
            public void select() {
                Controller.nowListening = false;
            }
        });
    }

    public void startListening() {
        Controller.nowListening = true;
    }

    public boolean getNowListening() {
        return controller.getNowListening();
    }

    // UserInput 관련

    protected String input() {
        return userInput.input();
    }

    protected int input(int begin, int end) {
        return userInput.input(begin, end);
    }

    protected void waitBeforeEnter() {
        userInput.waitBeforeEnter();
    }

    protected void changeMenuItem() {
        Display.setCursorPosition(cursorRow, cursorCol);
        System.out.println(" ".repeat(20));
        cursorRow = initRow + option;
        Display.setCursorPosition(cursorRow, cursorCol);
        System.out.println("[*] (스페이스 바)");

        // 행동 메뉴 한정
        if (optionCount == 7) {
            display.explainAction(option, 19, 42);
        }
    }

    // Display 관련

    protected void systemOn() {
        Display.cleanScreen();
        display.systemOn();

        option = 0;
        optionCount = 4;
        initRow = cursorRow = 21;
        initCol = cursorCol = 22;
        changeMenuItem();
    }

    protected void systemOff() {
        Display.setCursorPosition(36, 0);
        display.systemOff();
    }

    protected void explainGame() {
        Display.cleanScreen();
        display.explainGame();
        userInput.waitBeforeEnter();
    }

    protected void showContributors() {
        Display.cleanScreen();
        display.showContributors();
        userInput.waitBeforeEnter();
    }

    protected void showDays(int days) {
        display.showDay(days);
    }

    protected void mainMenu() {
       display.mainMenu();

        option = 0;
        optionCount = 4;
        initRow = cursorRow = 6;
        initCol = cursorCol = 25;
        changeMenuItem();
    }

    protected void showCatsName(Cat[] cats) {
        display.showCatsName(cats);
    }

    protected void showCatInfo(Cat cat) {
        display.showCatInfo(cat);
        userInput.waitBeforeEnter();
    }

    protected void showPlayerInfo(Player player) {
        display.showPlayerInfo(player);
        userInput.waitBeforeEnter();
    }

    protected void actionMenu() {
        display.actionMenu();

        option = 0;
        optionCount = 7;
        initRow = cursorRow = 20;
        initCol = cursorCol = 22;
        changeMenuItem();
    }

    protected void catEvent(Cat cat, int action) {
        Display.cleanScreen();
        display.catEvent(cat, action);
        userInput.waitBeforeEnter();
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
        Display.cleanScreen();
        display.lose(days);
        userInput.waitBeforeEnter();
    }

    protected void win(Player player, int days) {
        Display.cleanScreen();
        display.win(player, days);
        userInput.waitBeforeEnter();
    }
}
