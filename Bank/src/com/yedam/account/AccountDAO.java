package com.yedam.account;

import com.yedam.common.DAO;
import com.yedam.member.Member;

public class AccountDAO extends DAO{
	//싱글톤
	private static AccountDAO aDAO = null;
	
	private AccountDAO () {
		
	}
	
	public static AccountDAO getInstance() {
		if(aDAO == null) {
			aDAO = new AccountDAO();
		}
		return aDAO;
	}
	
	//1.고객 등록
	public int insertMember(Member member) {
		int result = 0;
		try {
			conn();
			String sql = "insert into member VALUES(?,?,?,'N')";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberName());
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	//2. 계좌개설
	public int insertAccount(Account account) {
		int result = 0;
		try {
			conn();
			String sql = "insert into account values(?,?,sysdate,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account.getAccountId());
			pstmt.setInt(2, account.getAccountBalance());
			pstmt.setString(3, account.getMemberId());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	//3.입출금
	public int inoutMoney(Account account, int cmd) {
		int result = 0;
		try {
			conn();
			//cmd에 따른 입금, 출금 구분
			//통장 잔고 확인
			String sql2 = "select account_balance from account where account_id = ? ";
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, account.getAccountId());
			
			rs = pstmt.executeQuery();
			
			int balance = 0;
			if(rs.next()) {
				balance = rs.getInt("account_balance");
			}
			
			String sql="";
			if(cmd == 1) {
				sql = "update account set account_balance = account_balance + ? where account_id=?";
			}else if(cmd == 2) {
				if(balance < account.getAccountBalance()) {
					sql=null;
				}else {
					sql = "update account set account_balance = account_balance - ? where account_id=?";
				}
			}
				
			if(sql == null) {
				System.out.println("예금액보다 출금액이 많음. 출금실패");
			}else {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, account.getAccountBalance());
				pstmt.setString(2, account.getAccountId());
				result = pstmt.executeUpdate();	
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	
	//계좌 이체
	public int transferMoney(String toAccount, String fromAccount, int balance) {
		//toAccount 받는 사람
		
		//fromAccount 보내는 사람
		
		//balance 송금금액
		
		int result = 0;
		try {
			conn();
			String sql = "update account set account_balance = account_balance - ? where account_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, balance);
			pstmt.setString(2, fromAccount);
			
			result = pstmt.executeUpdate();
			
			if(result == 1) {
				System.out.println("정상출금");
				sql = "update account set account_balance = account_balance + ? where account_id = ?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, balance);
				pstmt.setString(2, toAccount);
				result = pstmt.executeUpdate();
			}else {
				System.out.println("출금실패");
			}
			//2.받는 계좌 금액 총액
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	//계좌 해지
	public int deleteAccount(String accountId) {
		int result = 0;
		try {
			conn();
			String sql = "delete from account where account_id = ?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, accountId);
			result = pstmt.executeUpdate();	
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
}
