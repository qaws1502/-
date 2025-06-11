package form;

import dao.UserDAO;
import dto.UserDTO;
import view.MemberManagementView;
import view.UserMemberView; // Import the new UserMemberView

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {
    private JTextField idField;
    private JPasswordField pwField;
    private JButton loginButton;
    private JButton registerButton;

    public LoginForm() {
        setTitle("Login Form");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel);

        setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("User ID:");
        userLabel.setBounds(10, 10, 80, 25);
        panel.add(userLabel);

        idField = new JTextField(20);
        idField.setBounds(100, 10, 160, 25);
        panel.add(idField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 40, 80, 25);
        panel.add(passwordLabel);

        pwField = new JPasswordField(20);
        pwField.setBounds(100, 40, 160, 25);
        panel.add(pwField);

        loginButton = new JButton("Login");
        loginButton.setBounds(10, 80, 250, 25);
        panel.add(loginButton);

        registerButton = new JButton("회원가입");
        registerButton.setBounds(10, 120, 250, 25);
        panel.add(registerButton);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                String pw = new String(pwField.getPassword());

                UserDAO dao = new UserDAO();
                UserDTO user = dao.login(id, pw); // UserDTO에 birth, tel 정보도 담겨있음

                if (user != null) {
                    JOptionPane.showMessageDialog(null, "로그인 성공! 환영합니다!");
                    dispose();

                    if ("admin".equals(user.getId())) {
                        new MemberManagementView(); // 관리자용 회원 관리 뷰
                    } else {
                        // UserMemberView에 UserDTO 객체 자체를 전달하도록 변경
                        new UserMemberView(user); // user 객체를 통째로 넘김
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "로그인 실패! ID 또는 비밀번호를 확인하세요.");
                }
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UserRegisterForm();
            }
        });
    }
}