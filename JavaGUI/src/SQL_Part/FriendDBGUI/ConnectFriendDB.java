package SQL_Part.FriendDBGUI;

import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

public class ConnectFriendDB {
    static Connection con = null;

    //각자 고유한 테이블 이름 설정
    static String dbTableName = "friends201655040";
    static String[] dbTableField = {"std_id", "dept", "name", "phone"};
//    public static void alterTable(String dbTableName) {
//        String alterTableSQL = "ALTER TABLE " + dbTableName + " convert to charset utf8";
//        try {
//            PreparedStatement alterTable = con.prepareStatement(alterTableSQL);
//            System.out.println("ALTER Table DK!!!");
//        } catch (SQLException e) {
//            e.printStackTrace();
//            System.out.println("ALTER Table ERROR!!!");
//        }
//    }

    public static void dropTable(String dbTableName) {
        String dropTableSQL = "DROP TABLE if exists " + dbTableName + ";";
        try {
            PreparedStatement dropTable = con.prepareStatement(dropTableSQL);
            dropTable.execute();
            System.out.println("drop table (" + dbTableName + ") ok !!!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("drop table (" + dbTableName + ") error !!!");
        }
    }

    public static void printList(ArrayList<String> list) {
        for (String item : list) {
            System.out.println(item);
        }
    }

    public static void printList2(Vector<String> list) {
        for (String item : list) {
            System.out.println(item);
        }
    }

    public static ArrayList<String> getDataFromTable(Connection con, String dbTableName) {
        String selectDataSQL = "SELECT std_id, dept, name, phone FROM " + dbTableName + ";";
        ArrayList<String> list = new ArrayList<>();

        try {
            PreparedStatement selectTable = con.prepareStatement(selectDataSQL);
            ResultSet result = selectTable.executeQuery();
            while (result.next()) {
                list.add("std_id: " + result.getInt(dbTableField[0]) + "\t" +
                        "dept: " + result.getString(dbTableField[1]) + "\t" +
                        "name: " + result.getString(dbTableField[2]) + "\t" +
                        "phone: " + result.getString(dbTableField[3])
                );
            }
            System.out.println("Select Data from DB Table " + dbTableName + " OK!!!");
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("\nSelect SQL ERROR!!!");

        }
        return null;
    }

    public static Vector<String> getDataFromTable2(Connection con, String dbTableName) {
        String selectDataSQL = "SELECT std_id, dept, name, phone FROM " + dbTableName + ";";
        Vector<String> list = new Vector<>();

        try {
            PreparedStatement selectTable = con.prepareStatement(selectDataSQL);
            ResultSet result = selectTable.executeQuery();
            while (result.next()) {
                list.add("std_id: " + result.getInt(dbTableField[0]) + "\t" +
                        "dept: " + result.getString(dbTableField[1]) + "\t" +
                        "name: " + result.getString(dbTableField[2]) + "\t" +
                        "phone: " + result.getString(dbTableField[3])
                );
            }
            System.out.println("Select Data from DB Table " + dbTableName + " OK!!!");
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("\nSelect SQL ERROR!!!");

        }
        return null;
    }


    public static Vector getDataFromTable3(Connection con, String dbTableName) {
        String selectDataSQL = "SELECT std_id, dept, name, phone FROM " + dbTableName + ";";
        Vector list = new Vector();

        try {
            PreparedStatement selectTable = con.prepareStatement(selectDataSQL);
            ResultSet result = selectTable.executeQuery();
            while (result.next()) {
                list.add("std_id: " + result.getInt(dbTableField[0]) + "\t" +
                        "dept: " + result.getString(dbTableField[1]) + "\t" +
                        "name: " + result.getString(dbTableField[2]) + "\t" +
                        "phone: " + result.getString(dbTableField[3])
                );
            }
            System.out.println("Select Data from DB Table " + dbTableName + " OK!!!");
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("\nSelect SQL ERROR!!!");
        }
        return null;
    }
//    public static void insertDataOnTable(Connection con, String dbTableName, int std_id, String dept, String name, String phone) {
//
//        String insertTableSQL = "REPLACE INTO " + dbTableName +
//                "(std_id,dept,name,phone)"+
//                "VALUES " +
//                "('" + std_id + "','" + dept "','" + name "'," + phone + ");";
//        try {
//            PreparedStatement insertTable = con.prepareStatement(insertTableSQL);
//            insertTable.executeUpdate();
//            System.out.println("Insert SQL Ok!!!");
//        } catch (SQLException e) {
//            e.printStackTrace();
//            System.out.println("\nInsert SQL ERROR!!");
//        }
//    }

    public static void insertDataOnTable(Connection con, String dbTableName, int std_id, String dept, String name, String phone) {
        String insertTableSQL = "REPLACE INTO " + dbTableName + "(std_id, dept, name, phone) values (?,?,?,?);";
        //미완성

        try {
            PreparedStatement insertTable = con.prepareStatement(insertTableSQL);
            insertTable.setInt(1, std_id);
            insertTable.setString(2, dept);
            insertTable.setString(3, name);
            insertTable.setString(4, phone);
            insertTable.executeUpdate();
            System.out.println("Insert SQL (Using statement) ok!!!");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Insert SQL (Using statement) ERROR!!!");
        }
    }

    //수정
    //1. dbTable 이름 ??
    //2. dbTable 내에 각각의 필드 구성??
    //3.
    public static void createTable(Connection con, String dbTableName) {
        String createTableSQL = "CREATE TABLE if not exists " + dbTableName + "(" +
                "std_id int not null, " +
                "dept varchar(20), " +
                "name varchar(50), " +
                "phone varchar(15), " +
                "UNIQUE INDEX (std_id), " + // 중복 삽입을 방지
                "primary key(std_id) ) default charset=utf8;";
        try {
            PreparedStatement createTable = con.prepareStatement(createTableSQL);
            createTable.executeUpdate();
            System.out.println("create table (" + dbTableName + ") ok !!!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("create table (" + dbTableName + ") error !!!");
        }
    }

    public static Connection makeConnection() throws SQLException {
        String driver = "com.mysql.cj.jdbc.Driver";
        String hostName = "sql6.freemysqlhosting.net";
        String databaseName = "sql6448156";
        String url = "jdbc:mysql://" + hostName + ":3306/" + databaseName;
        // jdbc:mysql://sql6.freemysqlhosting.net:3306/sql6448156에 접속한다는 내용
        String userName = "sql6448156";
        String password = "Tec5ucNzLn";

        try {
            Class.forName(driver);
            System.out.println("JDBC Driver Load Ok!!!\n");
            Connection con = DriverManager.getConnection(url, userName, password);
            System.out.println("DB connection Ok!!!");
            return con;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("\nClass.forName(driver) error ");
            return null;
        }
    }

    public static void deleteFromTable(Connection con, String dbTableName, int std_id) {
        PreparedStatement statement;
        String deleteSQL = "DELETE FROM " + dbTableName + " WHERE std_id = ?;";
        try {
            statement = con.prepareStatement(deleteSQL);
            statement.setInt(1, std_id);
            statement.executeUpdate();
            System.out.println("delete sql ok!!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("delete sql error!!!");
        }
    }

//    public static void deleteFromTable2(Connection con, String dbTableFieldName, String data) {
//        PreparedStatement statement;
//        String deleteSQL = "delete from books202058000 where std_id = ? ;";
//        try {
//            statement = con.prepareStatement(deleteSQL);
//            statement.setString(1, dbTableFieldName);
////            statement.setString(2, data);
//            statement.executeUpdate();
//            System.out.println("delete " + dbTableFieldName + "= " + data + " SQL ok!!");
//        } catch (SQLException e) {
//            e.printStackTrace();
//            System.out.println("delete " + dbTableFieldName + "= " + data + " SQL error!!");
//        }
//    }
//
//    public static void deleteFromTable_Year(Connection con, String data) {
//        PreparedStatement statement;
//        String deleteSQL = "delete from books202058000 where std_id = ? ;";
//        try {
//            statement = con.prepareStatement(deleteSQL);
//            statement.setString(1, data);
//            statement.executeUpdate();
//            System.out.println("delete " + data + " record SQL ok!!!");
//        } catch (SQLException e) {
//            e.printStackTrace();
//            System.out.println("delete " + data + " record SQL error!!!");
//        }
//    }
}
