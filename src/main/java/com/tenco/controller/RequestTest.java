package com.tenco.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

// http://localhost:8080/gp/req-test <- 주소설계
@WebServlet("/req-test")
public class RequestTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RequestTest() {
        super();
    }

    // http://localhost:8080/gp/req-test?name="홍길동"
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// METHOD가 GET 방식일때 동작
		// 요청받고 응답 시 MIME TYPE을 text/html로 내려주고 싶을 때
		response.setContentType("text/html; charset=UTF-8");
		
		// GET방식 - HTTP 요청 메세지 시작줄에 /req-test?name="홍길동"&age=100
		// 정보는 request 객체에 담김
		String name = request.getParameter("name");
		String greeting = "Hello," + (name != null ? name : "바보" ) + " !! ";
		// name값이 null값이라면, 바보 출력
		
		// 응답할 데이터를 내려준다.
		response.getWriter().print("<html><body> <h2>"+ greeting +"</h2> </body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		// 요청을 받아 인증검사, 요청 값의 유효성 검사 등을 진행

		// HTTP 요청 - 바디에서 데이터 추출
		response.setContentType("text/html; charset=UTF-8");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		// 보통 DB에 접근해 CRUD 작업 후 응답을 내려줌
		response.getWriter().write("<html>");
		response.getWriter().write("<head>");
		response.getWriter().write("</head>");
		response.getWriter().write("<body>");
		response.getWriter().write("<h1>");
		response.getWriter().write("<p>");
		response.getWriter().write("name : " + name);
		response.getWriter().write("<br>");
		response.getWriter().write("email : " + email);
		response.getWriter().write("</p>");
		response.getWriter().write("</h1>");
		response.getWriter().write("</body>");
		response.getWriter().write("</html>");
		
	}
	// http://localhost:8080/demo1/req-test?name="야스오"
	// http://localhost:8080/demo1/req-test?name=%22%EC%95%BC%EC%8A%A4%EC%98%A4%22
	// 주소창에서 한글이 포함된 주소 복사 시, 인코딩 된 주소로 복사됨
	
}
