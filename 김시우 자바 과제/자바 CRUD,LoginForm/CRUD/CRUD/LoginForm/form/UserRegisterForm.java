package form;

import dao.UserDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserRegisterForm extends JFrame {
    private JTextField idField;
    private JPasswordField pwField;
    private JTextField nameField;
    private JTextField birthField; // 추가
    private JTextField telField;   // 추가
    private JButton registerButton;

    public UserRegisterForm() {
        setTitle("회원가입");
        setSize(300, 300); // UI 요소가 추가되므로 높이 증가
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel);

        setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(10, 20, 80, 25);
        panel.add(idLabel);

        idField = new JTextField(20);
        idField.setBounds(100, 20, 160, 25);
        panel.add(idField);

        JLabel pwLabel = new JLabel("Password:");
        pwLabel.setBounds(10, 50, 80, 25);
        panel.add(pwLabel);

        pwField = new JPasswordField(20);
        pwField.setBounds(100, 50, 160, 25);
        panel.add(pwField);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(10, 80, 80, 25);
        panel.add(nameLabel);

        nameField = new JTextField(20);
        nameField.setBounds(100, 80, 160, 25);
        panel.add(nameField);

        // 생년월일 필드 추가
        JLabel birthLabel = new JLabel("생년월일:");
        birthLabel.setBounds(10, 110, 80, 25);
        panel.add(birthLabel);

        birthField = new JTextField(20);
        birthField.setBounds(100, 110, 160, 25);
        panel.add(birthField);

        // 전화번호 필드 추가
        JLabel telLabel = new JLabel("전화번호:");
        telLabel.setBounds(10, 140, 80, 25);
        panel.add(telLabel);

        telField = new JTextField(20);
        telField.setBounds(100, 140, 160, 25);
        panel.add(telField);


        registerButton = new JButton("회원가입");
        registerButton.setBounds(10, 180, 250, 25); // 버튼 위치 조정
        panel.add(registerButton);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText().trim();
                String pw = new String(pwField.getPassword()).trim();
                String name = nameField.getText().trim();
                String birth = birthField.getText().trim(); // 생년월일 값 가져오기
                String tel = telField.getText().trim();     // 전화번호 값 가져오기

                if (id.isBlank() || pw.isBlank() || name.isBlank() || birth.isBlank() || tel.isBlank()) {
                    JOptionPane.showMessageDialog(null, "모든 필드를 채워주세요.");
                    return;
                }

                UserDAO userDAO = new UserDAO();
                // registerUser 메서드에 birth와 tel 값 전달
                if (userDAO.registerUser(id, pw, name, birth, tel)) {
                    JOptionPane.showMessageDialog(null, "회원가입 성공!");
                    dispose(); // Close registration form
                } else {
                    JOptionPane.showMessageDialog(null, "회원가입 실패! (ID 중복 또는 DB 오류)");
                }
            }
        });
    }
}