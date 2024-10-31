package com.Pos.PointOfSale.Controller;

import com.Pos.PointOfSale.Service.CustomerService;
import com.Pos.PointOfSale.dto.CustomerDTO;
import com.Pos.PointOfSale.dto.request.CustomerSaveRequestDto;
import com.Pos.PointOfSale.dto.request.CustomerUpdateByDto;
import com.Pos.PointOfSale.dto.request.CustomerUpdateQueryRequestDto;
import com.Pos.PointOfSale.dto.request.CustomerUpdateRequestDto;
import com.Pos.PointOfSale.dto.response.ResponseActiveCustomerDto;
import com.Pos.PointOfSale.dto.response.ResponseCustomerFilterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(path = "/save")
    public String saveCustomer(@RequestBody CustomerSaveRequestDto customerSaveRequestDto) {
        String id = customerService.addCustomer(customerSaveRequestDto);
        return id;
    }

    @PutMapping (path = "/update")
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

    @GetMapping(
            path = {"/get-by-active-state"}
    )
    public List<CustomerDTO> getCustomerByActiveState() throws ChangeSetPersister.NotFoundException {
    List<CustomerDTO> getCustomers =customerService.getAllCustomersByActiveState();

        return getCustomers;
    }

    @GetMapping(
            path = {"/get-by-active-state-only-name"}
    )
    public List<ResponseActiveCustomerDto> getCustomerByActiveStateOnlyName() throws ChangeSetPersister.NotFoundException {
        List<ResponseActiveCustomerDto> getCustomersName =customerService.getAllCustomersByActiveStateOnlyName();

        return getCustomersName;
    }
    @PutMapping (path = "/update-Query/{id}")
    //me dto eken id remo karpu hindha parameter ekata id eka danawa
    public String updateCustomerByQuery(@RequestBody CustomerUpdateQueryRequestDto customerUpdateQueryRequestDto,
                                        @PathVariable(value = "id") int id) {
        String updated = customerService.updateCustomerByQuery(customerUpdateQueryRequestDto,id);
        return updated;
    }

    @GetMapping(
            path = {"/get-customer-by-nic"},
            params = {"nic"}
    )
//params eken String id ekth name chnge wenawanam witharai (value="")eka ona wenne hebai eka dalama hadana eka thma standart
    public CustomerDTO getCustomerByNic(@RequestParam(value = "nic") String nic) {
        CustomerDTO customerDTO = customerService.getCustomerByNic(nic);
        return customerDTO;
    }
    @GetMapping(
            path = {"/get-customer-by-id-filter"},
            params = {"id"}
    )
//params eken String id ekth name chnge wenawanam witharai (value="")eka ona wenne hebai eka dalama hadana eka thma standart
    public ResponseCustomerFilterDto getCustomerByIdFilter(@RequestParam(value = "id") int id) {
        ResponseCustomerFilterDto responseCustomerFilterDto = customerService.getCustomerByIdFilter(id);
        return responseCustomerFilterDto;
    }

    @PutMapping (path = "/update-By-request/{id}")
    public String updateCustomerByRequest(@RequestBody CustomerUpdateByDto customerUpdateRequestDto,
                                          @PathVariable(value ="id")int id) {
        String updated = customerService.updateCustomerByRequest(customerUpdateRequestDto,id);
        return updated;
    }
    @GetMapping(
            path = {"/get-by-id-is-active"},
            params = {"id"}
    )
    public CustomerDTO getCustomerByIdIsActive(@RequestParam(value = "id") int id) {
        CustomerDTO customerDTO = customerService.getCustomerByIdIsActive(id);
        return customerDTO;
    }

}
