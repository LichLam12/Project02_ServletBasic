package wp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Logout() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate();
		//sau khi invalidate trong session đó và remove all session attribute
		//thì ta đẩy user về trang Login
		response.sendRedirect("Login");
		
		//Ngoài ra, còn có session timeout, tức sau 1 khoảng tgian xđ mà user k tương tác
		//thì server sẽ tự động invalidate session
		//Vd: tomcat sau 30p
		//để thiết lập
		//<session-config>
		//	<session-timeout>60</session-timeout>
		//</session-config>
		//đặt trong file web.xml
	}

}
