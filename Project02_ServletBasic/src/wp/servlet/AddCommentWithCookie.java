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

@WebServlet("/AddCommentWithCookie")
public class AddCommentWithCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
    int idSeed=100;
    public AddCommentWithCookie() {
        super();
    }
    //get cookie từ request, add cookie từ response
    private String getUsernameFromCookie(HttpServletRequest request) {
    	
    	Cookie[] cookies = request.getCookies();
    	if(cookies!=null)
    		//nếu mảng này khác rỗng thì ta duyệt qua mảng này
    		for(Cookie cookie: cookies)
    			//nếu như cookie tồn tại name = với 'name' (tìm cookie với tên mà ta muốn)
    			if(cookie.getName().equals("name"))
    				return cookie.getValue();
    	return null;
    }
    //doGet có nv hiển thị form, form này đc submit đến địa chỉ @WebServlet("/AddCommentWithCookie")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out=response.getWriter(); //để cho code gọn hơn
		
		response.setContentType("text/html"); //kiểu text or html

		//Đoạn code sinh ra trang html (bằng cách sinh ra các cặp thẻ đóng mở)
		out.println("<html><head><title>Add Comment</title></head><body>");
		out.println("<form action='AddCommentWithCookie' method='Post'>");
		
		//Nếu ta đã có name trong cookie r, thì sau đó chỉ cần display cái name thoi
		String name = getUsernameFromCookie(request);
		
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
		
		//name ở đây có thể đến từ cookie hoặc request parameter (nếu như c có cookie -> If)
		//Lấy name từ cookie
		String name=getUsernameFromCookie(request);
		if(name==null) { //name k tồn tại trong cookie -> nằm trong request parameter
			//Lấy dl submit từ form trên: lấy user input
			name=request.getParameter("name");
			Cookie cookie=new Cookie("name",name);
			response.addCookie(cookie); 
			//lần đầu khi chưa có user trong cookie thì nó show input field->điền->submit->doPost
			//lấy name ở 2 dòng trên bỏ vào cookie, all request sau đó sẽ chứa cookie này.
		}
		String message=request.getParameter("message");
		
		//Tạo guestbook entry mới
		//GuestBookEntry entry=new GuestBookEntry(idSeed++,name,message);
		
		//Thêm 1 entry mới vào guestbook
			//Lấy dl entries từ scope
		List<GuestBookEntry> entries = (List<GuestBookEntry>)getServletContext().getAttribute("entries");
		//entries.add(entry);
		
		//send user back to (về cho) guestbook
		response.sendRedirect("GuestBook");
		
	}

}
