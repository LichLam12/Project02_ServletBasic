package wp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//Nếu trong ứng dụng web có từ 2 servlet trở lên, thì dùng servlet mapping để servlet nào xử lý request nào
//Ta map phần <path> trong http://<host>/<app>/<path> với URL pattern mà đc kb bởi servlet"
@WebServlet({"/HelloWorld","/a","/b","/member/*"}) //HelloWorld là URL pattern, request gửi đến servlet này xử lý
//vì ở đây có nhìu URP pattern -> mảng kiểu chuỗi.
//member/* tức sau dấu / đó có cái gì nó vẫn xử lý và chạy đc file html bên dưới


	//lớp servlet cần phải đc kế thừa từ cái lớp cha HttpServlet
	//(lớp cha chứa qly việc tương tác giữa cái servlet với app server)
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HelloWorld() {
        super();
        //gõ hotkey trong eclipse: tìm
    }
    //servlet ở đây chỉ là web app thông thg, k chạy bởi user nên k có hàm main
    //doGet đc gọi mỗi khi server nhận 1 request, server sẽ past tới cho pthuc doGet như tham số
    //đầu vào, sau đó doGet xử lý request, sau đó nó sinh ra response chứa nội dung trong đó.
    //response sau đó đc app server gửi trả về browser và browser hiển thị lên response đó.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter(); //để cho code gọn hơn
		//Tại sao ta lại thay thế system.out.print() = response.getWriter().print()
		//->Thay vì ghi output ra console như thông thường, ta ghi vào http response
		//sau đó response gửi về cho browser...
		//Chúng đều là output hết nhưng chỉ thực hiện khác cách.
		
		//XÉT CONTENT TYPE Đúng CHO RESPONSE (là html, đôi khi là image, file javascript,...)
		response.setContentType("text/html"); //kiểu text or html
		
		//Đoạn code sinh ra trang html (bằng cách sinh ra các cặp thẻ đóng mở)
		out.println("<html><head><title>Hello</title></head><body>");
		out.println("<h2>Hello world</h2>");
		out.println("</body></html>");
		//nếu ta xuất text thì k cần xét content type của response (getWriter sinh ra text)
		//nhưng ta xuất file html nên ta xét content type
		
		
		//CMT: Serlet sinh ra 1 trang html nó sẽ đưa nội dung html vào object response
		//response sau đó đc app server gửi trả về browser và browser nhận file html
		// và hiển thị lên.
		
		//code bị sai nên copy link khi chạy run on server chạy trên trình duyệt web, mở view page source
		//để xem sẽ dễ phát hiện lỗi hơn.
		
		
		
		
		//response.getWriter().print("Hello world!"); //lệnh để sinh ra 1 text
		//text này sẽ đc gửi về cho browser và browser sẽ in dòng này lên trình duyệt web cho ta xem
	}
}
