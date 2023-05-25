package com.sugang.member;

import java.util.ArrayList;
import java.util.List;

import com.sugang.common.DAO;

public class MemberDAO extends DAO {
	
	private static MemberDAO memberDao = null;
	
	private MemberDAO() {
		
	}
	
	public static MemberDAO getInstance() {
		if(memberDao == null) {
			memberDao = new MemberDAO();
		}
		return memberDao;
	}
	
	//로그인 기능
	public Member login(String id) {
		Member member = null;
		try {
			conn();
			String sql = "SELECT * FROM member WHERE member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			 
			rs=pstmt.executeQuery();
			if(rs.next()) {
				member = new Member();
				member.setMemberId(id);
				member.setMemberName(rs.getString("member_name"));
				member.setMemberPw(rs.getString("member_pw"));
				member.setMemberType(rs.getString("member_type"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return member;
	}
	
	//회원가입
	public int membership(Member member) {
		int result = 0;
		try {
			conn();
			String sql = "insert into member values (?, ?, ?, ?, ?, ?, 'M', sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3,member.getMemberName());
			pstmt.setInt(4, member.getMemberPhone());
			pstmt.setString(5, member.getMemberAddr());
			pstmt.setString(6, member.getMemberBirth());
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	//마이페이지 : 내정보조회
	public List<Member> mypageMemberInfo() {
		List<Member> list = new ArrayList<>();
		Member member = null;
		try {
			conn();	
			String sql = "SELECT member_id, member_name, member_phone, member_addr, member_birth, member_join \r\n"
					+ "FROM member \r\n"
					+ "WHERE member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, MemberService.memberInfo.getMemberId());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				member = new Member();
				member.setMemberId(rs.getString("member_id"));
				member.setMemberName(rs.getNString("member_name"));
				member.setMemberPhone(rs.getInt("member_phone"));
				member.setMemberAddr(rs.getNString("member_addr"));
				member.setMemberBirth(rs.getString("member_birth"));
				member.setMemberJoin(rs.getDate("member_join"));
				list.add(member);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
	
	//내정보관리 : 비밀번호수정
	public int modifyPw(Member member) {
		int result = 0;
		try {
			conn();
			String sql = "UPDATE member SET member_pw = ?"
					+ "WHERE member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberPw());
			pstmt.setString(2, MemberService.memberInfo.getMemberId());
			rs = pstmt.executeQuery();
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	
	//내정보관리 : 연락처수정
	public int modifyPhone(Member member) {
		int result = 0;
		try {
			conn();
			String sql = "UPDATE member SET member_phone = ?"
					+ "WHERE member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, member.getMemberPhone());
			pstmt.setString(2, MemberService.memberInfo.getMemberId());
			rs = pstmt.executeQuery();
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	//내정보관리 : 주소수정
	public int modifyAddr(Member member) {
		int result = 0;
		try {
			conn();
			String sql = "UPDATE member SET member_addr = ?"
					+ "WHERE member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberAddr());
			pstmt.setString(2, MemberService.memberInfo.getMemberId());
			rs = pstmt.executeQuery();
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	
}
