package com.mipagina.order_service.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Table(name = "order_items")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier of the order item", example = "1")
    private Long id;

    @Schema(description = "Unique identifier for the product in the order", example = "2001", required = true)
    private Long productId;

    @Schema(description = "Quantity of the product ordered", example = "2", required = true)
    private Integer quantity;

    @Schema(description = "Unit price of the product", example = "100.25", required = true)
    private Double unitPrice;

    @Schema(description = "Subtotal for the order item (quantity * unit price)", example = "200.50", required = true)
    private Double subtotal;


@ManyToOne
    @JoinColumn(name = "order_id")
    @JsonBackReference
    private Order order;

    // Constructor
    public OrderItem() {}

    // Getters
    public Long getId() {
        return id;
    }

    public Long getProductId() {
        return productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public Order getOrder() {
        return order;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}