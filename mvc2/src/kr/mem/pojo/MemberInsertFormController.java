package kr.mem.pojo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberInsertFormController implements Controller{

	@Override
	public String requestHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// String page = "member/member.html";
		
		return "member/member.html";  //   "/WEB-INF/member/member.html"; =>앞에 경로를 지우고 파일이름만 사용하는 방법(WEB-INF는 나오면 안됨) : 
	}

}
