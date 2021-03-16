package da;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection;
    // tao connection

    // function connection nhan vao 1 doi tuong connection để thực hiện kết nối đến database bằng package mysql
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        if(connection == null){
            // nếu chưa có kết nối sẽ thực hiện kết nối
            // gọi ra driver của thư viện
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/product","root","");
        }
        return connection;
    }

    // ham test kết nối chạy trực tiếp file để test
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        if(getConnection() != null){
            System.out.println("ket noi thanh cong");
        }
    }
}
