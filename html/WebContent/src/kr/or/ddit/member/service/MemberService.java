package kr.or.ddit.member.service;

import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.member.dao.MemberDao;
import kr.or.ddit.member.vo.MemberVo;

public class MemberService {
	private MemberDao dao;
	
	public MemberService() {
		if(dao == null)
			dao = new MemberDao();
	}
	
	public MemberVo createMember(MemberVo memberVo) throws Exception {
		int result = dao.createMember(memberVo);
		if(result > 0) {
			MemberVo tmpMemberVo = new MemberVo();
			tmpMemberVo.setId(memberVo.getId());
			return dao.retrieve(tmpMemberVo);
		} else {
			return null;
		}
	}
	
	public MemberVo updateMember(MemberVo memberVo) {
//		return dao.memberVo;
		return memberVo;
	}
	public List<MemberVo> deleteMember(MemberVo memberVo) {
		return new ArrayList<MemberVo>();
	}
	public MemberVo retrieveMember(MemberVo memberVo) {
		return new MemberVo();
	}
	public List<MemberVo> retrieveMemberList(MemberVo memberVo) throws Exception {
		return dao.retrieveList(memberVo);
//		return dao.tmpList();
	}
	
}
