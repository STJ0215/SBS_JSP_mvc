package com.sbs.edu.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sbs.edu.mvc.service.MemberService;
import com.sbs.edu.mvc.vo.MemberVO;

public class MemberSearchController implements Controller {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String id = req.getParameter("id");
		String job = req.getParameter("job");
		String path = null;
		
		// 유효성 체크
		if (job.equals("search")) {
			path = "/memberSearch.jsp";	
		}
		else if (job.equals("update")) {
			path = "/memberUpdate.jsp";
		}
		else if (job.equals("delete")) {
			path = "/memberDelete.jsp";
		}
		
		if (id.isEmpty()) {
			req.setAttribute("error", "ID를 입력해주세요!");
			HttpUtil.forward(req, res, path);
			
			return;
		}
		
		// Service 객체의 메서드 호출.
		MemberService service = MemberService.getInstance();
		MemberVO member = service.memberSearch(id);
		
		// Output View 페이지로 이동.
		if (member == null) {
			req.setAttribute("result", "검색된 정보가 없습니다.");
		}
		
		req.setAttribute("member", member);
		
		if (job.equals("search")) {
			path = "/result/memberSearchOutput.jsp";
		}
		
		HttpUtil.forward(req, res, path);
	}
}
