import org.w3c.dom.ranges.RangeException;

import java.util.Scanner;

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
