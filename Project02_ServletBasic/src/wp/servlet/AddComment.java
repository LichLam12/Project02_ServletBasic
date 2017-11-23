package wp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wp.model.GuestBookEntry;

@WebServlet("/AddComment")
public class AddComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddComment() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out=response.getWriter(); //để cho code gọn hơn
		
		response.setContentType("text/html"); //kiểu text or html

		//Đoạn code sinh ra trang html (bằng cách sinh ra các cặp thẻ đóng mở)
		out.println("<html><head><title>Add Comment</title></head><body>");
		out.println("<form action='AddComment' method='Post'>");
		out.println("Name: <input type='text' name='name' /><br/>");
		out.println("Message: <textarea name='message' rows='5' cols='60' /></textarea>");
		out.println("<input type='submit' name='add' value='add'/>");
		
		out.println("</form>");
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		//Lấy dl entries từ scope
		List<GuestBookEntry> entries = (List<GuestBookEntry>)getServletContext().getAttribute("entries");
		//Lấy dl submit từ form trên
		String name=request.getParameter("name");
		String message=request.getParameter("message");
		
		int oldkey ;
		oldkey  = (Integer)(getServletContext().getAttribute("Key"));
		int currentkey = oldkey+1;
		getServletContext().setAttribute("key", currentkey);
		//entries.add(new GuestBookEntry(currentkey,name, message));
		response.sendRedirect("GuestBook"); 
		
		/*
		//sau đó, add vào entries
		entries.add(new GuestBookEntry(name, message));
		//sau đó, gửi user này tới URL display (display GuestBook sẽ xử lý và đưa lên trang HTML)
		response.sendRedirect("GuestBook");*/
		
	}

}
