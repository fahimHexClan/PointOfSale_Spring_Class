package com.Pos.PointOfSale.util.mappers;

import com.Pos.PointOfSale.Entity.CustomerEntity;
import com.Pos.PointOfSale.dto.CustomerDTO;
import com.Pos.PointOfSale.dto.response.ResponseActiveCustomerDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-30T13:55:01+0530",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerDTO entityToDto(CustomerEntity customerEntity) {
        if ( customerEntity == null ) {
            return null;
        }

        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setCustomerId( customerEntity.getCustomerId() );
        customerDTO.setCustomerName( customerEntity.getCustomerName() );
        customerDTO.setCustomerAddress( customerEntity.getCustomerAddress() );
        customerDTO.setCustomerSalary( customerEntity.getCustomerSalary() );
        ArrayList<String> arrayList = customerEntity.getContactNumbers();
        if ( arrayList != null ) {
            customerDTO.setContactNumbers( new ArrayList<String>( arrayList ) );
        }
        customerDTO.setNic( customerEntity.getNic() );
        customerDTO.setActiveState( customerEntity.isActiveState() );

        return customerDTO;
    }

    @Override
    public List<CustomerDTO> entityListToDto(List<CustomerEntity> customerEntities) {
        if ( customerEntities == null ) {
            return null;
        }

        List<CustomerDTO> list = new ArrayList<CustomerDTO>( customerEntities.size() );
        for ( CustomerEntity customerEntity : customerEntities ) {
            list.add( entityToDto( customerEntity ) );
        }

        return list;
    }

    @Override
    public List<ResponseActiveCustomerDto> entityListToResponseDto(List<CustomerEntity> customerEntities) {
        if ( customerEntities == null ) {
            return null;
        }

        List<ResponseActiveCustomerDto> list = new ArrayList<ResponseActiveCustomerDto>( customerEntities.size() );
        for ( CustomerEntity customerEntity : customerEntities ) {
            list.add( customerEntityToResponseActiveCustomerDto( customerEntity ) );
        }

        return list;
    }

    protected ResponseActiveCustomerDto customerEntityToResponseActiveCustomerDto(CustomerEntity customerEntity) {
        if ( customerEntity == null ) {
            return null;
        }

        ResponseActiveCustomerDto responseActiveCustomerDto = new ResponseActiveCustomerDto();

        responseActiveCustomerDto.setCustomerName( customerEntity.getCustomerName() );
        ArrayList<String> arrayList = customerEntity.getContactNumbers();
        if ( arrayList != null ) {
            responseActiveCustomerDto.setContactNumbers( new ArrayList<String>( arrayList ) );
        }

        return responseActiveCustomerDto;
    }
}
