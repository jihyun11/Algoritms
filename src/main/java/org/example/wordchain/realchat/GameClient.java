package org.example.wordchain.realchat;


import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import DB.*;
import frame.home;


public class GameClient extends JFrame implements ActionListener {

    private JButton btnExit;
    private JButton btnSend;

    private JTextArea ta;
    private JTextField tf;
    private ServerSocket listener = null;
    private Socket socket = null;
    private BufferedReader in = null;
    private BufferedWriter out = null;
    String nowMsg;
    int incorrectCount = 0;

    boolean isFirstWord = true;

    int ClientWinMsg = 0;
    private String  lastChar = "";
    private String firstChar = "";
    private String getid;
	private JButton btnDodge;


    public GameClient(String id) {
        setTitle("게임 클라이언트");
        setSize(400, 600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(this);

        Font mainFont = new Font("Gowun Batang Regular", Font.PLAIN, 18);

        JPanel p1 = new JPanel();
        p1.setBackground(Color.BLUE);
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
        System.out.println("0000");

        JLabel textfield = new JLabel(new ImageIcon("images/textfield.png"));
        JLabel logosmall = new JLabel(new ImageIcon("images/logosmall.png"));
        btnDodge = new JButton(new ImageIcon("images/btndodge.png"));
        btnDodge.addActionListener(this);
        btnExit = new JButton(new ImageIcon("images/btnexit.png"));
        btnExit.addActionListener(this);
        btnSend = new JButton(new ImageIcon("images/btnsend.png"));
        btnSend.addActionListener(this);
        tf = new JTextField(50);
        ta = new JTextArea();
        ta.setLineWrap(true);
        getid = id;

        JScrollPane scrollPane = new JScrollPane(ta);
        scrollPane.setBounds(0, 10, 387, 390);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        Border emptyBorder = BorderFactory.createEmptyBorder();
        scrollPane.setBorder(emptyBorder);

        tf.setFont(mainFont);
        tf.setBorder(javax.swing.BorderFactory.createEmptyBorder());
//      tf.setOpaque(false);
        ta.setFont(mainFont);

        textfield.setBounds(8, 510, 295, 42);

        tf.setBounds(15, 515, 280, 32);
        logosmall.setBounds(8, 0, 93, 100);
        btnDodge.setBounds(220, 20, 67, 67);
        btnExit.setBounds(300, 20, 67, 67);
        btnSend.setBounds(315, 510, 64, 42);

        p1.add(btnDodge);
        p1.add(btnExit);
        p1.add(logosmall);
        p2.add(scrollPane);
        p3.add(textfield);
        p3.add(btnSend);
        p3.add(tf);

        btnDodge.setBorderPainted(false);
        btnDodge.setContentAreaFilled(false);
        btnExit.setBorderPainted(false);
        btnExit.setContentAreaFilled(false);
        btnSend.setBorderPainted(false);
        btnSend.setContentAreaFilled(false);

        Color skyblue = new Color(218, 227, 243);
        Color lightgray = new Color(219, 219, 219);

        p1.setBackground(skyblue);
        p2.setBackground(Color.WHITE);
        p3.setBackground(lightgray);

        System.out.println("111");
        setVisible(true);
        tf.setFocusable(true);
        getRootPane().setDefaultButton(btnSend);
        tf.requestFocus();
    }
    public static void main(String[] args) {
        GameClient gameClient = new GameClient("id");
        gameClient.setSocket();
    }

    public String getLastCharacter(String inMsg) { // 서버에서 보내온 단어 마지막 글자 추출하는 메소드
        if (inMsg != null) {
            return  String.valueOf(inMsg.charAt(inMsg.length() - 1));
        }
        return "";

    }

    public String getFirstCharacter(String outMsg) { // 클라이언트에서 보낸 단어 첫번째 글자 추출하는 메소드
        return String.valueOf(outMsg.charAt(0));

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnDodge) {
            int result = JOptionPane.showConfirmDialog(ta, "정말 기권하시겠습니까?", "기권 확인", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                // 기권 처리 코드
                ClientWinMsg++;
                ta.append("당신이 졌습니다.\n");
                
                if (ClientWinMsg > 0) {
                    try {
                        out.write("이겼습니다!\n");
                        out.flush();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }else if (e.getSource() == btnExit) {
        	home main = new home(getid);
			main.setLocationRelativeTo(this);
			this.dispose();
        }

        if (!tf.getText().equals("")) {
            String outMsg = tf.getText();

            String lastChar = getLastCharacter(nowMsg()); // 서버에서 보내온 단어의 마지막 글자
            String firstChar = getFirstCharacter(tf.getText()); // 클라이언트가 보낸 단어의 첫글자

            if (lastChar.equals(firstChar) || lastChar == "") {
                if (!isFirstWord) {
                    if (outMsg.length() >= 2) {
                        try {
                            out.write(outMsg + "\n");
                            out.flush();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                        ta.append("["+getid+"]: " + outMsg + "\n");
                    } else {
                        ta.append("두 글자 이상 입력해 주세요.\n");
                    }
                }
            } else {
                incorrectCount++; // 어긋난 단어 횟수 증가

                if (incorrectCount == 1) {
                    ta.append("다시 입력하세요. (기회: 2번 남음)\n");
                } else if (incorrectCount == 2) {
                    ta.append("다시 입력하세요. (기회: 1번 남음)\n");
                } else if (incorrectCount >= 3) {
                    ClientWinMsg++;
                    ta.append("당신이 졌습니다.\n"); // 게임 종료 메시지
                    MemberDB memdb=new MemberDB();
                    memdb.defeat(getid);
                    if (ClientWinMsg > 0) {
                        try {
                            out.write("이겼습니다!\n");
                            out.flush();
                            MemberDB memdb2=new MemberDB();
                            memdb.win(getid);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        }

        tf.setText("");
        tf.requestFocus();
    }
    
    
    private volatile boolean running = true;

    public void setSocket() {
        SwingWorker<Void, String> worker = new SwingWorker<Void, String>() {
            @Override
            protected Void doInBackground() {
                try {
                    System.out.println("3333");
                    socket = new Socket("localhost", 9000);

                    in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

                    String lastCharacter = ""; // 서버에서 보내온 단어 마지막 글자 담는 변수

                    while (running) {
                        if (isFirstWord) {
                            String firstWord = "행복";
                            ta.append("[첫단어]: " + firstWord + "\n");
                            isFirstWord = false;
                        }

                        System.out.println("4444");
                        String inMsg = in.readLine();
                        System.out.println("5555");
                        if (inMsg.equals("이겼습니다!")) {
                            ta.append("당신이 이겼습니다!");
                            MemberDB memdb=new MemberDB();
                            memdb.win(getid);
                        } else if (!inMsg.equals("이겼습니다!")) {
                            ta.append("[서버]: " + inMsg + "\n");
                            nowMsg = inMsg; // nowMsg 메소드에 서버가 보내온 단어 담아줌

                            // 서버가 보내온 단어 마지막 글자 알려주는 가이드
                            lastCharacter = getLastCharacter(String.valueOf(inMsg));
                            String nextWordPrompt = "다음 단어를 입력하세요 (끝말: " + lastCharacter.toString() + ")" + "\n";
                            ta.append(nextWordPrompt);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        out.close();
                        in.close();
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return null;
            }
        };

        worker.execute();
    }

    public void stopSocket() {
        running = false;
    }
    public String nowMsg() { // 클라이언트에서 보내온 단어 가져오는 메소드
        return nowMsg;
    }

}