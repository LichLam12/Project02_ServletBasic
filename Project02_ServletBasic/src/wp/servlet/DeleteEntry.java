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

@WebServlet("/DeleteEntry")
public class DeleteEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteEntry() {
        super();
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = (Connection) DBConnection.CreateConnection();
    	
    	int id = Integer.parseInt(request.getParameter("temp"));
		boolean kt = GuestBookDAO.DeleteGuestBook(id, conn);
		
		if(kt)
		{
			System.out.println("xóa thành công");
		}
		RequestDispatcher rd = request.getRequestDispatcher("GuestBook");
		rd.forward(request, response);
	}
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
    
    /*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Lấy dl entries từ scope
		List<GuestBookEntry> entries = (List<GuestBookEntry>)getServletContext().getAttribute("entries");
		//Lấy index từ request parameter (parameter chính là request sau dấu / cuối trên thanh URL, mỗi parameter cách nhau bởi dấu &
		//nhưng do ta truy cập vào đường link của delete nên chỉ có 1 parameter duy nhất, ta lấy index của nó)
		
		int key = Integer.parseInt(request.getParameter("key"));
		for(GuestBookEntry entry:entries)
		{
			//GuestBookEntry entry = entries.get(i); 
			if(entry.getKey()==key)
			{
				entries.remove(entry);
				break;
			}
		}
		response.sendRedirect("GuestBook");
		
		/*int key = Integer.parseInt(request.getParameter("key"));
		//Sau khi có key của entry đó r, xóa entry có key đó
		try
		{
			entries.remove(key);
		}
		catch(IndexOutOfBoundsException e)
		{
			//nếu như tại vị trí này, có 1 entry khác đã đc xóa bởi trình duyệt nào đó khiến các entry bị thay đổi
			//trật tự, vì vậy khi ta nhấn xóa 1 entry như thế nó sẽ báo lỗi.
			System.out.println("sai roi");
		}
		
		//entries.remove(index);
		//sau đó, gửi user này tới URL display (display GuestBook sẽ xử lý và cập nhật lại trang HTML)
		response.sendRedirect("GuestBook");*/
	//}

	

}


