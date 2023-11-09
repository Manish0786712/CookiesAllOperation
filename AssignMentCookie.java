import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/login1")
public class AssignMentCookie extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String email = req.getParameter("e");
	String pwd = req.getParameter("p");
	// Cookie Instantiation
	Cookie cookie1 = new Cookie("userEmail","abc@gmail.com"); 
	Cookie cookie2 = new Cookie("userpwd","abc@123");
	// setting the age of cookies
	cookie1.setMaxAge(30);
	cookie2.setMaxAge(30);
	
	if(email.equals(cookie1.getValue()) && pwd.equals(cookie2.getValue())) {
		resp.addCookie(cookie1);
		resp.addCookie(cookie2);
		RequestDispatcher rd = req.getRequestDispatcher("welcome.html");
		rd.forward(req, resp);
	}
	else {
		RequestDispatcher rd1 = req.getRequestDispatcher("login.html");
		rd1.forward(req, resp);
	}
}
}
