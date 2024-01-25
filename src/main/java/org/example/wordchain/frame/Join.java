package org.example.wordchain.frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import org.example.wordchain.DB.MemberDB;
import org.example.wordchain.frame.home;

public class Join extends JFrame implements ActionListener {
	
	private JButton btnJoin;
	private JTextField id;
	private JPasswordField pw;
	private JPasswordField pw2;

	public Join() {
		setTitle("회원가입");
		setSize(400, 600);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(this);
		
		
		Font mainFont = new Font("Gowun Batang Regular", Font.BOLD, 20);
		Font subFont = new Font("Gowun Batang Regular", Font.PLAIN, 15);
		
		JPanel mainFrame = new JPanel();
		add(mainFrame);
		mainFrame.setLayout(null);
		
		JLabel lbljoin = new JLabel(new ImageIcon("images/join.png")); // 로고
		JLabel txtId = new JLabel("아이디");
		JLabel txtPw = new JLabel("비밀번호");
		JLabel txtPw2 = new JLabel("비밀번호 확인");
		
		JLabel box1 = new JLabel(new ImageIcon("images/box.png")); // 아이디
		JLabel box2 = new JLabel(new ImageIcon("images/box.png")); // 비밀번호
		JLabel box3 = new JLabel(new ImageIcon("images/box.png")); // 비밀번호 확인
		
		id = new JTextField(30);
		pw = new JPasswordField(30);
		pw.setEchoChar('*');
		pw2 = new JPasswordField(30);
		pw2.setEchoChar('*');
		
		id.setFont(subFont);
		pw.setFont(subFont);
		pw2.setFont(subFont);
		
		id.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		pw.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		pw2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		btnJoin = new JButton(new ImageIcon("images/btnjoin.png"));
		
		txtId.setFont(mainFont);
		txtPw.setFont(mainFont);
		txtPw2.setFont(mainFont);
		
		lbljoin.setBounds(150, 50, 102, 102);
		txtId.setBounds(90, 70, 250, 260);
		txtPw.setBounds(90, 160, 250, 260);
		txtPw2.setBounds(90, 250, 250, 260);
		box1.setBounds(90, 225, 200, 34);
		box2.setBounds(90, 315, 200, 34);
		box3.setBounds(90, 405, 200, 34);
		id.setBounds(100, 230, 185, 24);
		pw.setBounds(100, 320, 185, 24);
		pw2.setBounds(100, 410, 185, 24);
		btnJoin.setBounds(150, 475, 98, 50);
		
		btnJoin.addActionListener(this);
		
		mainFrame.add(lbljoin);
		mainFrame.add(txtId);
		mainFrame.add(txtPw);
		mainFrame.add(txtPw2);
		mainFrame.add(box1);
		mainFrame.add(box2);
		mainFrame.add(box3);
		mainFrame.add(id);
		mainFrame.add(pw);
		mainFrame.add(pw2);
		
		mainFrame.add(btnJoin);
		
		btnJoin.setBorderPainted(false);
		btnJoin.setContentAreaFilled(false);
		mainFrame.setBackground(Color.WHITE);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new Join();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj= e.getSource();
		
		if(obj==btnJoin) {
			String getid=id.getText();
			String getpw=pw.getText().trim();
			String getpw2=pw2.getText().trim();
			
			System.out.println(getid + ", " + getpw );
			if(getpw.equals(getpw2)) {
				MemberDB memdb=new MemberDB();
				memdb.join(getid, getpw);
				login login= new login();
				login.setLocationRelativeTo(this);
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(null, "비밀번호가 다릅니다.", "비밀번호 확인 오류",
						JOptionPane.WARNING_MESSAGE);
			}
		}
	}
}
