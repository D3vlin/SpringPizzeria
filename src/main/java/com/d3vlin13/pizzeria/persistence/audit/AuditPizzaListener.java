package com.d3vlin13.pizzeria.persistence.audit;

import com.d3vlin13.pizzeria.persistence.entity.PizzaEntity;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PreRemove;
import org.springframework.util.SerializationUtils;

public class AuditPizzaListener {
    private PizzaEntity currentValue;

    @PostLoad
    public void postLoad(PizzaEntity pizzaEntity) {
        System.out.println(pizzaEntity.toString());
        this.currentValue = SerializationUtils.clone(pizzaEntity);
    }

    @PostPersist
    @PostUpdate
    public void onPostPersist(PizzaEntity pizzaEntity) {
        System.out.println("OLD -> " + currentValue.toString());
        System.out.println("NEW -> " + pizzaEntity.toString());
    }

    @PreRemove
    public void onPreDelete(PizzaEntity pizzaEntity) {
        System.out.println(pizzaEntity.toString());
    }
}
