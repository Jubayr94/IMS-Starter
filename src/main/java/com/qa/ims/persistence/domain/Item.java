package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Item {

	private Long itemID;
	private String itemName;
	private Double price;

	public Item(String itemName, Double price) {
		this.setItemName(itemName);
		this.setPrice(price);
	}

	public Item(Long itemID, String itemName, Double price) {
		this.setItemID(itemID);
		this.setItemName(itemName);
		this.setPrice(price);
	}

	public Long getItemID() {
		return itemID;
	}

	public void setItemID(Long itemID) {
		this.itemID = itemID;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item [itemID=" + itemID + ", itemName=" + itemName + ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(itemID, itemName, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return Objects.equals(itemID, other.itemID) && Objects.equals(itemName, other.itemName)
				&& Objects.equals(price, other.price);
	}

	
	
}
