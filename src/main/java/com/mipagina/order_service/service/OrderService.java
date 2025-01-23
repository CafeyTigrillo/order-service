package com.mipagina.order_service.service;

import com.mipagina.order_service.model.Order;
import com.mipagina.order_service.model.OrderItem;
import com.mipagina.order_service.repository.IOrderRepository;
import com.mipagina.order_service.repository.IPaymentTypeAPI;
import com.mipagina.order_service.repository.IProductAPI;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService implements IOrderService {

    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private IOrderRepository orderRepository;

    @Autowired
    private IPaymentTypeAPI paymentTypeAPI;

    @Autowired
    private IProductAPI productAPI;

    @Transactional
    public Order createOrder(Order order) {
        logger.info("Iniciando la creación de una nueva orden.");

        // Validar productos y tipo de pago usando los Feign clients
        order.getItems().forEach(item -> {
            logger.info("Validando el producto con ID: {}", item.getProductId());
            var product = productAPI.getProductById(item.getProductId());

            if (product == null) {
                logger.error("El producto con ID {} no fue encontrado.", item.getProductId());
                throw new RuntimeException("El producto con ID " + item.getProductId() + " no fue encontrado.");
            }

            logger.info("Producto encontrado: {} - Precio: {}", product.getName(), product.getPrice());
            item.setUnitPrice(product.getPrice());
            item.setSubtotal(product.getPrice() * item.getQuantity());
            item.setOrder(order);
        });

        // Validar el tipo de pago
        logger.info("Validando el tipo de pago con ID: {}", order.getPaymentTypeId());
        var paymentType = paymentTypeAPI.getPaymentType(order.getPaymentTypeId());

        if (paymentType == null) {
            logger.error("El tipo de pago con ID {} no fue encontrado.", order.getPaymentTypeId());
            throw new RuntimeException("El tipo de pago con ID " + order.getPaymentTypeId() + " no fue encontrado.");
        }

        logger.info("Tipo de pago encontrado: {}", paymentType.getName());

        // Configurar la orden
        order.setOrderDate(LocalDateTime.now());
        order.setOrderNumber(generateOrderNumber());
        order.setStatus("PENDING");
        order.setTotalAmount(calculateTotal(order));

        logger.info("Total de la orden calculado: {}", order.getTotalAmount());

        // Guardar la orden
        var savedOrder = orderRepository.save(order);
        logger.info("Orden creada exitosamente con ID: {}", savedOrder.getId());

        return savedOrder;
    }

    public String generateOrderNumber() {
        return "ORD-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    public Double calculateTotal(Order order) {
        return order.getItems().stream()
                .mapToDouble(OrderItem::getSubtotal)
                .sum();
    }
}

