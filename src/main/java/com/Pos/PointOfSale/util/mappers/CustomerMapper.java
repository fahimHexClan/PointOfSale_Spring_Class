package com.Pos.PointOfSale.util.mappers;

import com.Pos.PointOfSale.Entity.CustomerEntity;
import com.Pos.PointOfSale.dto.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface CustomerMapper {
    CustomerDTO entityToDto(CustomerEntity customerEntity);
}
