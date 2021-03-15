package NestedClass.src;

public class AnonymousEx {
    public static void main(String[] args) {
        AnonymousEx ex = new AnonymousEx();
        ex.setButtonListener();
        ex.setButtonListenerAnonymous();
    }

    public void setButtonListenerAnonymous() {
        ButtonClass button = new ButtonClass();
        EventListener listener = new EventListener() {
            public void onClick(){
                System.out.println("Button Clicked");
            }
        };
        button.setListener(listener);
        button.onClickProcess();
    }

    public void setButtonListener() {
        ButtonClass button = new ButtonClass();
        button.setListener(new EventListener() {
            @Override
            public void onClick() {
                System.out.println("Button Clicked");
            }
        });
        button.onClickProcess();
    }
}
