package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;

public class AtualizarDados {

public static void main(String[] args) {
		
		//Atualizar valores no banco de dados
		
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = DB.getConnection();
			st = conn.prepareStatement(
					"UPDATE seller"
					+"SET BaseSalary = BaseSalary + ?"
							+"WHERE"
					+"(DepartmentId = ?)");
			st.setDouble(1, 200.0);
			st.setInt(2, 2);
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
}
}
