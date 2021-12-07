package SQL_Part.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConnectionDB {
    static Connection con = null;

    public static void alterTable(String dbTableName) {
        String alterTableSQL = "ALTER TABLE " + dbTableName + " convert to charset utf8";
        try {
            PreparedStatement alterTable = con.prepareStatement(alterTableSQL);
            System.out.println("ALTER Table DK!!!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ALTER Table ERROR!!!");
        }
    }

    public static void dropTable(String dbTableName) {
        String dropTableSQL = "DROP TABLE if exists " + dbTableName + ";";
        try {
            PreparedStatement dropTable = con.prepareStatement(dropTableSQL);
            dropTable.execute();
            System.out.println("Drop Table OK!!!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Drop Table error!!!");
        }
    }

    public static void printList(ArrayList<String> list) {
        for (String item : list) {
            System.out.println(item);
        }
    }

    public static ArrayList<String> getDataFromTable(Connection con) {
        String selectDataSQL = "select book_id, title, publisher, year, price from books202058000;";
        ArrayList<String> list = new ArrayList<>();

        try {
            PreparedStatement seelctTable = con.prepareStatement(selectDataSQL);
            ResultSet result = seelctTable.executeQuery();

            while (result.next()) {
                list.add("BOOK_ID: " + result.getString("book_id") + "\t" +
                        "Title: " + result.getString("title") + "\t" +
                        "Publisher: " + result.getString("publisher") + "\t" +
                        "Year: " + result.getString("year") + "\t" +
                        "Price: " + result.getString("price")
                );
                System.out.println("Select Data from DB Table books202058000 OK!!!");
                return list;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("\nSelect SQL ERROR!!!");

        }
        return null;
    }
    public static void insertDataOnTable(Connection con, String title, String publisher, String year, int price) {

        String insertTableSQL = "REPLACE INTO books202058000 " +
                "VALUES "+
                "('"+title+"','"+publisher+"','"+year+"',"+price+");";
        try{
            PreparedStatement insertTable = con.prepareStatement(insertTableSQL);
            insertTable.executeUpdate();
            System.out.println("Insert SQL Ok!!!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("\nInsert SQL ERROR!!");
        }
    }
    public static void insertDataOnTable2(String title, String publisher, String year, int price) {
        String insertTableSQL = "replace into books202058000 (title, publisher, year, price) values";
        //미완성

        try{
            PreparedStatement insertTable = con.prepareStatement(insertTableSQL);
            insertTable.setString(1,title);
            insertTable.setString(2,publisher);
            insertTable.setString(3,year);
            insertTable.setInt(4,price);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Insert SQL (Using pstmt) ERROR!!!");
        }
    }
    public static void createTable(Connection con) {

    }

}
