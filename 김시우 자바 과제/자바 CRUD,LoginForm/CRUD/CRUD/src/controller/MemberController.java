package controller;

import java.sql.*;
import java.util.ArrayList;

import db.DBConn;
import model.Member; // Changed Model to Member

public class MemberController { // Renamed to MemberController

    public MemberController() {
        // Connection is now obtained per method call using DBConn.getConnection()
        // No need to establish connection in constructor for this pattern
    }

    // 회원 추가
    public void insertMember(Member member) { // Changed Model to Member
        String sql = "INSERT INTO user2505229 (name, birth, tel) VALUES (?, ?, ?)";
        try (Connection conn = DBConn.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, member.getName());
            pstmt.setString(2, member.getBirth());
            pstmt.setString(3, member.getTel());

            pstmt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 회원 목록 출력
    public ArrayList<Member> readMember() { // Changed Model to Member
        ArrayList<Member> arr = new ArrayList<>();
        String sql = "SELECT * FROM user2505229";
        try (Connection conn = DBConn.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                arr.add(new Member(rs.getString("name"), rs.getString("birth"), rs.getString("tel")));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return arr;
    }

    // 회원수정
    public void updateMember(String name, String tel) {
        String sql = "UPDATE user2505229 SET tel = ? WHERE name = ?";
        try (Connection conn = DBConn.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, tel);
            pstmt.setString(2, name);

            pstmt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 회원삭제
    public void deleteMember(String name) {
        String sql = "DELETE FROM user2505229 WHERE name = ?";
        try (Connection conn = DBConn.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);

            pstmt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 회원 검색
    public ArrayList<Member> searchMember(String content) { // Changed Model to Member
        ArrayList<Member> arr = new ArrayList<>();
        String sql = "SELECT * FROM user2505229 WHERE name LIKE ?";
        try (Connection conn = DBConn.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, "%" + content + "%");

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                arr.add(new Member(rs.getString("name"), rs.getString("birth"), rs.getString("tel")));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return arr;
    }

    // 특정 회원의 정보 가져오기 (for non-admin users)
    public ArrayList<Member> getMemberByUserName(String userName) {
        ArrayList<Member> arr = new ArrayList<>();
        String sql = "SELECT * FROM user2505229 WHERE name = ?";
        try (Connection conn = DBConn.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, userName);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                arr.add(new Member(rs.getString("name"), rs.getString("birth"), rs.getString("tel")));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return arr;
    }
}