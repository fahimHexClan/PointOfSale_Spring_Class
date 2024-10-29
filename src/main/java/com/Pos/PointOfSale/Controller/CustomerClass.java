package com.Pos.PointOfSale.Controller;

import com.Pos.PointOfSale.Service.CustomerService;
import com.Pos.PointOfSale.Service.CustomerServiceImpl.CustomerServiceIMPL;
import com.Pos.PointOfSale.dto.CustomerDTO;
import com.Pos.PointOfSale.dto.request.CustomerSaveRequestDto;
import com.Pos.PointOfSale.dto.request.CustomerUpdateRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/customer")
public class CustomerClass {

    @Autowired
    private CustomerService customerService;

    @PostMapping(path ="/save")
    public String saveCustomer(@RequestBody CustomerSaveRequestDto customerSaveRequestDto){
        String id = customerService.addCustomer(customerSaveRequestDto);


        return id;
    }
    @PutMapping
    public String updateCustomer(@RequestBody CustomerUpdateRequestDto customerUpdateRequestDto){
    String updated=customerService.updateCustomer(customerUpdateRequestDto);
    return updated;
    }

    @GetMapping(path = "/get-by-id",params = "id")
    //uda parm eke daapu id eka @RequestParam eka use karala pahala allagannawa
    //backend   eke idala ui ekata data yawankota api use karanne dto anika
    public CustomerDTO getCustomerById(@RequestParam(value = "id") int id){
    CustomerDTO customerDTO=customerService.getCustomerBy(id);



        return  customerDTO;
    }
}
