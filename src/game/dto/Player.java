package game.dto;

import game.terminal.Termianl;
import game.terminal.display.Display;

/**
 * <h1>game.objects.Player</h1>
 *
 * <p>
 *     수정 일자 : 2024.05.27 19:13<br>
 *     수정자 : 국희근(protaku)
 * </p>
 *
 * <br>
 *
 * <p>
 *     플레이어 클래스. 즉 고양이들의 집사입니다.<br>
 *     해당 객체는 생성 시, 이름을 초기화 해주어야 하고<br>
 *     게임을 어떻게 진행시킬지 결정하는 메소드를 가지고 있습니다.
 * </p>
 *
 * <br>
 *
 * <h2>주요 메서드</h2>
 * <ol>
 *     <li>{@retrun int} {@link #doSomething(Cat[] cats)} : 플레이어가 어떤 행동을 할지 결정하는 메서드</li>
 * </ol>
 */
public class Player extends Termianl {
    private final String name;
    private int actionCount = 5;
    private Cat[] cats;

    public Player(String name) {
        this.name = name;
    }

    public void setCats(Cat[] cats) {
        this.cats =  cats;
    }

    public String getName() {
        return name;
    }

    public int getActionCount() {
        return actionCount;
    }

    public void resetActionCount() {
        actionCount = 5;
    }

    public Cat[] getCats() {
        return cats;
    }

    public int doSomething(Cat[] cats) {
        // 변수 선언
        boolean looping;            // 행동 선택 과정의 반복 여부
        int catCount = cats.length; // 고양이 수
        int result = 0;     // 선택지, 반환값

        do {
            looping = false;

            // 원하는 메뉴를 선택
            // 1. 플레이어가 고양이에게 무언가를 함
            // 2. 고양이 정보 확인
            // 3. 플레이어 정보 확인
            // 4. 메인창으로 돌아가기
            mainMenu();
            startListening();
            while (getNowListening()) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (option != 0)  {
                looping = true;
                if (option == 1) {
                    Display.cleanScreen();
                    System.out.println("살펴볼 고양이 (번호로 입력해주세요)");
                    showCatsName(cats);

                    option = input(1, catCount);
                    showCatInfo(cats[option]);
                }
                else if (option == 2) {
                    Display.cleanScreen();
                    showPlayerInfo(this);
                } else if (option == 3) {
                    Display.setCursorPosition(14, 0);
                    System.out.println("메인창으로 돌아갑니다.");
                    waitBeforeEnter();
                    return -1;
                }
                return 0;
            }

            // 만약 행동을 선택했다면, 누구를 대상으로 할지 선택
            Display.setCursorPosition(14, 0);
            System.out.println("누구를 대상으로 하시겠습니까? (번호로 입력해주세요)");
            showCatsName(cats);
            option = input(1, catCount);
            result += option * 10;

            // 어떤 행동을 할지 선택
            actionMenu();
            startListening();
            while (getNowListening()) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (option == 6) {
                return 0;
            } else {
                result += option;
            }
        } while(looping);

        // 행동 횟수 감소
        actionCount--;

        // 반환값의 10의 자리 = 고양이 번호
        // 반환값의  1의 자리 = 행동
        return result;
    }

    @Override
    public void previous() {}

    @Override
    public void next() {}

    @Override
    public void select() {}
}
