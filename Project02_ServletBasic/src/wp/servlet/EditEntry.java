package wp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

import wp.DAODB.GuestBookDAO;
import wp.DB.DBConnection;
import wp.model.GuestBookEntry;

@WebServlet("/EditEntry")
public class EditEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private boolean flag=false;   
    public EditEntry() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Connection conn = (Connection) DBConnection.CreateConnection();
    	response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		
    	int id = Integer.parseInt(request.getParameter("temp"));
    	String name=request.getParameter("name");
    	String message=request.getParameter("message");
		boolean kt = GuestBookDAO.EditGuestBook(id, name, message, conn);
		if(kt)
		{
			System.out.println("edit thành công");
		}
		RequestDispatcher rd = request.getRequestDispatcher("GuestBook");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	
	/*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		//Lấy dl entries từ scope
				List<GuestBookEntry> entries = (List<GuestBookEntry>) getServletContext().getAttribute("entries");
				//
				PrintWriter out = response.getWriter();
				response.setContentType("text/html");   // Set contentype khi xuat ra mot file html.
				int key = Integer.parseInt(request.getParameter("key"));
				for(GuestBookEntry entry:entries)
				{
					if(entry.getKey()==key)
					{
						out.println("<html><head><title>Edit Comment</title><head><body>");
						out.println("<form action='EditEntry' method='Post'>");
						out.println("Key:<input type='text' name='key' readonly value='"+ entry.getKey() +"'/><br/>");
						out.println("Name:<input type='text' name='name' value='"+ entry.getName() +"'/><br/>");
						out.println("Message:<textarea name='message' rows='5' cols='60'>"+ entry.getMessage() +"</textarea>");
						out.println("<input type='hidden' name='index' value='"+entry.getKey()+"'>");
						out.println("<input type='submit' name='editentry' value='Edit'/>");
						
						out.println("</form>");
						out.println("</body></html>");
						flag=true;
						break;
					}
				}	
					//response.sendRedirect("GuestBook");
				if(flag==false) {
					out.println("<html><head><title>Edit Entry</title></head><body>");
					out.println("<h3>Comment khong ton tai!</h3>");
					out.println("<form action'EditEntry' method='Post'><input type='submit' name='OK' value='OK'></form>");
					out.println("</body></html>");
				}
				/*int key = Integer.parseInt(request.getParameter("key"));
				GuestBookEntry entry = new GuestBookEntry();
				try
				{
					entry = entries.get(key);
				}
				catch(IndexOutOfBoundsException e)
				{
					System.out.println("sai roi");
					
				}

				//Sau khi lấy đc entry tại index đó r thì gán gtri cho name và message
				PrintWriter out=response.getWriter(); //để cho code gọn hơn
				
				response.setContentType("text/html"); //kiểu text or html

				//Đoạn code sinh ra trang html (bằng cách sinh ra các cặp thẻ đóng mở)
				out.println("<html><head><title>Edit Entry</title></head><body>");
				out.println("<form action='EditEntry' method='Post'>");
				out.println("Name : <input type='text' name='name' value='"+entry.getName()+"'/> <br/><br/>");
				out.println("Message : <textarea name='message' rows='5' cols='60'>"+entry.getMessage()+"</textarea><br/><br/>");
				out.println("<input type='hidden' name='key' value='"+entry.getKey()+"'/>");
				out.println("<input type='submit' name='add' value='SUBMIT'>");	
				out.println("</form>");
				out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		if(flag) {
		//Lấy dl entries từ scope
		List<GuestBookEntry> entries = (List<GuestBookEntry>)getServletContext().getAttribute("entries");
		//Lấy dl submit từ form trên
		String name=request.getParameter("name");
		String message=request.getParameter("message");
		
		//Sau khi có key(hay id) của entry đó r, set lại entry có key đó đó
		int key = Integer.parseInt(request.getParameter("key"));
		//
		//int index = Integer.parseInt(request.getParameter("index"));
		for(GuestBookEntry entry:entries)
		{
			if(entry.getKey()==key)
			{
				entry.setName(name);
				entry.setMessage(message);
				break;
			}
		}		

		}
		
		//
		/*entries.get(key).setName(name);
		entries.get(key).setMessage(message);
		try
		{
			entries.get(key).setKey(key);
		}
		catch(IndexOutOfBoundsException e)
		{
			//nếu như tại vị trí này, có 1 entry khác đã đc xóa bởi trình duyệt nào đó khiến các entry bị thay đổi
			//trật tự (mà trình duyệt hiện tại chưa F5 nên chưa cập nhật tình trạng có entry bị xóa r),
			//Vì vậy khi ta nhấn edit 1 entry như thế nó sẽ báo lỗi.
			System.out.println("sai roi");
			//sd javascript xuat cau lenh alert
			
		}*/
		//entries.add(new GuestBookEntry(name,message));
		//sau đó, gửi user này tới URL display (display GuestBook sẽ xử lý và đưa lên trang HTML)
		//response.sendRedirect("GuestBook");
	//}
}



