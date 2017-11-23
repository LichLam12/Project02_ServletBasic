package wp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//Servlet chỉ bị hủy khi server bị đẩy ra ngoài...

//SHARE SERVLET, trong bài này ta share biến counter giữa 2 servlet
//Trong ứng dụng java web, 2 servlet đc xem như 2 program khác nhau, chứ k phải 2 class trong program->sd app scope: vùng sd để lưu trữ và truy xuất dl
//DL sẽ nằm mãi trong đó khi ứng dụng vẫn đang chạy, dl đó sẽ đc chia sẻ cho all các servlet trong toàn application
//dùng setattribute để lưu object vào app scope, lấy tên nó bằng cách sd pthuc getattribute


@WebServlet(urlPatterns={"/RequestCounter"}, loadOnStartup=1)
//quy ước: sử dụng element: loadOnStartup thì mặc định tên của element trước là urlPatterns
//nếu có 4 servlet cho loadOnStartup thì ta thiết lập gri 1,2,3,4, nào nhỏ sẽ chạy trước
//cho dù mình run on server của servlet thứ 3,...

public class RequestCounter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//Tạo biến nhận giá trị counter để điếm
	//int counter;
    public RequestCounter() {
        super();
    
    }
    //Pthuc init này ghi đề pthuc init trong lớp cha -> gọi init trong lớp cha (nhất định)
    //nếu k gọi thì ServletConfig sẽ k đc khởi tạo đúng
    //Pthuc init chỉ gọi 1 lần khi servlet đc khởi tạo, đây là cách đc dùng để ktao các biến
    //Tại sao k kbao biến trong constructor mà lại dùng init
    //Vì vc ktao trong Constructor k thể truy xuất tới servlet context bên trong constructor
	public void init(ServletConfig config) throws ServletException {
		super.init(config);;
		int counter=0;
		getServletContext().setAttribute("counter", counter);
	}
	//Dựa trên request ta sẽ bt nó sẽ gửi tới pthuc doGet hay doPost,...
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext servletContext=getServletContext();
		
		//get counter
		Integer counter = (Integer) servletContext.getAttribute("counter");
		//counter trong application scope là kiểu object nên phải ép kiểu
		
		//increment counter
		counter++; //mỗi lần request lại trang giá trị counter sẽ tăng thêm 1 đv, do doGet đc gọi sau mỗi lần request
		
		//set counter too application scope (để các servlet khác lấy đc gtri counter khi đc update)
		servletContext.setAttribute("counter", counter); //lưu nó lại app scope
		
		PrintWriter out=response.getWriter(); //để cho code gọn hơn
		
		//Đoạn code sinh ra trang html (bằng cách sinh ra các cặp thẻ đóng mở)
		out.println("<html><head><title>Request Counter</title></head><body>");
		out.println("<h2>The counter is incremented</h2>");
		out.println("</body></html>");
		
		//XÉT CONTENT TYPE Đúng CHO RESPONSE (là html, đôi khi là image, file javascript,...)
		response.setContentType("text/html"); //kiểu text or html
	}

}
