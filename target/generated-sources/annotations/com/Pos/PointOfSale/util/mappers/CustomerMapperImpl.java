package com.Pos.PointOfSale.util.mappers;

import com.Pos.PointOfSale.Entity.CustomerEntity;
import com.Pos.PointOfSale.dto.CustomerDTO;
import java.util.ArrayList;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-29T22:35:32+0530",
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
}
