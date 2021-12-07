import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.GridLayout;

class MyFrame extends JFrame {
    JButton[] btnArray = new JButton[6];
    String[] arrText = {"입금","출금","계좌이체","거래내역조회","잔액조회","종료"};
    MyFrame(){
        this.setSize(300,200);

        this.setLayout(new GridLayout(3,2));

        for (int i = 0; i < btnArray.length; i++) {
            btnArray[i] = new JButton(arrText[i]);
            this.add(btnArray[i]);
        }
        this.setVisible(true);
    }
}

public class MyButton {

    public static void main(String[] args) {
//        MyFrame myFrame = new MyFrame();
    }
}
