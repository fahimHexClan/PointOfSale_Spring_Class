package com.Pos.PointOfSale.Service;

import com.Pos.PointOfSale.dto.CustomerDTO;
import com.Pos.PointOfSale.dto.request.CustomerSaveRequestDto;
import com.Pos.PointOfSale.dto.request.CustomerUpdateQueryRequestDto;
import com.Pos.PointOfSale.dto.request.CustomerUpdateRequestDto;
import com.Pos.PointOfSale.dto.response.ResponseActiveCustomerDto;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface CustomerService {
    String addCustomer(CustomerSaveRequestDto customerDTO);

    String updateCustomer(CustomerUpdateRequestDto customerUpdateRequestDto);

    CustomerDTO getCustomerById(int id);

    List<CustomerDTO> getAllCustomers();

    boolean deleteCustomer(int id) throws ChangeSetPersister.NotFoundException;

    List<CustomerDTO> getByName(String customerName) throws ChangeSetPersister.NotFoundException;

    List<CustomerDTO> getAllCustomersByActiveState() throws ChangeSetPersister.NotFoundException;

    List<ResponseActiveCustomerDto> getAllCustomersByActiveStateOnlyName() throws ChangeSetPersister.NotFoundException;

    String updateCustomerByQuery(CustomerUpdateQueryRequestDto customerUpdateQueryRequestDto, int id);

    CustomerDTO getCustomerByNic(String nic);
}
