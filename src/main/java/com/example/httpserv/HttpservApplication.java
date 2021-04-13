package com.example.httpserv;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class HttpservApplication extends HttpServlet{

	public static void main(String[] args) {
		SpringApplication.run(HttpservApplication.class, args);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//parameter from HTTP request
		String data = request.getParameter("data");

		//create a Cookie
		Cookie cookie = new Cookie("MyCookie", data);

		//Add cookie to response
		response.addCookie(cookie);

		//Browser output
		PrintWriter printWriter = new PrintWriter("/");
		printWriter.println("<B>MyCookie has been set to");
		printWriter.println(data);
		printWriter.close();
	}
	@RequestMapping("/")
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get cookies from response
		Cookie[] cookies = request.getCookies();

		//show cookies
		response.setContentType("/");
		PrintWriter printWriter = response.getWriter();
		printWriter.println("<B>");
		for(int i=0; i<cookies.length; i++){
			String name = cookies[i].getName();
			String value = cookies[i].getValue();
			printWriter.println("name: " + name +
					": value = " + value);
		}
		printWriter.close();
	}
}
