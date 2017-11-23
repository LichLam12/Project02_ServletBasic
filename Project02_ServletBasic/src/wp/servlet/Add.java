package wp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//Các request header chứa nhìu info
//Mỗi request header đc tke cho những mục đích khác nhau
//C1: 1 pthuc lấy input từ user phổ biến hơn k sd request header mà sd request parameter 
//(nó có thể đc chỉ định trực tiếp như 1 phần của URL, mỗi parameter cách nhau bởi dấu &,
//trc khi viết phải bắt đầu = dấu ?)
//Cách 2: dùng Web forms
@WebServlet("/Add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Add() {
        super();
    }
    //Pthuc getParameter sẽ đc sử dụng thg xuyên
    //getParameterNames() là tên của 1 parameter, đặt tên vì ta có thể dùng lại,dùng chung
    //getParameterValuesI(String p) trả về all value (có thể là mảng kiểu chuỗi) của parameter đó
    //Add?a=10&a=20 vào URL của ví dụ này thì getParameterValuesI(a) trả về mảng có 2 chuỗi "10" và "20"
    //Nhưng khi chạy thì nó lấy gtri đầu tiên là 10
    //getParameterMap() trả về 1 map chưa parameterNames và 1 map chứa parameterValues
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//int a=0, b=0;
		//if(request.getParameter("a")!=null)
		//	a = Integer.parseInt(request.getParameter("a")); //1
		//if(request.getParameter("b")!=null)
		//	b = Integer.parseInt(request.getParameter("b")); //2
		PrintWriter out=response.getWriter(); //để cho code gọn hơn

		String a=request.getParameter("a");
		String b=request.getParameter("b");
		if(a==null || b==null || a.trim().length()==0 || b.trim().length()==0) {
			response.sendRedirect("AddForm.html");
			return; //đi đến AddForm và dừng việc thực thi pthuc tại đây, k đi tiếp những lệnh tt ở dưới
		}

		response.setContentType("text/html"); //kiểu text or html

		
		
		
		//senRedirect k có terminate, nó link tới form nhưng vẫn thực thi những lệnh tt trong doGet
		//Gia sử chỉ có 1,2: Khi chạy vào serlet Add thì thêm ?a=10&b=20 vào URL mới chạy đc
		//vì ta cc 2 parameter a,b là kiểu int chứ k cho gtri, nên mặc định null
		//Như v, khi chạy con trỏ sẽ trỏ tới gtri null gây ra Exception
		//->ta có thể cc gtri mặc định cho a,b là 0 và xét đk if để tránh exception xảy ra
		
		int sum=Integer.parseInt(a)+Integer.parseInt(b);
		//Đoạn code sinh ra trang html (bằng cách sinh ra các cặp thẻ đóng mở)
		out.println("<html><head><title>Add</title></head><body>");
		out.println("<p>" + a + "+" + b + "=" + sum +"</p>");
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		//thêm dòng code này thì doPost sẽ chạy như doGet nhưng các parameter k hiển thị trên URL nữa
		//nếu cta sử TCP/IP kiểm soát các post request thì ta sẽ thấy các parameter này đặt trong phần message body của request
	}

}
