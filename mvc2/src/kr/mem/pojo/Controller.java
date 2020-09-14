package kr.mem.pojo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	// FC(FrontController)�� �ؾ������� POJO���� ��� ���ִ� �޼��� / pojo�鵵 �޼ҵ� ����-> ���� �Ѱܹ޾� ��� �ؾ��ϱ� ������
	public String requestHandle(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException;
}
