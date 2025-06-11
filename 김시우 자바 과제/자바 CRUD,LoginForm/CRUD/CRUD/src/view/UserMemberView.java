package view;

import dto.UserDTO;

import javax.swing.*;

public class UserMemberView extends JFrame {
    private JTextArea ta = new JTextArea();

    public UserMemberView(UserDTO user) {
        setTitle(user.getName() + "님의 정보");
        setBounds(100, 100, 400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        add(panel);

        JScrollPane jsp = new JScrollPane(ta);
        jsp.setBounds(20, 20, 350, 230);
        panel.add(jsp);

        displayUserMember(user);
    }

    private void displayUserMember(UserDTO user) {
        ta.setText("");

        // --- 디버그용 로그 추가 시작 ---
        System.out.println("UserMemberView: displayUserMember 호출됨");
        if (user == null) {
            System.out.println("UserMemberView: UserDTO 객체가 null 입니다.");
        } else {
            System.out.println("UserMemberView: UserDTO 정보 - ID: " + user.getId() + ", 이름: " + user.getName() +
                               ", 생년월일: " + user.getBirth() + ", 전화번호: " + user.getTel());
        }
        // --- 디버그용 로그 추가 끝 ---

        if (user == null) {
            ta.append("회원 정보가 없습니다.\n");
            return;
        }

        ta.append("\t" + "ID" + "\t" + "이름" + "\t" + "생년월일" + "\t" + "전화번호\n");
        ta.append("\t" + "--------------------------------------------------------------------------------------\n");

        ta.append(String.format("\t%-10s\t%-10s\t%-10s\t%-15s\n",
                user.getId(), user.getName(), user.getBirth(), user.getTel()));
    }
}