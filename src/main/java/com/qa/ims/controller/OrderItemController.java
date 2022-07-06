package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderItemDAO;
import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.utils.Utils;

/**
 * Takes in customer details for CRUD functionality
 *
 */
public class OrderItemController implements CrudController<OrderItem> {

	public static final Logger LOGGER = LogManager.getLogger();
	
	private OrderItemDAO orderItemDAO;
	private Utils utils;

	public OrderItemController(OrderItemDAO orderItemDAO, Utils utils) {
        super();
        this.orderItemDAO = orderItemDAO;
        this.utils = utils;
    }

	/**
	 * Reads all items to the logger
	 */
	@Override
	public List<OrderItem> readAll() {
		List<OrderItem> orderItem = orderItemDAO.readAll();
		for (OrderItem orderItem1 : orderItem) {
			LOGGER.info(orderItem1);
		}
		return orderItem;
	}

	/**
	 * Creates an order item by taking in user input
	 */
	@Override
	public OrderItem create() {
		LOGGER.info("Please enter the Order ID of your order");
		Long fkOrderID = utils.getLong();
		LOGGER.info("Please enter the item id");
		Long fkItemID = utils.getLong();
		LOGGER.info("Please enter the quantity");
		Long quantity = utils.getLong();
		OrderItem orderItem = orderItemDAO.create(new OrderItem(fkOrderID, fkItemID, quantity));
		LOGGER.info("Order Item created");
		return orderItem;
	}

	/**
	 * Updates an existing order item by taking in user input
	 */
	@Override
	public OrderItem update() {
		LOGGER.info("Cannot Be Updated!");
		return null;
	}

	/**
     * Deletes an existing order item by the id of the order item
     *
     * @return
     */
    @Override
    public int delete() {
        LOGGER.info("Please enter the order item id of the order item you would like to delete");
        Long order_item_id = utils.getLong();
        return orderItemDAO.delete(order_item_id);
    }

}