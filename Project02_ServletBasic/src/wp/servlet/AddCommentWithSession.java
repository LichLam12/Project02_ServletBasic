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

@WebServlet("/AddCommentWithSession")
public class AddCommentWithSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
    int idSeed=100;
    public AddCommentWithSession() {
        super();
    }
  
    //doGet có nv hiển thị form, form này đc submit đến địa chỉ @WebServlet("/AddCommentWithCookie")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out=response.getWriter(); //để cho code gọn hơn
		
		response.setContentType("text/html"); //kiểu text or html

		//Đoạn code sinh ra trang html (bằng cách sinh ra các cặp thẻ đóng mở)
		out.println("<html><head><title>Add Comment</title></head><body>");
		out.println("<form action='AddCommentWithSession' method='Post'>");
		
		//Lay username bang dong code don gian, k phuc tap nhu cookie
		String name = (String) request.getSession().getAttribute("name"); //truy xuất đến dl lưu trong session scope
		//session cope và application scope đều đc share toàn bộ servlet, nhưng guestbook entry thì đc lưu trong app scope.
		//Dl App scope là như nhau trong all client, browser (Mỗi application chỉ có 1 application scope thôi, any data nào đc lưu trong app scope đều có thể đc truy xuất bởi any client, browser nào)
		//Session scope chỉ chỉ định trong pvi session thôi (cụ thể cho từng user hay browser.)
		//Trong cùng 1 application nhưng dữ liệu trong scope sẽ khác nhau. (như việc chạy trên chrome và eclipse v, dl session k hề giống nhau)
		//----> Trong bài này, guestbook entry là dl trong app scope, username là dl trong session scope
		
		if(name!=null) //có username trong cookie
			out.println("Name: "+name+"<br/>");
		else //ngược lại, ta display (in ra) input field
			out.println("Name: <input type='text' name='name' /> <br/>");
		
		out.println("Message: <textarea name='message' rows='5' cols='60' /></textarea>");
		out.println("<input type='submit' name='add' value='add'/>");
		
		out.println("</form>");
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		/*
		//name ở đây có thể đến từ cookie hoặc request parameter (nếu như c có cookie -> If)
		//Lấy name từ cookie
		String name = (String) request.getSession().getAttribute("name");
		
		if(name==null) { //name k tồn tại trong cookie -> nằm trong request parameter
			//Lấy dl submit từ form trên: lấy user input
			name=request.getParameter("name");
			request.getSession().setAttribute("name", name); //lưu vào session scope
		}
		String message=request.getParameter("message");
		
		//Tạo guestbook entry mới
		GuestBookEntry entry=new GuestBookEntry(idSeed++,name,message);
		
		//Thêm 1 entry mới vào guestbook
			//Lấy dl entries từ scope
		List<GuestBookEntry> entries = (List<GuestBookEntry>)getServletContext().getAttribute("entries");
		entries.add(entry);
		
		//send user back to (về cho) guestbook
		response.sendRedirect("GuestBook");
		*/
	}

}
