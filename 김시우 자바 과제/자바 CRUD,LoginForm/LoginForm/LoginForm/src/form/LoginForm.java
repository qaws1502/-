package form;

import dao.UserDAO;
import dto.UserDTO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {
    private JTextField idField;
    private JPasswordField pwField;
    private JButton loginButton;

    public LoginForm() {
        setTitle("Login Form");
        setSize(300, 150);
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

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                String pw = new String(pwField.getPassword());

                UserDAO dao = new UserDAO();
                UserDTO user = dao.login(id, pw);

                if (user != null) {
                    JOptionPane.showMessageDialog(null, "로그인 성공! 환영합니다!");
                    dispose(); // 로그인 창 닫기
                    new HomeForm(user); // HomeForm에 user 정보 전달
                } else {
                    JOptionPane.showMessageDialog(null, "로그인 실패!");
                    
                    
                }
            }
        });
    }
}
