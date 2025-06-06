package com.d3vlin13.pizzeria.persistence.Projection;

import java.time.LocalDateTime;

public interface IOrderSummary {
    Integer getIdOrder();
    String getCustomerName();
    LocalDateTime getOrderDate();
    Double getOrderTotal();
    String getPizzaNames();
}
