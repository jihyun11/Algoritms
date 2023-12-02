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

import DB.*;
import frame.*;

public class login extends JFrame implements ActionListener {
	
	private JButton btnLogin;
	private JButton btnJoin;
	protected JTextField id;
	private JPasswordField pw;

	public login() {
		setTitle("로그인");
		setSize(400, 600);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(this);
		
		
		Font mainFont = new Font("Gowun Batang Regular", Font.BOLD, 20);
		Font subFont = new Font("Gowun Batang Regular", Font.PLAIN, 15);
		
		JPanel mainFrame = new JPanel();
		add(mainFrame);
		mainFrame.setLayout(null);
		
		JLabel logobig = new JLabel(new ImageIcon("images/logobig.png")); // 로고
		JLabel txtId = new JLabel("아이디");
		JLabel txtPw = new JLabel("비밀번호");
		
		JLabel box1 = new JLabel(new ImageIcon("images/box.png")); // 아이디
		JLabel box2 = new JLabel(new ImageIcon("images/box.png")); // 비밀번호
		
		id = new JTextField(30);
		pw = new JPasswordField(30);
		pw.setEchoChar('*');
		
		id.setFont(subFont);
		pw.setFont(subFont);
		
		id.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		pw.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		btnLogin = new JButton(new ImageIcon("images/btnlogin.png"));
		btnJoin = new JButton("회원가입");
		
		txtId.setFont(mainFont);
		txtPw.setFont(mainFont);
		btnJoin.setFont(mainFont);
		btnJoin.setForeground(Color.gray);
		
		logobig.setBounds(70, 30, 250, 260);
		txtId.setBounds(50, 180, 250, 260);
		txtPw.setBounds(50, 270, 250, 260);
		box1.setBounds(50, 335, 200, 34);
		box2.setBounds(50, 425, 200, 34);
		id.setBounds(60, 340, 185, 24);
		pw.setBounds(60, 430, 185, 24);
		btnLogin.setBounds(270, 350, 80, 76);
		btnJoin.setBounds(235, 480, 150, 50);
		
		btnLogin.addActionListener(this);
		btnJoin.addActionListener(this);
		
		
		mainFrame.add(logobig);
		mainFrame.add(txtId);
		mainFrame.add(txtPw);
		mainFrame.add(box1);
		mainFrame.add(box2);
		mainFrame.add(id);
		mainFrame.add(pw);
		mainFrame.add(btnLogin);
		mainFrame.add(btnJoin);
		
		btnLogin.setBorderPainted(false);
		btnLogin.setContentAreaFilled(false);
		btnJoin.setBorderPainted(false);
		btnJoin.setContentAreaFilled(false);
		mainFrame.setBackground(Color.WHITE);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new login();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==btnJoin) {
			Join jo= new Join();
			jo.setLocationRelativeTo(this);
			 this.dispose();
		} 
		else if(obj==btnLogin) {
			String getID = id.getText();
			String getPW = pw.getText();
//			System.out.println(getID + ", " + getPW);
			MemberDB mdb = new MemberDB();
			mdb.HapLogin(getID, getPW);
			
			switch(MemberDB.loginResult) {
			case 0: // 로그인 성공
				home main = new home(getID);
				main.setLocationRelativeTo(this);
				this.dispose();
				break;
			case 1: // 아이디는 맞음, 비번틀림
				JOptionPane.showMessageDialog(null, "비밀번호가 다릅니다.", "로그인 실패",
						JOptionPane.WARNING_MESSAGE);
				break;
			case 2: // 아이디 틀림
				JOptionPane.showMessageDialog(null, "아이디가 다릅니다.", "로그인 실패",
						JOptionPane.WARNING_MESSAGE);
				break;
			}
			
//			System.out.println("ID : " + getID + "PW : " + getPW);
		}
		
	}

}
