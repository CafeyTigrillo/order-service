package com.mipagina.order_service.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderNumber;
    private LocalDateTime orderDate;
    private Double totalAmount;
    private String status;
    private Long clientId;
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
