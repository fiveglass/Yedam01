package com.yedam.student;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;

public class StudentDAO extends DAO {

	private static StudentDAO stdDao = null;

	private StudentDAO() {

	}

	public static StudentDAO getInstance() {
		if (stdDao == null) {
			stdDao = new StudentDAO();
		}
		return stdDao;
	}

	// 전체 조회
	public List<Student> getStudentList() {
		List<Student> list = new ArrayList<>();
		Student std = null;
		try {
			conn();
			String sql = "SELECT * FROM student ORDER BY 1";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				std = new Student();
				std.setStdId(rs.getInt("std_id"));
				std.setStdName(rs.getString("std_name"));
				std.setStdMajor(rs.getString("std_major"));
				std.setStdPoint(rs.getInt("std_point"));
				list.add(std);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}
	
	//단건 조회
	public Student getStudent(int stdId) {
		Student std = null;
		try {
			conn();
			String sql = "SELECT * FROM student WHERE std_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, stdId);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				std = new Student();
				std.setStdId(rs.getInt("std_id"));
				std.setStdName(rs.getString("std_name"));
				std.setStdMajor(rs.getString("std_major"));
				std.setStdPoint(rs.getInt("std_point"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return std;
	}
	//DML
	//학생 등록
	public int insertStd(Student std) {
		int result = 0;
		try {
			conn();
			String sql = "INSERT INTO student "
					+ "VALUES (?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, std.getStdId());
			pstmt.setString(2, std.getStdName());
			pstmt.setString(3, std.getStdMajor());
			pstmt.setInt(4, std.getStdPoint());
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	//학생 삭제
	public int deleteStd(int stdId) {
		int result = 0;
		try {
			conn();
			String sql = "DELETE FROM student WHERE std_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, stdId);
			
			result = pstmt.executeUpdate();			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	//전공 변경
	public int modifyMajor(Student std) {
		int result = 0;
		try {
			conn();
			String sql = "UPDATE student SET std_major = ?"
					+ " WHERE std_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, std.getStdMajor());
			pstmt.setInt(2, std.getStdId());
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	//전공별 성적 합계 및 평균
	public List<Student> getAnalyze(){
		List<Student> list = new ArrayList<>();
		Student std = null;
		try {
			conn();
			String sql = "SELECT std_major, sum(std_point) total, avg(std_point)\r\n"
					+ "FROM student\r\n"
					+ "GROUP BY std_major";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				std = new Student();
				std.setStdMajor(rs.getString("std_major"));
				std.setSum(rs.getDouble("total"));
				std.setAvg(rs.getDouble("avg(std_point)"));
				list.add(std);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
	
	
	
	
	
	
	
	
}
