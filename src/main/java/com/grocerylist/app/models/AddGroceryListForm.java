package com.grocerylist.app.models;

public class AddGroceryListForm extends GroceryList{

	private String addItem = "false";

	public String getAddItem() {
		return this.addItem;
	}

	public void setAddItem(String addItem) {
		this.addItem = addItem;
	}

	public GroceryList asGroceryList() {
		GroceryList groceryList = new GroceryList();
		groceryList.setName(this.getName());
		groceryList.setCategory(this.getCategory());
		groceryList.setLocation(this.getLocation());
		groceryList.setItems(this.getItems());

		return groceryList;
	}

}
