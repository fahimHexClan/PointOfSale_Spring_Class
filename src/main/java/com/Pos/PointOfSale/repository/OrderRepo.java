package com.Pos.PointOfSale.repository;

import com.Pos.PointOfSale.Entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface OrderRepo extends JpaRepository<OrderEntity, Integer> {

}
