package SQL_Part.FriendDBGUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

public class FriendsDBGUIFrame extends JFrame implements ActionListener, MouseListener {
    static Connection con = null;
    static String dbTableName = "friends201655040";

    public DefaultTableModel model;
    public Vector title = new Vector();
    public Vector data = new Vector();
    public Vector result = new Vector();

    public JTable table;
    public JPanel panelLow = new JPanel();

    String[] lbText = {"학번", "학과(부)명", "이름", "전화번호"};
    public JLabel[] lb = new JLabel[lbText.length];
    public JTextField[] tf = new JTextField[lbText.length];
    String[] btnText = {"삽입", "삭제", "수정", "초기화"};
    public JButton[] btn = new JButton[btnText.length];

    public FriendsDBGUIFrame() throws SQLException {
        con = ConnectFriendDB.makeConnection();
        ConnectFriendDB.createTable(con, dbTableName);
//        ConnectFriendDB.insertDataOnTable(con, dbTableName, 201655040, "컴공", "이종찬", "010-6206-1416");
//        ConnectFriendDB.insertDataOnTable(con, dbTableName, 201655041, "컴공", "이종", "010-1234-1416");
//        ConnectFriendDB.insertDataOnTable(con, dbTableName, 201655033, "컴공", "이", "010-5678-1416");
//        ConnectFriendDB.insertDataOnTable(con, dbTableName, 201655042, "comp", "LEE", "010-5678-1416");
//        ArrayList<String> list = ConnectFriendDB.getDataFromTable(con,dbTableName);
//        ConnectFriendDB.printList(list);

        Vector<String> list2 = ConnectFriendDB.getDataFromTable2(con, dbTableName);
        ConnectFriendDB.printList2(list2);
        this.setTitle("Friends DB GUI");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 400);
        title.add("학번");
        title.add("학과");
        title.add("이름");
        title.add("번호");

        result = selectFromDB(con, dbTableName);

        model = new DefaultTableModel(result, title);//data part -> list, column part -> header
        table = new JTable(model);
        JScrollPane sp = new JScrollPane(table);
        this.add(sp, BorderLayout.CENTER);

        panelLow.setLayout(new GridLayout(0, 4));

        for (int i = 0; i < lbText.length; i++) {
            lb[i] = new JLabel(lbText[i], JLabel.CENTER);
            tf[i] = new JTextField(15);
            panelLow.add(lb[i]);
            panelLow.add(tf[i]);
        }
        for (int i = 0; i < btnText.length; i++) {
            btn[i] = new JButton(btnText[i]);
            panelLow.add(btn[i]);
            btn[i].addActionListener(this);
        }

        table.addMouseListener(this);
        this.add(panelLow, BorderLayout.SOUTH);

        this.pack();
        this.setVisible(true);

    }

    private Vector selectFromDB(Connection con, String dbTableName) throws SQLException {
        String selectDataSQL = "SELECT std_id, dept, name, phone FROM " + dbTableName + ";";
        try {
            PreparedStatement selectTable = con.prepareStatement(selectDataSQL);
            ResultSet result = selectTable.executeQuery(); //해당 부분 오류가 계속 발생
            while (result.next()) {
                Vector<String> line = new Vector<>();
                line.add(result.getString("std_id"));
                line.add(result.getString("dept"));
                line.add(result.getString("name"));
                line.add(result.getString("phone"));
                data.add(line);
            }
            System.out.println(data);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("select from DB error");
        }
        return data;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn[0]) {   // 삽입 버튼 ...
            int std_id = Integer.parseInt(tf[0].getText());
            String dept = tf[1].getText();
            String name = tf[2].getText();
            String phone = tf[3].getText();

            ConnectFriendDB.insertDataOnTable(con, dbTableName, std_id, dept, name, phone);
            System.out.println("insert (actionPerformed) OK");
            result.clear();
            try {
                result = selectFromDB(con, dbTableName);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            model.setDataVector(result, title);
            resetText();

        } else if (e.getSource() == btn[1]) {
            //delete
            int std_id = Integer.parseInt(tf[0].getText());
            ConnectFriendDB.deleteFromTable(con, dbTableName, std_id);
            result.clear();
            try {
                result = selectFromDB(con, dbTableName);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            model.setDataVector(result, title);
            resetText();

        } else if (e.getSource() == btn[2]) {
            //update
            int std_id = Integer.parseInt(tf[0].getText());
            String dept = tf[1].getText();
            String name = tf[2].getText();
            String phone = tf[3].getText();
            try {
                ConnectFriendDB.updateDataOnTable(con, dbTableName, std_id, dept, name, phone);
                System.out.println("update (actionPerformed) OK");
                result.clear();
                result = selectFromDB(con, dbTableName);
                model.setDataVector(result, title);
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
                System.out.println("update (actionPerformed) ERROR");
            }
        } else if (e.getSource() == btn[3]) {
            resetText();
        } else {
            System.out.println("Invalid value");
        }
    }

    public void resetText() {
        for (JTextField text : tf) {
            text.setText("");
        }
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        int index = table.getSelectedRow();
        Vector<String> line = new Vector<>();
        line = (Vector<String>) data.get(index);
        String std_id = line.get(0);
        String dept = line.get(1);
        String name = line.get(2);
        String phone = line.get(3);

        tf[0].setText(std_id);
        tf[1].setText(dept);
        tf[2].setText(name);
        tf[3].setText(phone);
        System.out.println(dept);
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
