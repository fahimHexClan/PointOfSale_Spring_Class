package com.Pos.PointOfSale.Controller;

import com.Pos.PointOfSale.Service.CustomerService;
import com.Pos.PointOfSale.dto.CustomerDTO;
import com.Pos.PointOfSale.dto.request.CustomerSaveRequestDto;
import com.Pos.PointOfSale.dto.request.CustomerUpdateRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/customer")
public class CustomerClass {

    @Autowired
    private CustomerService customerService;

    @PostMapping(path = "/save")
    public String saveCustomer(@RequestBody CustomerSaveRequestDto customerSaveRequestDto) {
        String id = customerService.addCustomer(customerSaveRequestDto);
        return id;
    }

    @PutMapping
    public String updateCustomer(@RequestBody CustomerUpdateRequestDto customerUpdateRequestDto) {
        String updated = customerService.updateCustomer(customerUpdateRequestDto);
        return updated;
    }

    @GetMapping(path = "/get-by-id", params = "id")
    //uda parm eke daapu id eka @RequestParam eka use karala pahala allagannawa
    //backend   eke idala ui ekata data yawankota api use karanne dto anika
    // (getbyuser id ekata api dto eken idala data ganne hethuwa a id eken a dala data withark ganna nisa )
    public CustomerDTO getCustomerById(@RequestParam(value = "id") int id) {
        CustomerDTO customerDTO = customerService.getCustomerById(id);
        return customerDTO;
    }

    @GetMapping(
            path = {"/getAllCustomers"}
    )
    public List<CustomerDTO> getAllCustomer() {
        List<CustomerDTO> allCUstomers = customerService.getAllCustomers();
        return allCUstomers;

    }

    @DeleteMapping(
            path = {"/delete-customer/{id}"}
    )
    public String deleteCustomer(@PathVariable(value = "id") int id) throws ChangeSetPersister.NotFoundException {
        boolean deletedCustomer = customerService.deleteCustomer(id);
        return "delete";
    }
    @GetMapping(
            path = {"/get-by-name"},
            params = {"name"}
    )
    //samanen methana list ekak kiyala gaththe 1ma name
    // godak thiyanna puluwan a nisa array list ekak gaththa
    public List<CustomerDTO> getCustomerByName(@RequestParam (value = "name")String customerName) throws ChangeSetPersister.NotFoundException {
    List<CustomerDTO> getCustomer= customerService.getByName(customerName);
    return getCustomer;
    }
}
