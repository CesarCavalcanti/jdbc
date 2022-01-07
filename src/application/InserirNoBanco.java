package application;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class InserirNoBanco {

	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DB.getConnection();
			st = conn.prepareStatement(
					"INSERT INTO seller "
					+ "(Name,Email,BirthDate,BaseSalary,DepartmentId)"
							+"VALUES"
					+"(?,?,?,?,?)");
			st.setString(1,"Cesar sena");
			st.setString(2, "Cesar@gmail.com");
			st.setDate(3, new Date(sdf.parse("01/06/2022").getTime()));
			st.setDouble(4, 3000.0);
			st.setInt(5,4);
			
			st.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (ParseException e) {
			e.printStackTrace();
		}finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}	
	}

}
