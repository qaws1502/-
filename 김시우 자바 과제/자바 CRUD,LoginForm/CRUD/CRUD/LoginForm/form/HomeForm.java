package form;

import dto.UserDTO;

import javax.swing.*;

public class HomeForm extends JFrame {
    public HomeForm(UserDTO user) {
        setTitle("Home");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        add(panel);

        JLabel welcomeLabel = new JLabel("환영합니다, " + user.getName() + "님!");
        panel.add(welcomeLabel);

        setVisible(true);
    }
}