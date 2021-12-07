import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.*;
import java.awt.*;

public class ImageGallery extends JFrame implements ItemListener, ActionListener {
    JPanel rbPanel = new JPanel();
    JPanel jPanelCenter = new JPanel();
    JPanel btPanel = new JPanel();
    String[] jbTexts = {"before", "next"};
    String[] rbTexts = {"사과", "배", "체리"};
    JButton[] jButtons = new JButton[jbTexts.length];
    JRadioButton[] rb = new JRadioButton[rbTexts.length];
    ImageIcon[] icon = {
            new ImageIcon("img/apple.png"),
            new ImageIcon("img/pear.jpeg"),
            new ImageIcon("img/cherry.png"),
    };
    JLabel label = new JLabel();

    public ImageGallery() {
        setTitle("imageGallery");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ButtonGroup buttonGroup = new ButtonGroup();

        for (int i = 0; i < rb.length; i++) {
            rb[i] = new JRadioButton(rbTexts[i]);
            buttonGroup.add(rb[i]);
            rbPanel.add(rb[i]);
            rb[i].addItemListener(this);
        }
        rb[0].setSelected(true);
        for (int i = 0; i < jButtons.length; i++) {
            jButtons[i] = new JButton(jbTexts[i]);
            jButtons[i].addActionListener(this);
            btPanel.add(jButtons[i]);
        }
        jPanelCenter.add(label);
        add(jPanelCenter, BorderLayout.CENTER);
        rbPanel.setBackground(Color.GREEN);
        btPanel.setBackground(Color.CYAN);
        add(rbPanel, BorderLayout.NORTH);
        add(jPanelCenter);
        add(btPanel, BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new ImageGallery();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        for (int i = 0; i < rb.length; i++) {
            if (rb[i].isSelected()) label.setIcon(icon[i]);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int num = 0;
        for (int i = 0; i < rb.length; i++) {
            if (rb[i].isSelected()) num = i;
        }
        if (jButtons[0] == e.getSource()) {
            num = num == 0 ? 2 : --num;
            rb[num].setSelected(true);
        }
        if (jButtons[1] == e.getSource()) {
            num = ++num % 3;
            rb[num].setSelected(true);
        }
    }
}
