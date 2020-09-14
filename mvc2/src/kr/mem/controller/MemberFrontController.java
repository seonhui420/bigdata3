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
		// 1.���û���� �ľ��ϴ� �۾� -> .do
		String reqUri = request.getRequestURI();
		// System.out.println(reqUri);
		String ctxPath = request.getContextPath();
		// System.out.println(ctxPath);
		// Ŭ���̾�Ʈ�� ��û�� ���
		String command = reqUri.substring(ctxPath.length());
		System.out.println(command);
		
		// �� ��û�� ���� ó���ϱ�(�б��۾�)
		Controller controller = null;
		MemberDAO dao = new MemberDAO();
		String nextView = null;
		HandlerMapping mappings = new HandlerMapping();
		controller=mappings.getController(command);
		nextView = controller.requestHandle(request, response);
		
		
		// �ڵ鷯����(HandlerMapping) : POJO�� ������ ã�� �������ִ� ����(�����˹ٻ�)
		//    key   -->   value        : Ű�� ��� ���·� �� �� ���� 
		// /list.do --> MemberListController
		// /insert.do --> MemberInsertController
		// /insertForm.do --> MemberInsertFormController
		// /delete.do --> MemberDeleteController
		/*
		if (command.equals("/list.do")) {
			//��ü����(�˹ٻ�pojo ��ȯ�ϱ� ����)
			controller =new MemberListController();
			nextView = controller.requestHandle(request,response); //�˹� ��ȯ �Ͻ�Ű��
			
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
		// View �������� �����ϴ� �κ�
		if(nextView!=null) {
			if(nextView.indexOf("redirect") != -1) {
				String[] sp = nextView.split(":");  //sp[0]:sp[1]
				response.sendRedirect(sp[1]); // :o
				
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/"+nextView);  // "/WEB-INF/views/"�� ������
				rd.forward(request, response);

			}
		}
		
		
	}

}
