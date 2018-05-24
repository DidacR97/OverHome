package com.overhome;

import com.overhome.modules.UDPServer;
import com.overhome.modules.DAOManager;

public class StartUDPServer {

	public static void main(String[] args) {
		updateInfo(UDPServer.start_UPD_Server(args));
	}

	public static void updateInfo(String data){
		String[] action = new String[2];
		int value = 0;
		action = data.split(";");

		try {
			value = DAOManager.getItemDAO().read(action[1]);

			switch(value){
				case 0: value = 1;
					break;

				case 1: value = 0;
					break;
			}

			DAOManager.getItemDAO().updateValue(value, action[1]);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}