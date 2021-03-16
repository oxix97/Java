package NestedClass.src.practice_14;

public class InputBox {
    public InputBox() {

    }
    public static final int KEY_DOWN = 2;
    public static final int KEY_UP = 4;
    KeyEventListener listener;

    public void setListener(KeyEventListener listener) {
        this.listener = listener;
    }

    public void listenerCalled(int eventType) {
        if (eventType == KEY_UP) {
            listener.onKeyUp();
        } else if (eventType == KEY_DOWN) {
            listener.onKeyDown();
        }
    }
}
