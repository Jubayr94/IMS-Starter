package com.qa.ims.persistence.domain;

import java.util.Objects;

public class OrderItem {

	private Long ordersItemsID;
	private Long fkOrderID;
	private Long fkItemID;
	private Long quantity;

	public OrderItem(Long fkOrderID, Long fkItemID, Long quantity) {
		this.setFkOrderID(fkOrderID);
		this.setFkItemID(fkItemID);
		this.setQuantity(quantity);
	}

	public OrderItem(Long ordersItemsID, Long fkOrderID, Long fkItemID, Long quantity) {
		this.setOrdersItemsID(ordersItemsID);
		this.setFkOrderID(fkOrderID);
		this.setFkItemID(fkItemID);
		this.setQuantity(quantity);
	}

	public Long getOrdersItemsID() {
		return ordersItemsID;
	}

	public void setOrdersItemsID(Long ordersItemsID) {
		this.ordersItemsID = ordersItemsID;
	}

	public Long getFkOrderID() {
		return fkOrderID;
	}

	public void setFkOrderID(Long fkOrderID) {
		this.fkOrderID = fkOrderID;
	}

	public Long getFkItemID() {
		return fkItemID;
	}

	public void setFkItemID(Long fkItemID) {
		this.fkItemID = fkItemID;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderItem [ordersItemsID=" + ordersItemsID + ", fkOrderID=" + fkOrderID + ", fkItemID=" + fkItemID
				+ ", quantity=" + quantity + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(fkOrderID, fkItemID, ordersItemsID, quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		return Objects.equals(fkOrderID, other.fkOrderID) && Objects.equals(fkItemID, other.fkItemID)
				&& Objects.equals(ordersItemsID, other.ordersItemsID) && Objects.equals(quantity, other.quantity);
	}

}
