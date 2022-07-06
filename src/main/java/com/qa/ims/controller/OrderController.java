package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

/**
 * Takes in order details for CRD functionality
 *
 */
public class OrderController implements CrudController<Order> {

	public static final Logger LOGGER = LogManager.getLogger();

	private OrderDAO orderDAO;
	private Utils utils;

	public OrderController(OrderDAO orderDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
	}

	/**
	 * Reads all orders to the logger
	 */
	@Override
	public List<Order> readAll() {
		List<Order> orders = orderDAO.readAll();
		for (Order order : orders) {
			LOGGER.info(order);
		}
		return orders;
	}

	/**
	 * Creates an order by taking in user input
	 */
	@Override
	public Order create() {
		LOGGER.info("Please enter the Customer ID");
		Long fk_id = utils.getLong();
		Order order = orderDAO.create(new Order(fk_id));
		LOGGER.info("Order Created");
		return order;
	}

	/**
	 * Updates an existing order by taking in user input
	 */
	@Override
	public Order update() {
		LOGGER.info("Please enter the order ID you would like to update");
		Long orderID = utils.getLong();
		LOGGER.info("Please enter Customer ID");
		Long fk_id = utils.getLong();
		Order order = orderDAO.update(new Order(orderID, fk_id));
		LOGGER.info("Order Updated");
		return order;
	}

	/**
	 * Deletes an existing order by the order ID
	 *
	 * @return
	 */
	@Override
	public int delete() {
		LOGGER.info("Please enter the order ID you would like to delete");
		Long orderID = utils.getLong();
		return orderDAO.delete(orderID);
	}

}
