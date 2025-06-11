package dao;

import db.DBConn;
import dto.UserDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
    public UserDTO login(String id, String pw) {
        UserDTO user = null;
        String sql = "SELECT * FROM USER250522 WHERE id = ? AND pw = ?";

        try (Connection conn = DBConn.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, id);
            pstmt.setString(2, pw);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                user = new UserDTO(id, pw, name);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }
}
