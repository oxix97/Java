package SQL_Part.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnOnConsole {

    public static void main(String[] args) throws SQLException {
        Connection con = null;
        con = makeConnection();
        createTable();
    }

    private static void createTable() {
        String createTableSQL = "create table if not exists books202058000("
                + "book_id INT NOT NULL auto_increment, "
                + "title VARCHAR(50), "
                + "publisher VARCHAR(50), "
                + "year VARCHAR(10), "
                + "price INT, "
                + "PRIMARY KEY(book_id));";
        Connection con;
        try {
            con = makeConnection();
            PreparedStatement createTable = con.prepareStatement(createTableSQL);
            createTable.execute();
            System.out.println("create ok!!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Create fail");
        }
    }

    private static Connection makeConnection() throws SQLException {
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
}
