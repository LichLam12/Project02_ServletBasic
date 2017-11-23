package wp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Countdown")
public class Countdown extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	int counter=10;
    public Countdown() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter(); //để cho code gọn hơn
		
		response.setContentType("text/html"); //kiểu text or html

		out.println("<html><head><title>Hello</title></head><body>");
		
		//nếu counter = 0 thì chỉ cần display 1 message
		if(counter==0) {
			out.println("<p>Rocket Lauched!</p>");
		}
		//nếu counter chưa đếm đc tơi 0, ta xét 1 request header và sau đó giảm counter
		else {
			out.println("<h2>"+counter+"</h2>");
			response.setHeader("Refresh","1"); //1: sau 1s browser tự động request
			--counter;
		}
		
		out.println("</body></html>");
		
	}

}
