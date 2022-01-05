package chs.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import chs.model.InputBean;
import chs.util.Helper;

@WebServlet("/servletdisplay.action")
public class ServletDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text.html");
		HttpSession session = request.getSession();
		Cookie [] ck = request.getCookies();
		Cookie cookies = null;
		cookies = Helper.getCookie(ck, "allNum");
		
		PrintWriter out = response.getWriter();
					
			out.print("<html>");
			out.print("<head><title>Cookie and HTTP Session</title>");
			out.print("<link href='css/bootstrap.min.css' rel='stylesheet'>");
			out.print("</head>");
			out.print("<body>");
			out.print("<center>");

			out.print("<br/><br/><br/>");
			//InputBean input = (InputBean)session.getAttribute("allSpeChar");
			response.setContentType("text.html");
			out.print("</br>");
			out.print("<p><b> SESSION ID: </b>" + session.getId() +"</p>");
			out.print("<p><b> HTTP SESSION: </b>" + session.getAttribute("allSpeChar") +"</p>");
			
			out.print("<p><b> COOKIES: </b>" + cookies.getValue() +"</p>");

						
			InputBean space = new InputBean();
			out.print("<p><b> Number of Spaces: </b>" + space.getSpaceCounter() +"</p>");
			out.print("<form action='index.html'>");
			out.print("	<input type='submit' value='<< GO BACK >>'>");
			out.print("<p><i>Checkout your console!<i><p>");
			out.print("</form>");
			out.print("</center>");
			out.print("<hr/>");
			out.print("<p><i>&copy; 2019 CuelloSM</i></p>");
			out.print("</body>");		
			out.print("</html>");
	}
}
