package com.Pos.PointOfSale.util.mappers;

import com.Pos.PointOfSale.Entity.CustomerEntity;
import com.Pos.PointOfSale.dto.CustomerDTO;
import com.Pos.PointOfSale.dto.response.ResponseActiveCustomerDto;
import com.Pos.PointOfSale.dto.response.ResponseCustomerFilterDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface CustomerMapper {
    //mn lagga thiyana type eka parameter dala karagnna ona type eka mulin daanawa
    CustomerDTO entityToDto(CustomerEntity customerEntity);

    List<CustomerDTO> entityListToDto(List<CustomerEntity> customerEntities);

    List<ResponseActiveCustomerDto> entityListToResponseDto (List<CustomerEntity> customerEntities);

    ResponseCustomerFilterDto entityToResponseDto(CustomerEntity customerEntity);
}
