package Login_SQL;


import javax.sql.StatementEvent;
import javax.sql.StatementEventListener;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;
import java.util.Vector;

class TextAreaFrame extends JFrame implements ActionListener, ItemListener, ChangeListener {
    JLabel title = new JLabel("구매 물품");
    JTextField inputText = new JTextField("과일", 20);
    JButton addButton = new JButton("추가");
    JButton deleteButton = new JButton("삭제");
    JTextArea orderList = new JTextArea("주문 목록", 7, 20);
    String[] products = {"사과", "체리", "포도"};
    Vector<String> comboBoxItems = new Vector<>();
    DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(comboBoxItems);
    JComboBox<String> box = new JComboBox<>(model);
    JSlider slider = new JSlider(JSlider.HORIZONTAL,0,100,50);
    String[] rbText = {"포장","배달","직송"};
    JRadioButton[] rb = new JRadioButton[rbText.length];
    public TextAreaFrame() {
        setTitle("Text Area Example");
        setSize(300, 350);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());
        addButton.addActionListener(this);
        deleteButton.addActionListener(this);
        add(title);
        add(inputText);
        add(addButton);
        add(deleteButton);

        add(new JScrollPane(orderList));
        for (String product : products) {
            model.addElement(product);
        }
        add(box);

        add(slider);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            orderList.append("ffff");
        }
        if (e.getSource() == deleteButton) {

        }
    }

    @Override
    public void itemStateChanged(ItemEvent itemEvent) {

    }

    @Override
    public void stateChanged(ChangeEvent e) {

    }
}

class LoginPanel extends JPanel implements ActionListener {
    String[] strings = {"Login ID :", "Password :"};
    JLabel[] labels = new JLabel[strings.length];
    JTextField idField = new JTextField(10);
    JPasswordField pwField = new JPasswordField(10);
    JButton loginButton = new JButton("Login");

    String id = "aa";
    String pw = "1";

    public LoginPanel() {
        setLayout(new GridLayout(0, 2));
        labels[0] = new JLabel(strings[0]);
        labels[1] = new JLabel(strings[1]);
        add(labels[0]);
        add(idField);
        add(labels[1]);
        add(pwField);
        add(new JLabel(""));
        add(loginButton);
        loginButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String password = new String(pwField.getPassword());
        if (e.getSource() == loginButton) {
            //pwField인 경우 getText() 보다는
            if (id.equals(idField.getText()) && pw.equals(password)) {
                JOptionPane.showMessageDialog(null, "Login Successful");
                TextAreaFrame frame = new TextAreaFrame();
            } else {
                JOptionPane.showMessageDialog(null, "Login Failed");
            }
            idField.setText("");
            pwField.setText("");
        }
    }
}

public class TextAreaWithLogin extends JFrame {
    JPanel LoginPanel = new LoginPanel();

    public TextAreaWithLogin() {
        setTitle("Login Frame");
        setSize(300, 125);
        //여러창을 띄워도 남아있게끔
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());
        add(LoginPanel);
        setVisible(true);
    }
}
