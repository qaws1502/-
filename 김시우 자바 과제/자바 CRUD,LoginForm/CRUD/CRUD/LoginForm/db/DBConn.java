package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        final String driver = "org.mariadb.jdbc.Driver";
        final String DB_IP = "localhost";
        final String DB_PORT = "3306";
        final String DB_NAME = "member";
        final String DB_URL =
                "jdbc:mariadb://" + DB_IP + ":" + DB_PORT + "/" + DB_NAME + "?allowPublicKeyRetrieval=true&useSSL=false&autoReconnect=true&failOverReadOnly=false&maxReconnects=10&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&useGSSAPI=false";

        Class.forName(driver);
        // 비밀번호를 '1234'에서 '1502'로 수정하세요!
        Connection conn = DriverManager.getConnection(DB_URL, "root", "1502"); // 여기를 '1502'로!
        if (conn != null) {
            System.out.println("DB 접속 성공");
        }
        return conn;
    }
}