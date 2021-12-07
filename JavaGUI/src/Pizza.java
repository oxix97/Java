import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class WelcomePanel extends JPanel {
    JLabel title = new JLabel("자바 피자");

    WelcomePanel() {
        add(title);
        setBackground(Color.LIGHT_GRAY);
        setLayout(new FlowLayout());
    }
}

class TypePanel extends JPanel {
    String[] items = {"콤보", "포테이토", "불고기"};
    JRadioButton[] rb = new JRadioButton[items.length];
    int[] typeCost = {3000, 4000, 5000};

    TypePanel() {
        setLayout(new GridLayout(0, 1));
        setBackground(Color.CYAN);
        setBorder(BorderFactory.createTitledBorder("종류"));
        ButtonGroup buttonGroup = new ButtonGroup();
        for (int i = 0; i < rb.length; i++) {
            rb[i] = new JRadioButton(items[i]);
            add(rb[i]);
            buttonGroup.add(rb[i]);
        }
    }

    public int calc() {
        for (int i = 0; i < rb.length; i++) {
            if (rb[i].isSelected()) {
                return typeCost[i];
            }
        }
        return 0;
    }
}

class ToppingPanel extends JPanel {
    String[] items = {"피망", "치즈", "페퍼로니", "베이컨"};
    JCheckBox[] box = new JCheckBox[items.length];
    int[] toppingCost = {300, 400, 500, 600};

    ToppingPanel() {
        setLayout(new GridLayout(0, 1));
        setBorder(BorderFactory.createTitledBorder("추가 토핑"));
        for (int i = 0; i < box.length; i++) {
            box[i] = new JCheckBox(items[i]);
            add(box[i]);
        }
    }

    public int calc() {
        int totalPrice = 0;
        for (int i = 0; i < box.length; i++) {
            if (box[i].isSelected()) {
                totalPrice += toppingCost[i];
            }
        }
        return totalPrice;
    }
}

class SizePanel extends JPanel {
    String[] items = {"S", "M", "L"};
    JRadioButton[] rb = new JRadioButton[items.length];
    int[] sizeCost = {0, 4000, 6000};

    SizePanel() {
        setBorder(BorderFactory.createTitledBorder("크기"));
        setLayout(new GridLayout(0, 1));
        ButtonGroup buttonGroup = new ButtonGroup();
        for (int i = 0; i < rb.length; i++) {
            rb[i] = new JRadioButton(items[i]);
            add(rb[i]);
            buttonGroup.add(rb[i]);
        }
    }

    public int calc() {
        for (int i = 0; i < rb.length; i++) {
            if (rb[i].isSelected()) {
                return sizeCost[i];
            }
        }
        return 0;
    }
}

public class Pizza extends JFrame implements ActionListener {
    JPanel[] panels = new JPanel[5];
    String[] items = {"주문", "취소"};
    JButton[] bt = new JButton[items.length];

    Pizza() {
        setTitle("My Pizza");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        panels[0] = new WelcomePanel();
        panels[1] = new TypePanel();
        panels[2] = new ToppingPanel();
        panels[3] = new SizePanel();
        panels[4] = new JPanel();
        for (int i = 0; i < bt.length; i++) {
            bt[i] = new JButton(items[i]);
            panels[4].add(bt[i]);
            bt[i].addActionListener(this);
        }
        add(panels[0], BorderLayout.NORTH);
        add(panels[1], BorderLayout.WEST);
        add(panels[2], BorderLayout.CENTER);
        add(panels[3], BorderLayout.EAST);
        add(panels[4], BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new Pizza();
    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//
//    }

    @Override
    public void actionPerformed(ActionEvent e) {
        TypePanel tp = (TypePanel) panels[1];
        ToppingPanel topping = (ToppingPanel) panels[2];
        SizePanel size = (SizePanel) panels[3];
        WelcomePanel title = (WelcomePanel) panels[0];
        int price = tp.calc() + topping.calc() + size.calc();
        if (e.getSource() == bt[0]) {
            System.out.println(price);
            title.title.setText("가격은 : "+ price + "입니다.");
        }
        if (e.getSource() == bt[1]) {
            title.title.setText("자바 피자");
        }
    }
}

//콤보 3000
//포테이토 4000
//불고기 5000
// 피망 + 300 , 치즈 + 400, 페퍼로니 + 500, 베이컨 + 600,
//크기 S+ 0, M + 1000, L+2000
