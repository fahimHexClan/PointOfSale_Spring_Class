package com.Pos.PointOfSale.repository;

import com.Pos.PointOfSale.Entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
//methana ape entityai id ekae value ekai aniwaren danna ona
public interface CustomerRepo extends JpaRepository<CustomerEntity,Integer> {

    //meken equal wenuwata is eken karannth  puluwan
    List<CustomerEntity> findAllByCustomerNameEquals(String customerName);

//(Dao part)entity eka database

}
