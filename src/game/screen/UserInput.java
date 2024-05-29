package game.screen;

import org.w3c.dom.ranges.RangeException;

import java.io.*;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

/**
 *
 *
 * <h2>game.Display 클래스의 메소드</h2>
 *
 * <h3>입력 관련</h3>
 * <ol>
 *     <li>{@return String} {@link #setName()}: 사용자의 입력을 받는다.</li>
 *     <li>{@return int} {@link  #setNumber(int begin, int end)}: 사용자의 입력을 받는다. 범위를 지정할 수 있다.</li>
 *     <li>{@return void} {@link #waitBeforePressingAny()}: 사용자가 [Enter]를 누를 때까지 대기한다.</li>
 * </ol>
 */
public class UserInput implements NativeKeyListener {
    final BufferedReader reader;

    private String oneLine;
    private Integer oneData;
    boolean hasError;

    InputEventType type;
    boolean waitingForListener;
    KeyboardListenCallback callback;

    public UserInput(KeyboardListenCallback callback) {
        reader = new BufferedReader(new InputStreamReader(System.in));

        oneLine = null;
        oneData = null;
        hasError = false;

        waitingForListener = false;
        type = InputEventType.none;
        this.callback = callback;

        try {
            GlobalScreen.registerNativeHook();
        }
        catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());

            System.exit(1);
        }

        GlobalScreen.addNativeKeyListener(this);
    }

    public void nativeKeyReleased(NativeKeyEvent e) {
        if (!waitingForListener) return;

        if (type == InputEventType.waiting) {
//            System.out.println("called release when waiting");
            type = InputEventType.none;
            waitingForListener = false;
        }

        if (type == InputEventType.arrow) {
            switch (e.getKeyCode()) {
                case NativeKeyEvent.VC_UP :
                case NativeKeyEvent.VC_LEFT:
                    oneData = 1;
                    callback.changeMenuItem(oneData);
                    break;
                case NativeKeyEvent.VC_DOWN:
                case NativeKeyEvent.VC_RIGHT:
                    oneData = -1;
                    callback.changeMenuItem(oneData);
                    break;
                case NativeKeyEvent.VC_ENTER:
                    oneData = 0;
                    type = InputEventType.none;
                    waitingForListener = false;
                    break;
            }
        }
    }

    private void clearReaderBuffer() throws IOException {
        while (reader.ready()) reader.read();
    }

    String setName() {
        do {
            try {
                hasError = false;
                System.out.print("> ");
                oneLine = reader.readLine();
            } catch (Exception e) {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                hasError = true;
            }
        } while(hasError);
        return oneLine;
    }

    int setNumber(int begin, int end) {
        int result = 0;
        do {
            try {
                hasError = false;
                System.out.print("> ");
                oneLine = reader.readLine();

                result = Integer.parseInt(oneLine);
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

    void waitBeforePressingAny() {
        System.out.println("(뒤로 돌아가려면 아무 키나 누르시오...)");
        type = InputEventType.waiting;
        try {
            Thread.sleep(100);
            waitingForListener = true;
            while (type == InputEventType.waiting) {
                Thread.sleep(100);
            }
            clearReaderBuffer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void selectMenuItem() {
        type = InputEventType.arrow;
        try {
            Thread.sleep(100);
            waitingForListener = true;
            while (type == InputEventType.arrow) {
                Thread.sleep(100);
            }
            clearReaderBuffer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}