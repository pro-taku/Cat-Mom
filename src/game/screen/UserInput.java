package game.screen;

import org.w3c.dom.ranges.RangeException;

import java.util.Scanner;

/**
 *
 *
 * <h2>game.Display 클래스의 메소드</h2>
 *
 * <h3>입력 관련</h3>
 * <ol>
 *     <li>{@return String} {@link #input()}: 사용자의 입력을 받는다.</li>
 *     <li>{@return int} {@link  #input(int begin, int end)}: 사용자의 입력을 받는다. 범위를 지정할 수 있다.</li>
 *     <li>{@return void} {@link #waitBeforeEnter()}: 사용자가 [Enter]를 누를 때까지 대기한다.</li>
 * </ol>
 */
public class UserInput {
    private Scanner keyboard = new Scanner(System.in);

    String input() {
        System.out.printf(TextColor.yellow + "> " + TextColor.exit);
        return keyboard.nextLine();
    }

    int input(int begin, int end) {
        boolean hasError;
        int result = 0;

        do {
            hasError = false;
            System.out.printf(TextColor.yellow + "> " + TextColor.exit);
            var userInput = keyboard.nextLine();

            try {
                result = Integer.parseInt(userInput);
                if (result < begin || result > end) {
                    throw new RangeException((short) 400, "범위를 벗어난 입력입니다.");
                }
            } catch (Exception e) {
                System.out.println(TextColor.red + "잘못된 입력입니다. 다시 입력해주세요." + TextColor.exit);
                hasError = true;
            }
        } while (hasError);

        return result;
    }

    void waitBeforeEnter() {
        System.out.printf(TextColor.yellow + "(뒤로 돌아가려면 [Enter]를 누르시오...)" + TextColor.exit);
        try {
            keyboard.nextLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
