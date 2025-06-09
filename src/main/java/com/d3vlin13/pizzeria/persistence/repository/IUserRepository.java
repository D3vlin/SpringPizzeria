package com.d3vlin13.pizzeria.persistence.repository;

import com.d3vlin13.pizzeria.persistence.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<UserEntity, String> {
}
