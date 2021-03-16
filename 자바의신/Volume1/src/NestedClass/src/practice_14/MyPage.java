package NestedClass.src.practice_14;

public class MyPage {

    InputBox input;

    public static void main(String[] args) {
        MyPage myPage = new MyPage();
        myPage.setUI();
        myPage.pressKey();
    }

    public void pressKey() {
        input.listenerCalled(InputBox.KEY_DOWN);
        input.listenerCalled(InputBox.KEY_UP);
    }

    public void setUI() {
        input = new InputBox();
        KeyEventListener listener = new KeyEventListener() {

            @Override
            public void onKeyDown() {
                System.out.println("Key Down");
            }

            @Override
            public void onKeyUp() {
                System.out.println("Key Up");
            }
        };
        input.setListener(listener);
    }
}
