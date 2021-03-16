package NestedClass.src;

public class ButtonClass {
    private EventListener listener;

    public ButtonClass() {

    }

    public void setListener(EventListener listener) {
        this.listener = listener;
    }

    public void onClickProcess() {
        if (listener != null) {
            listener.onClick();
        }
    }
}
