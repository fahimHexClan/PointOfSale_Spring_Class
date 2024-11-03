package com.Pos.PointOfSale.repository;


import com.Pos.PointOfSale.Entity.ItemEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository

public interface ItemRepo extends JpaRepository<ItemEntity, Integer> {

    List<ItemEntity> findAllByActiveStateEquals(boolean status);

    int countAllByActiveStateEquals(boolean b);

    Page<ItemEntity> findAllByActiveStateEquals(boolean activeState, Pageable of);
}
