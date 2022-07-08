package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.OrderItemController;
import com.qa.ims.persistence.dao.OrderItemDAO;
import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.utils.Utils;


@RunWith(MockitoJUnitRunner.class)
public class OrderItemControllerTest {

	@Mock
	private Utils utils;

	@Mock
	private OrderItemDAO dao;

	@InjectMocks
	private OrderItemController controller;

//	@Test
//	public void testCreate() {
//		
//		final Long FkOrderID = 1L;
//		final Long FkItemID = 1L;
//		final Long Quantity = 100L;
//		final OrderItem created = new OrderItem(FkOrderID, FkItemID, Quantity);
//
//		Mockito.when(utils.getLong()).thenReturn(FkOrderID);
//		Mockito.when(utils.getLong()).thenReturn(FkItemID);
//		Mockito.when(utils.getLong()).thenReturn(Quantity);
//		Mockito.when(dao.create(created)).thenReturn(created);
//		Mockito.when(controller.create()).thenReturn(created);
//		
//
//		assertEquals(created, controller.create());
//
//		Mockito.verify(utils, Mockito.times(6)).getLong();
//		Mockito.verify(dao, Mockito.times(1)).create(created);
//	}

	@Test
	public void testReadAll() {
		List<OrderItem> OrdersItems = new ArrayList<>();
		OrdersItems.add(new OrderItem(1L, 1L, 100L));

		Mockito.when(dao.readAll()).thenReturn(OrdersItems);

		assertEquals(OrdersItems, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}

	@Test
	public void testUpdate() {
		
		assertEquals(null, this.controller.update());
	}

	@Test
	public void testDelete() {
		final long OrderItemID = 1L;

		Mockito.when(utils.getLong()).thenReturn(OrderItemID);
		Mockito.when(dao.delete(OrderItemID)).thenReturn(1);

		assertEquals(1L, this.controller.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(OrderItemID);
	}

}

