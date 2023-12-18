package org.example.wordchain.DB;

import java.sql.*;

public class MemberDB {
	private Statement stmt;
	private Connection conn;
	private ResultSet rs, rs2;
	
	private String pid, ppw; // 찾은 아이디와 비번 저장할 변수
	private String win;
	private String defeat;
	
	public String getWin() { return win; }
	public void setWin(String win) { this.win = win; }
	
	public String getDefeat() { return defeat; }
	public void setDefeat(String defeat) { this.defeat = defeat; }
	
	public String getPid() { return pid; }
	public void setPid(String pid) { this.pid = pid; }

	public String getPpw() { return ppw; }
	public void setPpw(String ppw) { this.ppw = ppw; }
	
	public static int loginResult=2;
	
	public void init() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost/testdb_c",
					"root",	"1234");
			System.out.println("memberDB connected!"); // 디버깅
	        stmt = conn.createStatement();
        
		} catch(Exception e) { e.printStackTrace(); }
	}
	
	public void join(String id, String pw) {
		init();
		try {
			stmt.executeUpdate("INSERT INTO wordchain (id, pw, win, defeat) values"
					+ "('"+id+"','"+pw+"','0','0')");
			stmt.close();
			conn.close();
		} catch(Exception e) { 
			System.out.println("로그인오류(아래는 오류 안내문)");
			e.printStackTrace(); 
		}
	}
	
	public void HapLogin(String userID, String userPW) {
		init();
		try {
			rs = stmt.executeQuery("SELECT id,pw FROM wordchain where id='"+userID+"'");
			
			if(rs.next()) {
				String pw = rs.getString("pw");
				
				if(pw.equals(userPW)) { // 비번맞으면
					loginResult = 0;
				} else { // 비번틀리면
					loginResult = 1;
				}
			}
			else { // 아이디 틀리면
				loginResult = 2;
			}

			stmt.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("SQL 오류입니다.(아래는 오류 안내문)");
			e.printStackTrace();
		}
	}
	
	public void defeat(String id) {
		init();
		try {
			stmt.executeUpdate("UPDATE wordchain set defeat = defeat + 1 where id='"+id+"'");
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("SQL 오류입니다.(아래는 오류 안내문)");
			e.printStackTrace();
		}
	}
	
	public void win(String id) {
		init();
		try {
			stmt.executeUpdate("UPDATE wordchain set win = win + 1 where id='"+id+"'");
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("SQL 오류입니다.(아래는 오류 안내문)");
			e.printStackTrace();
		}
	}
	public void wd(String id) {
		init();
		try {
			rs2 = stmt.executeQuery("SELECT win, defeat FROM wordchain where id='"+id+"'");
		
			if(rs2.next()) {
				win = rs2.getString("win");
				defeat = rs2.getString("defeat");
			}
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("SQL 오류입니다.(아래는 오류 안내문)");
			e.printStackTrace();
		}
	}
}
