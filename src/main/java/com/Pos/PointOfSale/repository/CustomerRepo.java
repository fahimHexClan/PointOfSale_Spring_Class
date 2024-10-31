package com.Pos.PointOfSale.repository;

import com.Pos.PointOfSale.Entity.CustomerEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@EnableJpaRepositories
@Repository
@Transactional//update query ekak thiyanakota meka aniwaren danna ona (java Jakarta eka)
//methana ape entityai id ekae value ekai aniwaren danna ona
public interface CustomerRepo extends JpaRepository<CustomerEntity,Integer> {

    //meken equal wenuwata is eken karannth  puluwan
    List<CustomerEntity> findAllByCustomerNameEquals(String customerName);

    List<CustomerEntity> findAllByActiveStateEquals (boolean b);


    @Modifying
    //native query use wenne properly query ghanna
    @Query(value = "update customer set customer_name=?1,nic=?2 where customer_id=?3",nativeQuery = true)//meken mkth return wenna
    void UpadateCustomerByQuery(String customerName, String nic, int id);

    Optional<CustomerEntity> findByNicEquals(String nic);


//(Dao part)entity eka database

}
