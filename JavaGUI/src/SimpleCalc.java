import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Frame extends JFrame implements ActionListener, ItemListener {
    JPanel panel = new JPanel(new FlowLayout());
    JButton[] numButton = new JButton[11];
    String[] text = {"7", "8", "9", "4", "5", "6", "1", "2", "3", "0", "."};
    JPanel numPanel = new JPanel(new GridLayout(0, 3));
    JLabel[] labels = new JLabel[2];
    String[] labelText = {"원금을 입력하시오", "이율을 입력하시오"};
    JTextField[] textFields = new JTextField[3];
    int[] fieldSize = {10, 10, 20};
    JButton[] button = new JButton[2];
    String[] buttonText = {"변환", "리셋"};
    JRadioButton selectRB = new JRadioButton("RadioButton -> [On : 원금] / [Off : 이율]");
    int state = 0;

    Frame() {
        setSize(500, 400);
        setTitle("과제");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        for (int i = 0; i < labels.length; i++) {
            labels[i] = new JLabel(labelText[i]);
        }
        for (int i = 0; i < textFields.length; i++) {
            textFields[i] = new JTextField(fieldSize[i]);
        }
        for (int i = 0; i < button.length; i++) {
            button[i] = new JButton(buttonText[i]);
        }
        selectRB.setSelected(true);
        selectRB.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                if (selectRB.isSelected()) {
                    selectRB.setText("RadioButton Selected : 원금 입력");
                } else {
                    selectRB.setText("Radiobutton Unselected : 이름 입력");
                }
            }
        });
        for (int i = 0; i < numButton.length; i++) {
            numButton[i] = new JButton(text[i]);
            numPanel.add(numButton[i]);
            numButton[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    JButton btn = (JButton) actionEvent.getSource();
                    if (selectRB.isSelected()) {
                        textFields[0].setText(textFields[0].getText() + btn.getText());
                    } else {
                        textFields[1].setText(textFields[1].getText() + btn.getText());
                    }
                }
            });
        }
        numPanel.add(selectRB);

        panel.add(labels[0]);
        panel.add(textFields[0]);
        panel.add(labels[1]);
        panel.add(textFields[1]);
        panel.add(button[0]);
        panel.add(textFields[2]);
        panel.add(button[1]);

        button[0].addActionListener(this);
        button[1].addActionListener(this);

        add(panel, BorderLayout.NORTH);
        add(numPanel, BorderLayout.CENTER);

        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button[0]) {
            System.out.println("button 0 click");
            float value = Float.parseFloat(textFields[0].getText()) * Float.parseFloat(textFields[1].getText());
            System.out.println("value");
            textFields[2].setText("" + value);
        }
        if (e.getSource() == button[1]) {
            System.out.println("Button 1 click");
            for (JTextField textField : textFields) {
                textField.setText("");
            }
        }
        for (int i = 0; i < numButton.length; i++) {
            if (e.getSource() == numButton[i]) {
                textFields[state].setText(textFields[state].getText() + text[i]);
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (selectRB.isSelected()) {
            state = 0;
        } else {
            state = 1;
        }
    }
}

public class SimpleCalc {
    public static void main(String[] args) {
        new Frame();
    }
}
