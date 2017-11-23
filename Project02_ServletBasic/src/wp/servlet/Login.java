package wp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Login() {
        super();
       
    }
    //Hình thành form Login
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter(); //để cho code gọn hơn
		
		response.setContentType("text/html"); //kiểu text or html

		//Đoạn code sinh ra trang html (bằng cách sinh ra các cặp thẻ đóng mở)
		out.println("<html><head><title>Login</title></head><body>");
		out.println("<form action='Login' method='Post'>");
		out.println("Username: <input type='text' name='username' /><br/>");
		out.println("Password: <input type='text' name='password' /><br/>");
		out.println("<input type='submit' name='submit' value='Submit'/><br/>");
		
		out.println("</form>");
		out.println("</body></html>");
	}
	
	//Xử lý form Login
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		//Kiểm tra username và pass, đúng thì redirect user đến trang Members
		if(username.equals("lich")&& password.equals("1234")) {
			request.getSession().setAttribute("user", username);
			//tùy thuộc vào trang Members muốn hiển thị gì ra cái gì thì ta xét thuộc tính nó ở username trong ("user",username)
			response.sendRedirect("Members");
		}
		else {
		//Ngược lại, redirect user đến trang Login
			response.sendRedirect("Login");

		}
	}
	

}
