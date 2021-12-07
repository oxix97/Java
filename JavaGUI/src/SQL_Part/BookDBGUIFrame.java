package SQL_Part;

import SQL_Part.DBConnection.ConnectionDB;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BookDBGUIFrame extends JFrame implements ActionListener {

    static Connection con = null;
    String[] labelText = {"ID","Title","Publisher","Year","Price"};
    JLabel[] label = new JLabel[labelText.length];
    JTextField[] tf = new JTextField[labelText.length];
    String[] btnText = {"Previous","Next","Insert","Delete","Reset","Sorting"};
    JButton[] btn = new JButton[btnText.length];
    String[] dbTableFieldName = {"book_id","title","publisher","year","price"};

    PreparedStatement statement;
    ResultSet result;

    public BookDBGUIFrame() {
//        con = ConnectionDB.makeConnection();
        ConnectionDB.createTable(con);
        ArrayList<String> list = ConnectionDB.getDataFromTable(con);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
