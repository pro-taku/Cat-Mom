import org.w3c.dom.ranges.RangeException;

import java.util.Scanner;

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
 * <h2>Display 클래스의 메소드</h2>
 *
 * <h3>입력 관련</h3>
 * <ol>
 *     <li>{@return String} {@link #input()}: 사용자의 입력을 받는다.</li>
 *     <li>{@return int} {@link  #input(int begin, int end)}: 사용자의 입력을 받는다. 범위를 지정할 수 있다.</li>
 *     <li>{@return void} {@link #waitBeforeEnter()}: 사용자가 [Enter]를 누를 때까지 대기한다.</li>
 * </ol>
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
public abstract class Display {
    private static Scanner keyboard = new Scanner(System.in);

    public static String input() {
        System.out.printf("> ");
        return keyboard.nextLine();
    }

    public static int input(int begin, int end) {
        boolean hasError;
        int result = 0;

        do {
            hasError = false;
            System.out.printf("> ");
            var userInput = keyboard.nextLine();

            try {
                result = Integer.parseInt(userInput);
                if (result < begin || result > end) {
                    throw new RangeException((short) 400, "범위를 벗어난 입력입니다.");
                }
            } catch (Exception e) {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                hasError = true;
            }
        } while (hasError);

        return result;
    }

    static void waitBeforeEnter() {
        System.out.printf("(뒤로 돌아가려면 [Enter]를 누르시오...)");
        try {
            keyboard.nextLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void systemOn() {
        System.out.println("     <고양이 키우기>     ");
        System.out.println("=======================\n");
        System.out.println("  1. 게임 시작");
        System.out.println("  2. 게임 설명");
        System.out.println("  3. 제작자 정보");
        System.out.println("  4. 게임 종료");
        System.out.println("\n  (원하는 번호를 입력해주세요)\n");
        System.out.println("=======================\n");
    }

    public static void systemOff() {
        System.out.println("게임을 종료합니다.");
    }

    public static void explainGame() {
        System.out.println("게임 설명 페이지");
        waitBeforeEnter();
    }

    public static void showContributors() {
        System.out.println("제작자 정보 페이지");
        waitBeforeEnter();
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
