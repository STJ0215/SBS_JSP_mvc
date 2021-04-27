package com.sbs.edu.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sbs.edu.mvc.service.MemberService;
import com.sbs.edu.mvc.vo.MemberVO;

public class MemberInsertController implements Controller {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 파라미터 추출
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		String mail = req.getParameter("mail");
		
		System.out.println("id : " + id);
		System.out.println("pw : " + pw);
		System.out.println("name : " + name);
		System.out.println("mail : " + mail);
		
		// 유효성 체크
		if (id.isEmpty() || pw.isEmpty() || name.isEmpty() || mail.isEmpty()) {
			req.setAttribute("error", "모든 항목을 빠짐없이 입력해주세요.");
			HttpUtil.forward(req, res, "/memberInsert.jsp");
			
			return;
		}
		
		// VO객체 바인딩
		MemberVO member = new MemberVO();
		member.setUserid(id);
		member.setUserpw(pw);
		member.setName(name);
		member.setMain(mail);
		
		// Service 객체의 메서드 호출
		MemberService service = MemberService.getInstance();
		service.memberInsert(member);
		
		// Output View 페이지로 이동
		req.setAttribute("userid", id);
		HttpUtil.forward(req, res, "/result/memberInsertOutput.jsp"); 
	}
}
