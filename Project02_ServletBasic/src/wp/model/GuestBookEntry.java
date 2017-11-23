package wp.model;

//Các ứng dụng web đều đc pt thành dl (các guestbook entries,mỗi entry bao gồm name và message, đc lưu trữ với class)
//quản lý số lượng của các entries = LIST
// và các pthuc xử lý trên dữ liệu đó (display,add,delete,edit)



public class GuestBookEntry {
	
	private String name;
	private String message;
	private int id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
