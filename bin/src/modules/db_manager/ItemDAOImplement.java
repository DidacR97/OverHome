package com.overhome.modules;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemDAOImplement implements ItemDAO {
	private static String GET = "SELECT VALUE FROM OH_VALUE WHERE UPPER(OBJECT_ID) = ?";
	private static String UPDATEVALUE = "UPDATE OH_VALUE SET VALUE = ? WHERE UPPER(OBJECT_ID) = ?";

	@Override
	public int read(String id) throws Exception{
		PreparedStatement sentencia = null;
		ResultSet result = null;
		Item item = null;
		try{
			sentencia = ConnectionManager.getConnection().prepareStatement(GET);
			sentencia.setString(1, id);
			result = sentencia.executeQuery();
			while (result.next()){
				item = new Item(id,result.getInt(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if(sentencia != null){
				try {
					sentencia.close();
				} catch (SQLException e) {
					throw new Exception("Error en MySQL", e);
				}
			}
		}
		return item.getValue();
	}

	@Override
	public void updateValue(int value, String id) throws Exception{
		PreparedStatement query = null;
		try{
			query = ConnectionManager.getConnection().prepareStatement(UPDATEVALUE);
			query.setInt(1, value);
			query.setString(2, id);
			if(query.executeUpdate() == 0){
				throw new Exception("Error al guardar, es posible que no se conserven los datos.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if(query != null){
				try {
					query.close();
				} catch (SQLException e) {
					throw new Exception("Error en MySQL", e);
				}
			}
		}
	}
}