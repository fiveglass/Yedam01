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
	public List<Clas> classIndex(String classSemester) {
		List<Clas> list = new ArrayList<>();
		Clas cs = null;
		try {
			conn();
			String sql = "SELECT * FROM class WHERE class_semester = ? ORDER BY 1";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, classSemester);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				cs = new Clas();
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
	public Clas indexContent(int classno) {
		Clas cs = null;
		try {
			conn();
			String sql = "SELECT * FROM class WHERE class_no = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, classno);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				cs = new Clas();
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
