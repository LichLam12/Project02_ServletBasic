package wp.servlet;

import java.io.IOException;
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

@WebServlet("/GuestBook")
public class GuestBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GuestBook() {
		super();

	}

	// Khởi tạo dữ liệu trong hàm init
	/*
	 * public void init(ServletConfig config) throws ServletException {
	 * super.init(config); List<GuestBookEntry> entries = new
	 * ArrayList<GuestBookEntry>(); /* entries.add(new GuestBookEntry("Phuc",
	 * "Hello")); entries.add(new GuestBookEntry("Hieu", "Nice site"));
	 * entries.add(new GuestBookEntry("Nhan", "Hi")); entries.add(new
	 * GuestBookEntry("Tuyen", "See you soon")); entries.add(new
	 * GuestBookEntry("Thuy3", "See you soon"));
	 * getServletContext().setAttribute("entries", entries);
	 * 
	 * int a=0; entries.add(new GuestBookEntry(a++,"Phuc", "Hello"));
	 * entries.add(new GuestBookEntry(a++,"Hieu", "Nice site")); entries.add(new
	 * GuestBookEntry(a++,"Nhan", "Hi")); entries.add(new
	 * GuestBookEntry(a++,"Tuyen", "See you soon")); entries.add(new
	 * GuestBookEntry(a,"Thuy3", "See you soon"));
	 * getServletContext().setAttribute("entries", entries);
	 * getServletContext().setAttribute("Key", a); }
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * List<GuestBookEntry> entries = (List<GuestBookEntry>)
		 * getServletContext().getAttribute("entries");
		 * 
		 * PrintWriter out = response.getWriter(); response.setContentType("text/html");
		 * out.println("<html><head><title>Guest Book</title></head><body>");
		 * out.println("<h2>Guest Book</h2>"); out.println("<table border='1'>");
		 * out.println("<tr><th>Key</th><th>Name</th><th>Message</th></tr>"); for(int
		 * i=0;i<entries.size();i++) { GuestBookEntry entry = entries.get(i);
		 * entry.setKey(i); out.println("<tr><td>"+entry.getKey()+"</td><td>"
		 * +entry.getName()+" says:</td><td>"+entry.getMessage()
		 * +"</td><td><a href='EditEntry?key="+entry.getKey()+"'>Edit</td>" +
		 * "<td><a href='DeleteEntry?key="+entry.getKey()+"'>Delete</td></tr>"); }
		 * out.println("</table>");
		 * out.println("<p><a href='AddComment'>Leave a comment</a></p>"); out.
		 * println("<p><a href='AddCommentWithCookie'>Leave a comment (with cookie)</a></p>"
		 * ); out.
		 * println("<p><a href='AddCommentWithSession'>Leave a comment (with session)</a></p>"
		 * );
		 * 
		 * out.println("</body></html>");
		 */

		Connection conn = (Connection) DBConnection.CreateConnection();
		List<GuestBookEntry> list = GuestBookDAO.DisplayGuestBook(conn);
		request.setAttribute("guestbook", list);

		RequestDispatcher rd = request.getRequestDispatcher("GuestBook.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
