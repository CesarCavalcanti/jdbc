package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;
import db.DbIntergrityException;

public class DeletarDados {
	
public static void main(String[] args) {
		
		//Atualizar valores no banco de dados
		
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = DB.getConnection();
			st = conn.prepareStatement("DELETE FROM department"
					+"WHERE"
					+"Id = ?");
			st.setInt(1, 2);
			
			st.executeUpdate();
					
		}catch (SQLException e) {
			throw new DbIntergrityException(e.getMessage());
		}finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
}

}
