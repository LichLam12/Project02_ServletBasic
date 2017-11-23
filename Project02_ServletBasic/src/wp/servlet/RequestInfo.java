package wp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Dùng tool TCP/IP Monitor để hiển thị các HTTP Request và HTTP Response
//Chức năng nó gần giống như 1 bracti server v, nó chuyển qua lại giữa client và server
//nó như là 1 gđ trung gian tương tác qua lại giữa client và server, giúp ta ksoat đc request và response
//điều này cta k thể làm nếu như chỉ có browser mà k có TCP/IP Monitor
//Sau đây mình sd TCP/IP Monitor để truy xuất tới trang html mà mình đã làm trc đó
@WebServlet("/RequestInfo")
public class RequestInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RequestInfo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter(); //để cho code gọn hơn

		//Đoạn code sinh ra trang html (bằng cách sinh ra các cặp thẻ đóng mở)
				out.println("<html><head><title>RequestInfo</title></head><body>");
				//trả về tên pthuc là GET
				out.println("<p>Method: "+request.getMethod()+"</p>");
				out.println("<p>ContextPath: "+request.getContextPath()+"</p>");
				//full path
				out.println("<p>URL: "+request.getRequestURL()+"</p>");
				//contextpath + path để match với serlet của mình
				out.println("<p>URI: "+request.getRequestURI()+"</p>");
				//address ipv6
				out.println("<p>RemoteAddr: "+request.getRemoteAddr()+"</p>");
				//Browser with Client có hỗ trợ pthuc nén, Accept-Encoding là 1 header trong các header ở phần Size trong
				//TCP/IP Monitor (từ dòng thứ 2 đến hết đều là header)
				if(request.getHeader("Accept-Encoding").indexOf("gzip")>=0)
					out.println("<p>Gzip supported.</p>");
				else
					out.println("<p>Gzip not supported.</p>");
				out.println("</body></html>");
				//XÉT CONTENT TYPE Đúng CHO RESPONSE (là html, đôi khi là image, file javascript,...)
				response.setContentType("text/html"); //kiểu text or html
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
