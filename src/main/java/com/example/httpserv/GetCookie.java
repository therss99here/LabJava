package com.example.httpserv;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GetCookie extends HttpServlet {
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
