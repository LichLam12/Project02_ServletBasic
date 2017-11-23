package wp.servlet;

import java.io.IOException;

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

@WebServlet("/Display_Add_EditEntry")
public class Display_Add_EditEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Display_Add_EditEntry() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
Connection conn = (Connection) DBConnection.CreateConnection();
    	
    	if(request.getParameter("temp")==null)
    	{
    		RequestDispatcher rd = request.getRequestDispatcher("AddEntry.jsp");
    		rd.forward(request, response);
    	}
    	else {
        	int id = Integer.parseInt(request.getParameter("temp"));

    		GuestBookEntry entry = GuestBookDAO.Display_1Entry(id,conn);
    		request.setAttribute("entry", entry);

    		RequestDispatcher rd = request.getRequestDispatcher("EditEntry.jsp");
    		rd.forward(request, response);
    	}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
