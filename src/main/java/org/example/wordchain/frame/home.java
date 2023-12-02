package org.example.wordchain.frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import DB.*;
import frame.*;
import realchat.*;

public class home extends JFrame implements ActionListener {
	
	private JButton btnEnter;
	private JButton btnLogout;
	private String getid;

	public home(String id) {
		setTitle("홈");
		setSize(400, 600);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(this);
		
		
		Font mainFont = new Font("Gowun Batang Regular", Font.BOLD, 20);
		Font subFont = new Font("Gowun Batang Regular", Font.BOLD, 25);
		
		JPanel mainFrame = new JPanel();
		add(mainFrame);
		mainFrame.setLayout(null);
		
		JLabel logobig = new JLabel(new ImageIcon("images/logobig.png")); // 로고
		JLabel txtId = new JLabel(id);
		getid = id;
		
		MemberDB memdb=new MemberDB();
		memdb.wd(getid);
		JLabel txtwinrate = new JLabel(memdb.getWin() + "승 " + memdb.getDefeat() + "패");
		
		
		btnEnter = new JButton(new ImageIcon("images/btnenter.png"));
		btnLogout = new JButton("로그아웃");
		
		txtId.setFont(subFont);
		txtwinrate.setFont(subFont);
		btnLogout.setFont(mainFont);
		btnLogout.setForeground(Color.gray);
		
		logobig.setBounds(70, 30, 250, 260);
		txtId.setBounds(80, 240, 250, 260);
		txtwinrate.setBounds(80, 280, 250, 260);
		btnEnter.setBounds(270, 350, 80, 76);
		btnLogout.setBounds(235, 480, 150, 50);
		
		btnEnter.addActionListener(this);
		btnLogout.addActionListener(this);
		
		mainFrame.add(logobig);
		mainFrame.add(txtId);
		mainFrame.add(txtwinrate);
		mainFrame.add(btnEnter);
		mainFrame.add(btnLogout);
		
		btnEnter.setBorderPainted(false);
		btnEnter.setContentAreaFilled(false);
		btnLogout.setBorderPainted(false);
		btnLogout.setContentAreaFilled(false);
		mainFrame.setBackground(Color.WHITE);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new home("ex");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==btnEnter) {
			try{
				this.dispose();
		        GameClient game = new GameClient(getid);
		        game.setVisible(true);
		        game.setLocationRelativeTo(this);
		        game.setSocket();
			} catch(Exception e2) {
				e2.printStackTrace();
			}
			
//			this.dispose();
		} else if(obj == btnLogout) {
			login login= new login();
			login.setLocationRelativeTo(this);
			this.dispose();
		}
	}
}
