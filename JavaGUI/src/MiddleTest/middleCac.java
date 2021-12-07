package MiddleTest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// 위에 BorderLayout
// 하단 GridLayout
// JLabel.center 정렬
// reset -> 감사합니다 다시 주문해주세요
// 클릭시 -> 고객님의 주분번호는 n번 입니다.
//setTitle -> 본인의 학번
//프로젝트 -> 201655040이종찬

class TopPanel extends JPanel {
    JLabel title = new JLabel("자바 피자에 오신것을 환영합니다.");

    TopPanel() {
        add(title);
        setLayout(new FlowLayout());
    }
}

class TypePanel extends JPanel {
    String[] items = {"콤보(25,000원)", "나폴리(19,000원)", "포테이토(22,000원)", "불고기(20,000원)"};
    JRadioButton[] rb = new JRadioButton[items.length];
    int[] typeCost = {25000, 19000, 22000, 20000};

    TypePanel() {
        setLayout(new GridLayout(0, 1));
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
    String[] items = {"피망(1,000원)", "치즈(1,500원)", "페퍼로니(2,000원)", "베이컨(2,500원)", "옥수수(1,000원)"};
    JCheckBox[] box = new JCheckBox[items.length];
    int[] toppingCost = {1000, 1500, 2000, 2500, 1000};

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
    String[] items = {"Small(기본)", "Medium(3,000)", "Large(5,000)"};
    JRadioButton[] rb = new JRadioButton[items.length];
    int[] sizeCost = {0, 3000, 5000};

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

class BottomFrame extends JPanel implements ActionListener {
    String[] text = {
            "주문금액(Sub Total) :",
            "부가가치세(Tax : 10%) :",
            "총 합 계 (Total Sum) :",
            "현금 수령액(Cash) :",
            "거스름돈(Change) :",
    };
    JLabel[] labels = new JLabel[text.length];
    TextField[] textFields = new TextField[text.length];
    JButton charge = new JButton();

    BottomFrame() {
        setBorder(BorderFactory.createTitledBorder("계산"));
        setLayout(new GridLayout(5, 2));
        for (int i = 0; i < text.length - 1; i++) {
            labels[i] = new JLabel(text[i], JLabel.CENTER);
            textFields[i] = new TextField(i);
            add(labels[i]);
            add(textFields[i]);
        }
        charge = new JButton("거스름돈 (Charge)");
        textFields[4] = new TextField();
        charge.addActionListener(this);
        add(charge);
        add(textFields[4]);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (charge == e.getSource()) {
            if (textFields[3].getText().equals("")) {
                String cashStr = JOptionPane.showInputDialog("현금을 입력하세요!!");
                if (cashStr != null) {
                    textFields[3].setText(cashStr);
                }
            } else {
                Double charge = Double.parseDouble(textFields[3].getText())
                        - Double.parseDouble(textFields[2].getText());
                textFields[4].setText(charge.toString());
            }
        }
    }
}

public class middleCac extends JFrame implements ActionListener {
    JPanel top = new JPanel(new BorderLayout());
    JPanel bottom = new JPanel();
    JPanel[] panels = new JPanel[6];
    String[] items = {"주문", "취소"};
    JButton[] bt = new JButton[items.length];
    static int orderCount = 0;

    middleCac() {
        setTitle("My middleCac");
        panels[0] = new TopPanel();
        panels[1] = new TypePanel();
        panels[2] = new ToppingPanel();
        panels[3] = new SizePanel();
        panels[4] = new JPanel();
        panels[5] = new BottomFrame();
        for (int i = 0; i < bt.length; i++) {
            bt[i] = new JButton(items[i]);
            panels[4].add(bt[i]);
            bt[i].addActionListener(this);
        }
        top.add(panels[0], BorderLayout.NORTH);
        top.add(panels[1], BorderLayout.WEST);
        top.add(panels[2], BorderLayout.CENTER);
        top.add(panels[3], BorderLayout.EAST);
        top.add(panels[4], BorderLayout.SOUTH);
        bottom.add(panels[5]);
        setLayout(new GridLayout(0, 1));
        setSize(450, 400);
        add(top);
        add(bottom);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new middleCac();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        TypePanel tp = (TypePanel) panels[1];
        ToppingPanel topping = (ToppingPanel) panels[2];
        SizePanel size = (SizePanel) panels[3];
        TopPanel title = (TopPanel) panels[0];
        BottomFrame bottom = (BottomFrame) panels[5];
        String price = (String.valueOf(tp.calc() + topping.calc() + size.calc()));
        Double tax = Double.parseDouble(price) / 10.0;
        if (e.getSource() == bt[0]) {
            title.title.setText("고객님의 주문번호는 " + ++orderCount + "번 입니다.");
            bottom.textFields[0].setText(price);
            bottom.textFields[1].setText("" + Double.parseDouble(price) / 10.0);
            bottom.textFields[2].setText(Double.parseDouble(price) + tax + "");
        }
        if (e.getSource() == bt[1]) {
            title.title.setText("감사합니다. 다시 주문해 주세요.");
        }
    }
}
