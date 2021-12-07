package SQL_Part;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

class DBConnOnConsoleUpdated {
    static Connection con = null; //// 이동 ...

    public static void main(String[] args) throws SQLException {
        // TODO Auto-generated method stub
        //Connection con = null;   // 주석처리, 필드 값으로 변경/이동
        con = makeConnection();    // 1단계 : DB 연결
        // 업데이트 내용 : 입력중복 방지, 한글 지원 !!! dropTable, alterTable, insert Function(New), makeConnection 등...
        //*****************
        dropTable("books202058000");     /// 추가한 다음에 --> 다시 주석처리하면 됨... !!!
        //*****************
        createTable();             // 2단계 : DB 내 Table "books202058000" 생성
        //*****************
        //alterTable("books202058000");  //*** create table 과정에서 default charset=utf8; 추가...
        //*****************
        //***************** 이후 콘솔창에서 깨짐현상 --> Run -> Run Configuration : Common --> other/UTF-8 변경!!!

        // 단, 데이블 이름은 각 학생마다 다르게 생성!!!
        // 3단계 : DB Table "books202058000"에 레코드 입력(insert) 질의 실행
        insertDataOnTable("Python", "Hanshin", "2021", 10000);
        insertDataOnTable("자바", "생능출판사", "2000", 20000);
        insertDataOnTable("홍길동", "Com. Eng.", "2013", 10000);

        insertDataOnTable2("Lee SS", "Com. Eng.", "2015", 10000);
        //*************** 한글 지원 ???
        insertDataOnTable2("강감찬", "컴퓨터공학", "2019", 10000);
        insertDataOnTable2("이순신", "컴퓨터공학", "2019", 10000);

        // 4단계 : DB Table에 저장된 레코드 내용 읽어오기(select) 질의 실행
        ArrayList<String> list = getDataFromTable();
        // 5단계 : 읽어온 내용 콘솔에 출력하기
        printList(list);
    }

    private static void alterTable(String dbTableName) {
        // TODO Auto-generated method stub
        String alterTableSQL = "ALTER TABLE " + dbTableName + " convert to charset utf8;" ;

        try {
            PreparedStatement alterTable = con.prepareStatement(alterTableSQL);
            alterTable.execute();
            System.out.println("ALTER Table OK!!!");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("ALTER Table ERROR!!!");
        }
    }

    //*****************
    private static void dropTable(String dbTableName) {
        // TODO Auto-generated method stub
        String dropTableSQL = "DROP TABLE if exists " + dbTableName + ";" ;

        try {
            PreparedStatement dropTable = con.prepareStatement(dropTableSQL);
            dropTable.execute();
            System.out.println("Drop Table OK!!!");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Drop Table ERROR!!!");
        }


    }

    private static void printList(ArrayList<String> list) {
        // TODO Auto-generated method stub
        for (String record: list) {
            System.out.println(record);
        }
    }

    private static ArrayList<String> getDataFromTable() {
        // TODO Auto-generated method stub
        String selectDataSQL = "select book_id, title, publisher, year, price from books202058000;" ;
        ArrayList<String> retList = new ArrayList<String>();
        try {
            PreparedStatement selectData = con.prepareStatement(selectDataSQL);
            ResultSet result = selectData.executeQuery();
            while (result.next()) {
                retList.add("Book_id: " + result.getString("Book_id") + "\t" +  //*******
                        " Title: " + result.getString("title") + "\t" + //*******
                        " Publisher: " + result.getString("Publisher") + "\t" + //*******
                        " Year: " + result.getString("year") + "\t" + //*******
                        " Price: " + result.getString("price")
                );
            }
            System.out.println("Select SQL OK!!!");
            return retList;


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Select SQL ERROR!!!");
        }

        return null;
    }

    private static void insertDataOnTable(String title, String publisher, String year, int price) {
        // TODO Auto-generated method stub
        //*****************
        String insertTableSQL = "replace into books202058000 " +        // insert --> replace 변경!!!
                " (title, publisher, year, price) " +
                " values " +
                " ('"+title+"', '"+publisher+"', '"+year+"', "+price+");" ;

        try {
            PreparedStatement insertTable = con.prepareStatement(insertTableSQL);
            insertTable.executeUpdate();   /// 주의 : insert --> executeUpdate() call!!!
            System.out.println("Insert SQL OK!!!");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Insert SQL ERROR!!!");
        }

    }

    //*****************
    private static void insertDataOnTable2(String title, String publisher, String year, int price) throws SQLException {
        // TODO Auto-generated method stub
        String insertTableSQL = "replace into books202058000 (title, publisher, year, price) values(?,?,?,?);" ;
        try {
            PreparedStatement insertTable = con.prepareStatement(insertTableSQL);

            insertTable.setString(1, title);
            insertTable.setString(2, publisher);
            insertTable.setString(3, year);
            insertTable.setInt(4, price);

            insertTable.executeUpdate();
            System.out.println("Insert SQL (Using pstmt) OK!!!");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Insert SQL (Using pstmt) ERROR!!!");
        }


    }

    //***************** unique index 라인 추가...
    private static void createTable() {
        // TODO Auto-generated method stub
        // books202058000  --> 학생마다 본인의 books학번 형태의 테이블 생성...
        //*****************
        String createTableSQL = "create table if not exists books202058000 (" +
                "book_id INT NOT NULL auto_increment, " +
                "title VARCHAR(50), " +
                "publisher VARCHAR(50), " +
                "year VARCHAR(10), " +
                "price INT, " +
                "UNIQUE INDEX (title), " +     //***** 중복 삽입 방지를 위해.. 중복 검사용 필드 추가...
                "PRIMARY KEY(book_id) ) default charset=utf8;" ;  //***** default charset=utf8; 추

        try {
            //Connection con;     // 주석처리...
            //con = makeConnection();  // 주석처리...
            PreparedStatement createTable = con.prepareStatement(createTableSQL);
            createTable.execute();
            System.out.println("Create Table books202058000 OK!!!");

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    // MySQL DB Connection
    private static Connection makeConnection() throws SQLException {
        // TODO Auto-generated method stub
        String driver = "com.mysql.cj.jdbc.Driver";
        //String hostName = "localhost";    // 만일 본인의 pc 내.... mysql 접속...
        String hostName = "sql6.freemysqlhosting.net";
        String databaseName = "sql6448156";
        //**************
        String utf8Connection = "?useUnicode=true&characterEncoding=utf8";
        //**************
        String url = "jdbc:mysql://"+hostName+":3306/"+databaseName + utf8Connection;
        // --> jdbc:mysql://sql6.freemysqlhosting.net:3306/sql6448156?useUnicode=true&characterEncoding=utf8
        String userName = "sql6448156";
        String password = "Tec5ucNzLn";

        try {
            Class.forName(driver);
            System.out.println("JDBC Driver Load OK!!!");
            //Connection con = DriverManager.getConnection(url, userName, password);
            con = DriverManager.getConnection(url, userName, password);
            System.out.println("DB Connection OK!!");
            return con;

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("\nError : Class.forName(driver)\n");
            return null;
        }

    }

}