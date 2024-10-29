package com.Pos.PointOfSale.Service;

import com.Pos.PointOfSale.dto.CustomerDTO;
import com.Pos.PointOfSale.dto.request.CustomerSaveRequestDto;
import com.Pos.PointOfSale.dto.request.CustomerUpdateRequestDto;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface CustomerService {
    String addCustomer(CustomerSaveRequestDto customerDTO);

    String updateCustomer(CustomerUpdateRequestDto customerUpdateRequestDto);

    CustomerDTO getCustomerById(int id);

    List<CustomerDTO> getAllCustomers();

    boolean deleteCustomer(int id) throws ChangeSetPersister.NotFoundException;

    List<CustomerDTO> getByName(String customerName) throws ChangeSetPersister.NotFoundException;
}
