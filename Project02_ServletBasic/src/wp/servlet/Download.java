package wp.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Download")
public class Download extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Download() {
        super();
    }
    //tạo mảng byte 2-4kg để đọc image (binary file)
    //cách làm: tạo fileinputstream sau đó chỉ định đường dẫn tới file
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//xét response type vì nó k còn đúng kiểu mặc định html nữa mà là image
		response.setContentType("image/png");
		response.setHeader("Content-Disposition","attachment;filename=ngoisaocodon.png");
		//attachment: hiện hộp thoại hỏi ta có muốn download trực tiếp hay là k
		//inline: file image sẽ đc trực tiếp hiển thị trên browser chứ k hỏi
		//B1 đọc image từ đĩa
		FileInputStream in=new FileInputStream("C:/Users/onlyoneeunhyuk2/eclipse-workspace/Project02_ServletBasic/WebContent/logo.png");
		OutputStream out= response.getOutputStream(); //dùng để sinh ra các binary output
		byte[] buffer=new byte[2048];
		int bytesRead;  //sl byte thực sự đọc từ file
		while((bytesRead=in.read(buffer))>0) {
			//B2 ghi image vào response khi chưa đọc đến cuối file
			out.write(buffer,0,bytesRead); //bắt đầu đọc ở vtri 0
				
		}
		//sau khi đọc đến cuối file và ghi nó vào response r thì đóng inputstream lại
		//outputstream thì tự đọng đóng bởi application server
		in.close();
		
		
		//1 phần thì URL của nó là Download nên tên file khi save là Download.png, để nói cho browser
		//biết tên thật của image ta phải dùng header content disposition
		
	}

}
