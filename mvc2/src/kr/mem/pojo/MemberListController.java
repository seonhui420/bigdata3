package kr.mem.pojo;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.mem.model.MemberDAO;
import kr.mem.model.MemberVO;

public class MemberListController implements Controller {

	@Override
	public String requestHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. ��ü����Ʈ�� ��������
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberVO> list = dao.memberAllList();

		// 2.��ü���ε�
		request.setAttribute("list", list);
		// View -> member/memberList.jsp
		return "member/memberList.jsp"; // "/WEB-INF/member/memberList.jsp" =>�տ� ��θ� ����� �����̸��� ����ϴ� ��� : 
																		// WEB-INF���� �ȿ� views���� ���� �� member������ �׾ȿ� �־��� 
																		//   => �̶� �󼼰�� "/WEB-INF/views/member/memberList.jsp"
																		//    => ������ "/WEB-INF/views/" : ����Ʈ���� ���� �������ֱ�

	}

}
