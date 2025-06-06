package com.d3vlin13.pizzeria.persistence.projection;

import java.time.LocalDateTime;

public interface IOrderSummary {
    Integer getIdOrder();
    String getCustomerName();
    LocalDateTime getOrderDate();
    Double getOrderTotal();
    String getPizzaNames();
}
