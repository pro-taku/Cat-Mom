package game.screen;

import game.objects.Cat;
import game.screen.UserInput;

/**
 * <h1>{@link Display}</h1>
 *
 * <p>
 *     수정 일자 : 2024.05.27 19:13<br>
 *     수정자 : 국희근(protaku)
 * </p>
 *
 * <br>
 *
 * <p>
 *     이 게임은 터미널을 통해 실행되는 콘솔 게임이다.<br>
 *     해당 클래스를 써서 사용자의 입력을 받거나, 정해진 메뉴를 보여줄 수 있다.
 * </p>
 *
 * <br>
 *
 * <h3>출력 관련</h3>
 * <ol>
 *     <li>{@link #systemOn()}: 게임 시작 시 메인 메뉴를 보여준다.</li>
 *     <li>{@link #systemOff()}: 게임 종료 시 메시지를 보여준다.</li>
 *     <li>{@link #explainGame()}: 게임 설명을 보여준다.</li>
 *     <li>{@link #showContributors()}: 제작자 정보를 보여준다.</li>
 *     <li>{@link #mainMenu()}: 게임 플레이어의 메인 메뉴를 보여준다.</li>
 *     <li>{@link #showCatProfile(Cat[] cats)}: 고양이 정보를 보여준다.</li>
 *     <li>{@link #actionMenu()}: 행동 메뉴를 보여준다.</li>
 *     <li>{@link #event()}: 이벤트를 보여준다.</li>
 *     <li>{@link #acting()}: 행동을 보여준다.</li>
 *     <li>{@link #nextDay()}: 하루가 지났음을 알린다.</li>
 * </ol>
 */
public class Display {

    void systemOn() {
        System.out.println("     <고양이 키우기>     ");
        System.out.println("=======================\n");
        System.out.println("  1. 게임 시작");
        System.out.println("  2. 게임 설명");
        System.out.println("  3. 제작자 정보");
        System.out.println("  4. 게임 종료");
        System.out.println("\n  (원하는 번호를 입력해주세요)\n");
        System.out.println("=======================\n");
    }

    void systemOff() {
        System.out.println("게임을 종료합니다.");
    }

    void explainGame() {
        System.out.println("게임 설명 페이지");
    }

    void showContributors() {
        System.out.println("제작자 정보 페이지");
    }

    void mainMenu() {
        System.out.println("\n=== 메인 메뉴 ===");
        System.out.println(  "  1. 행동하기");
        System.out.println(  "  2. 고양이 정보");
        System.out.println(  "  3. 플레이어 정보");
        System.out.println(  "  4. 메인창으로");
        System.out.println(  "================\n");
    }

    void showCatProfile(Cat[] cats) {
        for (int i=1 ; i < cats.length ; i++) {
            System.out.printf("([" + i + "] " + cats[i].getName() + ")  ");
        }
        System.out.println();
    }

    void actionMenu() {
        System.out.println("\n========== 행동 ==========");
        System.out.println(  "  1. 밥주기");
        System.out.println(  "  2. 재우기");
        System.out.println(  "  3. 쓰다듬기");
        System.out.println(  "  4. 씻기");
        System.out.println(  "  5. 치료하기");
        System.out.println(  "  6. 산책시키기");
        System.out.println(  "  0. 뒤로가기");
        System.out.println(  "=========================\n");
    }

    void event() {}
    void acting() {}
    void nextDay() {}
}
