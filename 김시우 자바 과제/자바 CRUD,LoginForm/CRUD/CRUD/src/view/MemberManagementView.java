package view;

import javax.swing.*;

import controller.MemberController; // Changed Controller to MemberController
import model.Member; // Changed Model to Member

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MemberManagementView extends JFrame { // Renamed to MemberManagementView
    JPanel jpanel = new JPanel();
    JTextField t1 = new JTextField();
    JTextField t2 = new JTextField();
    JTextField t3 = new JTextField();
    JTextField t4 = new JTextField();
    JTextArea ta = new JTextArea();
    JButton btn1, btn2, btn3, btn4, btn5;
    JLabel l1 = new JLabel("이름 : "); // Corrected 'ㅣ1' to 'l1'
    JLabel l2 = new JLabel("생년월일 : "); // Corrected 'ㅣ2' to 'l2'
    JLabel l3 = new JLabel("전화번호 : "); // Corrected 'ㅣ3' to 'l3'
    JLabel l4 = new JLabel("검색내용 : "); // Corrected 'ㅣ4' to 'l4'

    MemberController memberController = new MemberController(); // Changed Controller to MemberController

    public MemberManagementView() {
        GUI_init();
    }

    public void GUI_init() {
        setTitle("회원관리 (관리자)");
        setBounds(50, 50, 480, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Changed to DISPOSE_ON_CLOSE
        setVisible(true);
        jpanel.setLayout(null);
        add(jpanel);

        t1.setBounds(75, 25, 70, 25);
        jpanel.add(t1);
        l1.setBounds(37, 21, 70, 30);
        jpanel.add(l1);

        t2.setBounds(213, 25, 70, 25);
        jpanel.add(t2);
        l2.setBounds(150, 21, 70, 30);
        jpanel.add(l2);

        t3.setBounds(352, 25, 80, 25);
        jpanel.add(t3);
        l3.setBounds(290, 21, 70, 30);
        jpanel.add(l3);

        t4.setBounds(213, 105, 80, 25);
        jpanel.add(t4);
        l4.setBounds(150, 100, 70, 30);
        jpanel.add(l4);

        JScrollPane jsp = new JScrollPane(ta);
        jsp.setBounds(23, 145, 420, 250);
        jpanel.add(jsp);

        jpanel.add(btn1 = new JButton("입력"));
        btn1.setBounds(40, 60, 80, 30);

        jpanel.add(btn2 = new JButton("출력"));
        btn2.setBounds(145, 60, 80, 30);

        jpanel.add(btn3 = new JButton("수정"));
        btn3.setBounds(250, 60, 80, 30);

        jpanel.add(btn4 = new JButton("삭제"));
        btn4.setBounds(350, 60, 80, 30);

        jpanel.add(btn5 = new JButton("검색"));
        btn5.setBounds(300, 100, 80, 30);

        // 회원 추가
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                ta.setText("");

                String name = t1.getText().trim(); // Use trim() to remove leading/trailing spaces
                String birth = t2.getText().trim();
                String tel = t3.getText().trim();

                if (!name.isBlank() && !birth.isBlank() && !tel.isBlank()) {
                    memberController.insertMember(new Member(name, birth, tel)); // Changed Model to Member

                    ta.append("입력 완료 \n");

                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                } else {
                    ta.append("빈 칸은 존재해서는 안됩니다. \n");
                }
            }
        });

        // 회원 목록 출력
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                displayMembers(memberController.readMember());
            }
        });

        // 회원 수정
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                ta.setText("");
                String name = t1.getText().trim();
                String tel = t3.getText().trim();

                if (!name.isBlank() && !tel.isBlank()) {
                    memberController.updateMember(name, tel);
                    ta.append("수정 완료 \n");
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                } else {
                    ta.append("이름과 전화번호를 입력하세요. \n");
                }
            }
        });

        // 회원 삭제
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                ta.setText("");

                String name = t1.getText().trim();
                if (!name.isBlank()) {
                    memberController.deleteMember(name);
                    ta.append("삭제 완료 \n");
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                } else {
                    ta.append("삭제할 회원의 이름을 입력하세요. \n");
                }
            }
        });

        // 회원 검색
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String content = t4.getText().trim();
                if (!content.isBlank()) {
                    displayMembers(memberController.searchMember(content));
                } else {
                    ta.setText("검색 내용을 입력하세요. \n");
                }
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
            }
        });
    }

    private void displayMembers(ArrayList<Member> members) {
        ta.setText("");
        if (members.isEmpty()) {
            ta.append("검색 결과가 없습니다.\n");
            return;
        }

        ta.append("\t" + "name" + "\t" + "birth" + "\t" + "tel\n");
        ta.append("\t" + "------------------------------------------------------------\n");

        for (Member member : members) {
            ta.append(String.format("\t%-10s\t%-10s\t%-10s\n", member.getName(), member.getBirth(), member.getTel()));
        }
    }
}