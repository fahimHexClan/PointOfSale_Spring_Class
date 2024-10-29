package com.Pos.PointOfSale.repository;

import com.Pos.PointOfSale.Entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface CustomerRepo extends JpaRepository<CustomerEntity,Integer> {

//(Dao part)entity eka database

}
