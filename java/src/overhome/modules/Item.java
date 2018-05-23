package com.overhome.modules;

public class Item {
  private String id;
  private int value;

  public Item(String id, int value) {
	super();
	this.id = id;
	this.value = value;
  }

  public String getId() {
	return id;
  }

  public void setId(String id) {
	this.id = id;
  }

  public int getValue() {
	return value;
  }

  public void setValue(int value) {
	this.value = value;
  }
}