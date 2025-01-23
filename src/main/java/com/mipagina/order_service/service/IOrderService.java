package com.mipagina.order_service.service;


import com.mipagina.order_service.model.Order;

public interface IOrderService {
   public Order createOrder(Order order);
   public String generateOrderNumber();
   public Double calculateTotal(Order order);
}
