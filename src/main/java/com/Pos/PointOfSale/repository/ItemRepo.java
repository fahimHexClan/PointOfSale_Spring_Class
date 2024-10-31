package com.Pos.PointOfSale.repository;


import com.Pos.PointOfSale.Entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository

public interface ItemRepo extends JpaRepository<ItemEntity, Integer> {

}
