package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Order {

	private Long orderID;
	private Long fk_id;

	public Order(Long fk_id) {
		this.setFk_id(fk_id);
	}

	public Order(Long orderID, Long fk_id) {
		this.setOrderID(orderID);
		this.setFk_id(fk_id);
	}

	public Long getOrderID() {
		return orderID;
	}

	public void setOrderID(Long orderID) {
		this.orderID = orderID;
	}

	public Long getFk_id() {
		return fk_id;
	}

	public void setFk_id(Long fk_id) {
		this.fk_id = fk_id;
	}

	@Override
	public String toString() {
		return "Order [orderID=" + orderID + ", fk_id=" + fk_id + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(fk_id, orderID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(fk_id, other.fk_id) && Objects.equals(orderID, other.orderID);
	}
	
	
}
