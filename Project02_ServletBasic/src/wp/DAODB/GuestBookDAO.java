package wp.DAODB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import wp.model.GuestBookEntry;

public class GuestBookDAO {
	
	public static List<GuestBookEntry> DisplayGuestBook(Connection conn) {
		// Lấy ra kết nối tới cơ sở dữ liệu.

		List<GuestBookEntry> list = new ArrayList<GuestBookEntry>();

		String sql = "select * from GuestBookTABLE";

		try {
			// Tạo một đối tượng PreparedStatement.
			PreparedStatement psmt = conn.prepareCall(sql);

			ResultSet rs = psmt.executeQuery();

			while (rs.next()) {
				GuestBookEntry nv = new GuestBookEntry();
				
				nv.setId(rs.getInt("id"));
				nv.setName(rs.getNString("name"));
				nv.setMessage(rs.getNString("message"));

				list.add(nv);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;
	}
	
	public static boolean InsertGuestBook(String name, String message, Connection conn) {
		boolean t = false;

		// Câu lệnh gọi thủ tục (***)
		String sql = "{call procThemGuestBook(?,?)}";

		try {
			// Tạo một đối tượng CallableStatement.
			CallableStatement cstm = conn.prepareCall(sql);
		
			cstm.setNString(1, name);
			cstm.setNString(2, message);
			
			cstm.executeUpdate();

			cstm.close(); // k đóng lại thì nếu gọi store khác nữa sẽ k đc

			t = true;
		}

		catch (SQLException ex) {
			// e.printStackTrace();
			System.out.println(ex.getMessage());
		}

		return t;
	}
	
	public static boolean EditGuestBook(int id,String name, String message, Connection conn) {
		boolean t = false;

		// Câu lệnh gọi thủ tục (***)
		String sql = "{call procEditGuestBook(?,?,?)}";

		try {
			// Tạo một đối tượng CallableStatement.
			CallableStatement cstm = conn.prepareCall(sql);
		
			cstm.setInt(1, id);
			cstm.setNString(2, name);
			cstm.setNString(3, message);
			
			cstm.executeUpdate();

			cstm.close(); // k đóng lại thì nếu gọi store khác nữa sẽ k đc

			t = true;
		}

		catch (SQLException ex) {
			// e.printStackTrace();
			System.out.println(ex.getMessage());
		}

		return t;
	}
	
	public static boolean DeleteGuestBook(int id, Connection conn) {
		boolean t = false;

		// Câu lệnh gọi thủ tục (***)
		String sql = "{call procDeleteGuestBook(?)}";

		try {
			// Tạo một đối tượng CallableStatement.
			CallableStatement cstm = conn.prepareCall(sql);
		
			cstm.setInt(1, id);
			
			cstm.executeUpdate();

			cstm.close(); // k đóng lại thì nếu gọi store khác nữa sẽ k đc

			t = true;
		}

		catch (SQLException ex) {
			// e.printStackTrace();
			System.out.println(ex.getMessage());
		}

		return t;
	}
	
	public static GuestBookEntry Display_1Entry(int id, Connection conn) {
		GuestBookEntry nv = new GuestBookEntry();

		String sql = "select * from GuestBookTABLE where id='"+id+"'";

		try {
			// Tạo một đối tượng PreparedStatement.
			PreparedStatement psmt = conn.prepareCall(sql);

			ResultSet rs = psmt.executeQuery();

			while (rs.next()) {

				nv.setId(rs.getInt("id"));
				nv.setName(rs.getNString("name"));
				nv.setMessage(rs.getNString("message"));

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return nv;
	}

}
