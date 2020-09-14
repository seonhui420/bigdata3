package kr.mem.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.mem.model.MemberDAO;
import kr.mem.model.MemberVO;
import kr.mem.pojo.Controller;
import kr.mem.pojo.MemberDeleteController;
import kr.mem.pojo.MemberInsertController;
import kr.mem.pojo.MemberInsertFormController;
import kr.mem.pojo.MemberListController;

public class MemberFrontController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("euc-kr");
		// 1.어떤요청인지 파악하는 작업 -> .do
		String reqUri = request.getRequestURI();
		// System.out.println(reqUri);
		String ctxPath = request.getContextPath();
		// System.out.println(ctxPath);
		// 클라이언트가 요청한 명령
		String command = reqUri.substring(ctxPath.length());
		System.out.println(command);
		
		// 각 요청에 따라 처리하기(분기작업)
		Controller controller = null;
		MemberDAO dao = new MemberDAO();
		String nextView = null;
		HandlerMapping mappings = new HandlerMapping();
		controller=mappings.getController(command);
		nextView = controller.requestHandle(request, response);
		
		
		// 핸들러매핑(HandlerMapping) : POJO의 역할을 찾아 연결해주는 역할(전문알바생)
		//    key   -->   value        : 키와 밸류 형태로 볼 수 있음 
		// /list.do --> MemberListController
		// /insert.do --> MemberInsertController
		// /insertForm.do --> MemberInsertFormController
		// /delete.do --> MemberDeleteController
		/*
		if (command.equals("/list.do")) {
			//객체생성(알바생pojo 소환하기 위해)
			controller =new MemberListController();
			nextView = controller.requestHandle(request,response); //알바 소환 일시키기
			
		} else if (command.equals("/insert.do")) {
			controller = new MemberInsertController();
			nextView = controller.requestHandle(request, response);
			
		} else if (command.equals("/insertForm.do")) {
			controller = new MemberInsertFormController();
			nextView = controller.requestHandle(request, response);
			
		} else if (command.equals("/delete.do")) {
			controller = new MemberDeleteController();
			nextView = controller.requestHandle(request, response);
		}*/
		
		// -----------------------------------------------------------------------------------
		// View 페이지로 연동하는 부분
		if(nextView!=null) {
			if(nextView.indexOf("redirect") != -1) {
				String[] sp = nextView.split(":");  //sp[0]:sp[1]
				response.sendRedirect(sp[1]); // :o
				
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/"+nextView);  // "/WEB-INF/views/"가 공통경로
				rd.forward(request, response);

			}
		}
		
		
	}

}
