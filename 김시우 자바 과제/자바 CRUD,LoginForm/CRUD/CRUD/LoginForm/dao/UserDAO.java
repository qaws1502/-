package dao;

import db.DBConn;
import dto.UserDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public UserDTO login(String id, String pw) {
        UserDTO user = null;
        // SQL 쿼리에 birth와 tel 컬럼 추가
        String sql = "SELECT id, pw, name, birth, tel FROM USER250522 WHERE id = ? AND pw = ?";

        try (Connection conn = DBConn.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, id);
            pstmt.setString(2, pw);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                String birth = rs.getString("birth"); // birth 값 가져오기
                String tel = rs.getString("tel");     // tel 값 가져오기
                user = new UserDTO(id, pw, name, birth, tel); // 새로운 생성자로 UserDTO 생성
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return user;
    }

    // registerUser 메서드에 birth와 tel 매개변수 추가
    public boolean registerUser(String id, String pw, String name, String birth, String tel) {
        // SQL 쿼리에 birth와 tel 컬럼 추가
        String sql = "INSERT INTO USER250522 (id, pw, name, birth, tel) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConn.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, id);
            pstmt.setString(2, pw);
            pstmt.setString(3, name);
            pstmt.setString(4, birth); // birth 값 바인딩
            pstmt.setString(5, tel);   // tel 값 바인딩

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}