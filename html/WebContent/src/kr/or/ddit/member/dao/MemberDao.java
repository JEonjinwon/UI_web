package kr.or.ddit.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.base.dao.BaseDao;
import kr.or.ddit.member.vo.MemberVo;

public class MemberDao extends BaseDao {
	
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public MemberDao() {
		//super : BaseDao의 getConnection 이라는 뜻
		con = super.getConnection();
	}
	
	public void closeConnection() {
		super.closeConnection();
	}
	
	public int createMember(MemberVo memberVo) throws Exception {
		String sql = "insert into TB_MEMBER  values"
				+ " (TB_MEMBER_SEQ.nextval, ?, ?, ?, ?, SYSDATE, ?, SYSDATE, ?)";
		stmt = con.prepareStatement(sql);
		stmt.setString(1, memberVo.getId());
		stmt.setString(2, memberVo.getName());
		stmt.setInt(3, memberVo.getAge());
		stmt.setString(4, memberVo.getBirthday());
		stmt.setString(5, memberVo.getAddr());
		stmt.setString(6, memberVo.getTel());
		stmt.setString(7, memberVo.getGender());
		
		int result =stmt.executeUpdate();  
		stmt.close();
		return result;
	}
	
	public int updateMember(MemberVo memberVo) throws Exception {
		String sql = "update TB_MEMBER set NAME = ?, AGE = ?, BIRTHDAY = ?, ADDR = ?, TEL = ?, GENDER = ?"
				+ " where ID = ? ";
		stmt = con.prepareStatement(sql);
		stmt.setString(1, memberVo.getName());
		stmt.setInt(2, memberVo.getAge());
		stmt.setString(3, memberVo.getBirthday());
		stmt.setString(4, memberVo.getAddr());
		stmt.setString(5, memberVo.getTel());
		stmt.setString(6, memberVo.getGender());
		stmt.setString(7, memberVo.getId());
		
		int result =stmt.executeUpdate();  
		stmt.close();
		return result;
	}
	
	public int deleteMember(MemberVo memberVo) throws Exception {
		String sql = "delete TB_MEMBER "
					+ " where ID = ? ";
		stmt = con.prepareStatement(sql);
		stmt.setString(1, memberVo.getId());
		
		int result =stmt.executeUpdate();  
		stmt.close();
		return result;
	}

	public MemberVo retrieve(MemberVo memberVo) throws Exception {
		MemberVo vo = null;
		
		String sql = "select * from TB_MEMBER where id = ?";
		stmt = con.prepareStatement(sql);
		stmt.setString(1, memberVo.getId());
		
		rs = stmt.executeQuery();
		while(rs.next()) {
			vo = new MemberVo();
			vo.setId(rs.getString("id"));
			vo.setName(rs.getString("name"));
			vo.setAge(rs.getInt("age"));
			vo.setBirthday(rs.getString("birthday"));
			vo.setAddr(rs.getString("addr"));
			vo.setTel(rs.getString("tel"));
			vo.setGender(rs.getString("gender"));
		}
		rs.close();
		stmt.close();
		
		return vo;
	}
	
	public List<MemberVo> retrieveList(MemberVo memberVo) throws Exception {
		List<MemberVo> list = new ArrayList<MemberVo>();
		
		String sql = ""
			+ "select MEM_ID id        "
			+ "     , MEM_PASS         "
			+ "     , MEM_NAME name    "
			+ "     , MEM_BIR birthday "
			+ "     , MEM_ZIP          "
			+ "     , MEM_ADD1 addr    "
			+ "     , MEM_ADD2         "
			+ "     , MEM_HP tel       "
			+ "     , MEM_MAIL         "
			+ "     , MEM_JOB          "
			+ "from member             "
			+ "";
//				+ "where MEM_ID = ? and name = ?";
		stmt = con.prepareStatement(sql);
//		stmt.setString(1, memberVo.getId());
//		stmt.setString(2, memberVo.getName());
		
		rs = stmt.executeQuery();
		while(rs.next()) {
			MemberVo vo = new MemberVo();
			vo.setId(rs.getString("id"));
			vo.setName(rs.getString("name"));
//			vo.setAge(rs.getInt("age"));
			vo.setBirthday(rs.getString("birthday"));
			vo.setAddr(rs.getString("addr"));
			vo.setTel(rs.getString("tel"));
//			vo.setGender(rs.getString("gender"));
			list.add(vo);
		}
		rs.close();
		stmt.close();
		
		return list;
	}
	
	public List<MemberVo> tmpList(){
		List<MemberVo> list = new ArrayList<MemberVo>();
		MemberVo vo1 = new MemberVo(1, "psy1", "박소연", 38, "19830614", "대전시 중구", "01012341234", "F");
		MemberVo vo2 = new MemberVo(2, "syp2", "홍길동", 20, "20010514", "대전시 서구", "01011112222", "M");
		list.add(vo1);
		list.add(vo2);
		return list;
	}
	
}
