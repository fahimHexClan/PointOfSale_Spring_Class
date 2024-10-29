package com.Pos.PointOfSale.repository;

import com.Pos.PointOfSale.Entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface CustomerRepo extends JpaRepository<CustomerEntity,Integer> {
    List<CustomerEntity> findAllByCustomerNameEquals(String customerName);

//(Dao part)entity eka database

}
