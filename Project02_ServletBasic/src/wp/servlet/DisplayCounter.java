package wp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DisplayCounter")
//nếu DisplayCounter chạy trước RequestCounter thì nó sẽ hiển thị "You are visitor # null."
//servlet ở bên RequestCounter mặc định gtri của counter là 0, nhưng tại sao chaỵ trước lại là null
//để giải quyết -> loadOnStartup: tb cho app server bt cái servlet nào cần phải đc tạo ngay sau khi application disploy vào trong server
//hay nói: trc khi user truy xuất tới servlet đó thì servlet đó phải đc tạo rồi.

public class DisplayCounter extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DisplayCounter() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext servletContext=getServletContext();
		
		//get counter
		Integer counter = (Integer) getServletContext().getAttribute("counter");
		//counter trong application scope là kiểu object nên phải ép kiểu
		
		PrintWriter out=response.getWriter(); //để cho code gọn hơn
		
		//Đoạn code sinh ra trang html (bằng cách sinh ra các cặp thẻ đóng mở)
		out.println("<html><head><title>Display Counter</title></head><body>");
		out.println("<h2>You are visitor # " + counter + ".</h2>");
		out.println("</body></html>");
		
		//XÉT CONTENT TYPE Đúng CHO RESPONSE (là html, đôi khi là image, file javascript,...)
		response.setContentType("text/html"); //kiểu text or html
	}

}
