package com.mipagina.order_service.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier of the order", example = "1")
    private Long id;

    @Schema(description = "Unique order number", example = "ORD123456", required = true)
    private String orderNumber;

    @Schema(description = "Date and time when the order was placed", example = "2025-02-05T15:30:00", required = true)
    private LocalDateTime orderDate;

    @Schema(description = "Total amount for the order", example = "250.75", required = true)
    private Double totalAmount;

    @Schema(description = "Status of the order", example = "Pending", required = true)
    private String status;

    @Schema(description = "Unique identifier of the client placing the order", example = "101", required = true)
    private Long clientId;

    @Schema(description = "Unique identifier for the payment type used", example = "1", required = true)
    private Long paymentTypeId;

@OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    @JsonManagedReference
    private List<OrderItem> items;

    // Constructor
    public Order() {}

    // Getters
    public Long getId() {
        return id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public Long getClientId() {
        return clientId;
    }

    public Long getPaymentTypeId() {
        return paymentTypeId;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public void setPaymentTypeId(Long paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }
}
