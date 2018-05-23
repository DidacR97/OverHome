package com.overhome.modules;

public class DAOManager {

	private static ItemDAO itemDAO;

	public static ItemDAO getItemDAO() {
		if(itemDAO == null){
			itemDAO = new ItemDAOImplement();
		}
		return itemDAO;
	}
}
