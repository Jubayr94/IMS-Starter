package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.utils.DBUtils;

public class OrderItemDAO implements Dao<OrderItem> {

	public static final Logger LOGGER = LogManager.getLogger();

	@Override
	public OrderItem modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long ordersItemsID = resultSet.getLong("orders_items_id");
		Long fkOrderID = resultSet.getLong("fk_order_id");
		Long fkItemID = resultSet.getLong("fk_item_id");
		Long quantity = resultSet.getLong("quantity");
		return new OrderItem(ordersItemsID, fkOrderID, fkItemID, quantity);
	}

	/**
	 * Reads all order items from the database
	 * 
	 * @return A list of order items
	 */
	@Override
	public List<OrderItem> readAll() {
		List<OrderItem> orders_items = new ArrayList<>();
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders_items");) {
			while (resultSet.next()) {
				orders_items.add(modelFromResultSet(resultSet));
			}
			return orders_items;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return orders_items;
	}

	public OrderItem readLatest() {
		OrderItem newOrderItem = null;
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders_items ORDER BY orders_items_id DESC LIMIT 1");) {
			resultSet.next();
			newOrderItem = modelFromResultSet(resultSet);
			return newOrderItem;
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return newOrderItem;
	}

	@Override
	public OrderItem read(Long ordersItemsID) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM orders_items WHERE orders_items_id = ?");) {
			statement.setLong(1, ordersItemsID);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return modelFromResultSet(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Creates an order items in the database
	 * 
	 * @param order items - takes in an order items object. OrderItemsID will be ignored
	 */
	@Override
	public OrderItem create(OrderItem orderItem) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("INSERT INTO orders_items(fk_order_id, fk_item_id, quantity) VALUE (?, ?, ?)");) {
			statement.setLong(1, orderItem.getFkOrderID());
			statement.setLong(2, orderItem.getFkItemID());
			statement.setLong(3, orderItem.getQuantity());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return orderItem;
	}

	/**
	 * Updates an order items in the database
	 * 
	 * @param order items - takes in a order items object, the order_item_id field will be used to
	 *                 update that order item in the database
	 * @return
	 */
	@Override
	public OrderItem update(OrderItem orderItem) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("UPDATE orders_items SET fk_order_id = ?, fk_item_id = ?, quantity = ? WHERE order_items_id = ?");) {
			statement.setLong(1, orderItem.getFkOrderID());
			statement.setLong(2, orderItem.getFkItemID());
			statement.setLong(3, orderItem.getQuantity());
			statement.executeUpdate();
			return read(orderItem.getOrdersItemsID());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Deletes an order items in the database
	 * 
	 * @param orders_items_id - orders_items_id of the order items
	 */
	@Override
	public int delete(long ordersItemsID) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM orders_items WHERE orders_items_id = ?");) {
			statement.setLong(1, ordersItemsID);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

}
