package game.terminal.event;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

public class Controller implements NativeKeyListener {
    private static boolean initialized = false;

    public static boolean nowListening = false;

    private final SelectingOptionCallback callback;

    public Controller(SelectingOptionCallback callback) {
        this.callback = callback;
        if (initialized) return;

        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException e) {
            System.out.println("There was a problem registering the native hook.");
            System.out.println(e.getMessage());
            System.exit(1);
        }

        GlobalScreen.addNativeKeyListener(this);
        initialized = true;
    }

    public boolean getNowListening() {
        return nowListening;
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        if (!nowListening) return;

        switch (e.getKeyCode()) {
            // 이전 메뉴로
            case NativeKeyEvent.VC_UP:
            case NativeKeyEvent.VC_LEFT:
                callback.previous();
                break;
            // 다음 메뉴로
            case NativeKeyEvent.VC_DOWN:
            case NativeKeyEvent.VC_RIGHT:
                callback.next();
                break;
            // 선택
            case NativeKeyEvent.VC_SPACE:
                callback.select();
                break;
        }
    }
}
