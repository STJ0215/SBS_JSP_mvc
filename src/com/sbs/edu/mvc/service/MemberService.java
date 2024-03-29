package com.sbs.edu.mvc.service;

import java.util.ArrayList;

import com.sbs.edu.mvc.dao.MemberDAO;
import com.sbs.edu.mvc.vo.MemberVO;

public class MemberService {
	private static MemberService service = new MemberService();
	public MemberDAO dao = MemberDAO.getInstance();
	
	private MemberService() {}
	
	public static MemberService getInstance() {
		return service;
	}
	
	public void memberInsert(MemberVO member) {
		dao.memberInsert(member);
	}
	
	public MemberVO memberSearch(String id) {
		MemberVO member = dao.memberSearch(id);
		return member;
	}
	
	public void memberUpdate(MemberVO member) {
		dao.memberUpdate(member);
	}
	
	public ArrayList<MemberVO> memberList() {
		ArrayList<MemberVO> list = dao.memberList();
		return list;
	}
}
