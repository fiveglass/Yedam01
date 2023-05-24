package com.sugang.clas;

import java.util.ArrayList;
import java.util.List;

import com.sugang.common.DAO;

public class ClassDAO extends DAO {
	
	private static ClassDAO classDao = null;
	
	private ClassDAO() {
		
	}
	
	public static ClassDAO getInstance() {
		if(classDao == null) {
			classDao = new ClassDAO();
		}
		return classDao;
	}
	
	
	//강좌조회 : 강좌목록
	public List<Class> classIndex(String classSemester) {
		List<Class> list = new ArrayList<>();
		Class cs = null;
		try {
			conn();
			String sql = "SELECT * FROM class WHERE class_semester = ? ORDER BY 1";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, classSemester);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				cs = new Class();
				cs.setClassNo(rs.getInt("class_no"));
				cs.setClassName(rs.getString("class_name"));
				cs.setClassTeacher(rs.getString("class_teacher"));
				cs.setClassLimit(rs.getInt("class_limit"));
				cs.setClassNumber(rs.getInt("class_number"));
				cs.setClassDate(rs.getString("class_date"));
				cs.setClassSemester(rs.getString("class_semester"));
				cs.setClassExplain(rs.getString("class_explain"));
				list.add(cs);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
	
	//강좌조회 : 강좌목록 (상세)
	public Class indexContent(int classno) {
		Class cs = null;
		try {
			conn();
			String sql = "SELECT * FROM class WHERE class_no = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, classno);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				cs = new Class();
				cs.setClassExplain(rs.getString("class_explain"));
				cs.setClassName(rs.getString("class_name"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return cs;
	}
	
	
}
