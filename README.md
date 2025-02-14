# Order Service

## 🚀 Overview

The **Order Service** is a RESTful API that facilitates the management of orders within an e-commerce or business platform. It enables users to create and manage orders, including linking them to payment types and products.

This service is built using **Spring Boot**, **Spring Data JPA**, and **Feign Clients** to integrate with other services (like payment types and product services) for a fully functional order management system.

## 🌟 Key Features

- **RESTful API**: Provides endpoints for order creation and retrieval.
- **Feign Integration**: Uses Feign clients to call external services for product and payment type information.
- **Order Management**: Handles order details such as order number, status, client ID, total amount, and related products.

## 🔑 API Endpoints

### 1. **POST** `/api/orders`
Creates a new order.

**Request Body**:
- `orderNumber`: The order number (generated automatically).
- `orderDate`: The date and time of the order.
- `totalAmount`: The total amount of the order.
- `status`: The status of the order (e.g., "pending", "completed").
- `clientId`: The ID of the client making the order.
- `paymentTypeId`: The ID of the payment method used.
- `items`: A list of order items, each containing the product ID, quantity, and price.

**Response**:
- Returns the created `Order` object.

## 🔧 Technologies Used

- **Spring Boot**: Framework for building the application.
- **JPA** (Java Persistence API): Handles database interaction for orders and order items.
- **Feign Clients**: Used for calling external services (product and payment type services).
- **H2 Database** (or other relational DB): Stores order and order item data.
- **Java**: The programming language used to develop the service.

## 💡 Use Case

This service is ideal for systems that need to manage orders in a flexible way. It integrates seamlessly with other services (such as product and payment services) to provide a robust order management system for e-commerce platforms, POS systems, or any service that handles customer orders.
