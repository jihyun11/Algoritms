package org.example.wordchain.frame;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;


public class game extends JFrame {
	
	private JButton btnExit;
	private JButton btnSend;

	public game(String id) {
		setTitle("게임");
		setSize(400, 600);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(this);
		
		Font mainFont = new Font("Gowun Batang Regular", Font.PLAIN, 18);
		
		JPanel p1 = new JPanel();
		p1.setBounds(0, 0, 400, 110);
		add(p1);
		JPanel p2 = new JPanel();
		p2.setBounds(0, 100, 400, 400);
		add(p2);
		JPanel p3 = new JPanel();
		add(p3);
		p3.setBounds(0, 530, 400, 60);
	
		p1.setLayout(null);
		p2.setLayout(null);
		p3.setLayout(null);
		
		
		JLabel textfield = new JLabel(new ImageIcon("images/textfield.png"));
		JLabel logosmall = new JLabel(new ImageIcon("images/logosmall.png"));
		btnExit = new JButton(new ImageIcon("images/btnexit.png"));
		btnSend = new JButton(new ImageIcon("images/btnsend.png"));
		JTextField tf = new JTextField(50);
		JTextArea ta = new JTextArea();
		ta.setLineWrap(true);
		
		JScrollPane scrollPane = new JScrollPane(ta);
        scrollPane.setBounds(0, 10, 387, 390);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        Border emptyBorder = BorderFactory.createEmptyBorder();
        scrollPane.setBorder(emptyBorder);
		
		tf.setFont(mainFont);
		tf.setBorder(javax.swing.BorderFactory.createEmptyBorder());
//		tf.setOpaque(false);
		ta.setFont(mainFont);
		
		textfield.setBounds(8, 510, 295, 42);
		
		tf.setBounds(15, 515, 280, 32);
		logosmall.setBounds(8, 0, 93, 100);
		btnExit.setBounds(240, 17, 130, 67);
		btnSend.setBounds(315, 510, 64, 42);
		
		
		p1.add(btnExit);
		p1.add(logosmall);
		p2.add(scrollPane);
		p3.add(textfield);
		p3.add(btnSend);
		p3.add(tf);
		
		btnExit.setBorderPainted(false);
		btnExit.setContentAreaFilled(false);
		btnSend.setBorderPainted(false);
		btnSend.setContentAreaFilled(false);
		
		Color skyblue = new Color(218, 227, 243);
		Color lightgray = new Color(219, 219, 219);
		
		p1.setBackground(skyblue);
		p2.setBackground(Color.WHITE);
		p3.setBackground(lightgray);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new game("ex");
	}
}
