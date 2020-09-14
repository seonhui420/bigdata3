package kr.mem.pojo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	// FC(FrontController)가 해야할일을 POJO들이 대신 해주는 메서드 / pojo들도 메소드 생성-> 일을 넘겨받아 대신 해야하기 때문에
	public String requestHandle(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException;
}
