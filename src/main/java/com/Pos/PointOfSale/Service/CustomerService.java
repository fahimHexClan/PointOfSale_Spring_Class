package com.Pos.PointOfSale.Service;

import com.Pos.PointOfSale.dto.CustomerDTO;
import com.Pos.PointOfSale.dto.request.CustomerSaveRequestDto;
import com.Pos.PointOfSale.dto.request.CustomerUpdateRequestDto;

import java.util.List;

public interface CustomerService {
    String addCustomer(CustomerSaveRequestDto customerDTO);

    String updateCustomer(CustomerUpdateRequestDto customerUpdateRequestDto);

    CustomerDTO getCustomerBy(int id);

    List<CustomerDTO> getAllCustomers();
}
