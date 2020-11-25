package com.sbs.edu.mvc.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sbs.edu.mvc.service.MemberService;
import com.sbs.edu.mvc.vo.MemberVO;


public class MemberListController implements Controller {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		MemberService service = MemberService.getInstance();
		ArrayList<MemberVO> list = service.memberList();
		
		req.setAttribute("list", list);
		HttpUtil.forward(req, res, "/result/memberListOutput.jsp");
	}
}
