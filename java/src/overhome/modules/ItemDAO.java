package com.overhome.modules;

public interface ItemDAO {
	public int read(String id) throws Exception;
	public void updateValue(int value, String id) throws Exception;
}
