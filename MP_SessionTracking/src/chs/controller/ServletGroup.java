package chs.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import chs.model.InputBean;

@WebServlet("/servletgroup.action")
public class ServletGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String inputtedText = request.getParameter("inputtedText");
		
		InputBean input = new InputBean(inputtedText);
		input.Group();
				
		//Creating HttpSession
		HttpSession inputSession = request.getSession();
		inputSession.setAttribute("allSpeChar", input.getAllSpeChar());
		
		System.out.println("Session ID: " + inputSession.getId());
		System.out.println("Session Attribute: " + inputSession.getAttribute("allSpeChar"));
		
		//=============
		
		//Cookie
		Cookie ck = new Cookie("allNum", input.getAllNum().toString());
		response.addCookie(ck);
		response.sendRedirect("servletdisplay.action");
		
		System.out.println("Cookie: " +ck.getValue());
	}

}
