package com.Pos.PointOfSale.repository;

import com.Pos.PointOfSale.Entity.OrderDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface OrdetDetailsRepo extends JpaRepository<OrderDetailsEntity, Integer> {
}
