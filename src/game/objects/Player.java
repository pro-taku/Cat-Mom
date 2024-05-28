package game.objects;

import game.screen.Display;
import game.screen.Termianl;
import game.script.Action;

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
public class Player extends Termianl implements Action {
    private String name;
    private int actionCount = 5;

    public Player(String name) {
        this.name = name;
    }

    public int doSomething(Cat[] cats) {
        // 변수 선언
        boolean looping;            // 행동 선택 과정의 반복 여부
        int catCount = cats.length; // 고양이 수
        int option, result = 0;     // 선택지, 반환값

        do {
            looping = false;

            // 원하는 메뉴를 선택
            // 1. 플레이어가 고양이에게 무언가를 함
            // 2. 고양이 정보 확인
            // 3. 플레이어 정보 확인
            // 4. 메인창으로 돌아가기
            mainMenu();
            option = input(1, 4);
            if (option != 1)  {
                looping = true;
                if (option == 2) {
                    System.out.println("고양이 정보");
                    waitBeforeEnter();
                } else if (option == 3) {
                    System.out.println("플레이어 정보");
                    waitBeforeEnter();
                } else if (option == 4) {
                    System.out.println("메인창으로 돌아갑니다.");
                    waitBeforeEnter();
                    return 0;
                }
                continue;
            }

            // 만약 행동을 선택했다면, 누구에게 대상으로 할지 선택
            System.out.println("누구에게 대상으로 하시겠습니까? (번호로 입력해주세요)");
            showCatProfile(cats);
            option = input(1, catCount);
            result += option * 10;

            // 어떤 행동을 할지 선택
            actionMenu();
            option = input(0, 6);
            if (option == 0) {
                looping = true;
            } else {
                result += option;
            }
        } while(looping);

        // 반환값의 10의 자리 = 고양이 번호
        // 반환값의  1의 자리 = 행동
        return option;
    }
}
