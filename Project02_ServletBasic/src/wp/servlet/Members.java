package wp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Members")
public class Members extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Members() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user=(String) request.getSession().getAttribute("user"); //tên attribute đặt s kug đc
		//Nếu có 1 session attribute "user" thì ta display trang này
		if(user!=null) {
		
			PrintWriter out=response.getWriter(); //để cho code gọn hơn
			
			response.setContentType("text/html");
	
			out.println("<html><head><title>Members</title></head><body>");
			out.println("<h2>This is members-only area!</h2>");
			out.println("<p>Welcome, " + user + "</p>");
			out.println("<p><a href='Logout'>Logout</p>");
			
			out.println("</body></html>");
		}
		else {
		//Ngược lại, ta redirect (chuyển hg) user đến trang login
			response.sendRedirect("Login");
		}
	}

}
