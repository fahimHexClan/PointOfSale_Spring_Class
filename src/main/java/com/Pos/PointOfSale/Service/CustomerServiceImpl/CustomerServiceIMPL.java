package com.Pos.PointOfSale.Service.CustomerServiceImpl;

import com.Pos.PointOfSale.Entity.CustomerEntity;
import com.Pos.PointOfSale.Service.CustomerService;
import com.Pos.PointOfSale.dto.CustomerDTO;
import com.Pos.PointOfSale.dto.request.CustomerSaveRequestDto;
import com.Pos.PointOfSale.dto.request.CustomerUpdateRequestDto;
import com.Pos.PointOfSale.repository.CustomerRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public String addCustomer(CustomerSaveRequestDto customerDTO) {
        CustomerEntity customerEntity = new CustomerEntity(

                customerDTO.getCustomerName(),
                customerDTO.getCustomerAddress(),
                customerDTO.getCustomerSalary(),
                customerDTO.getContactNumbers(),
                customerDTO.getNic(),
                true
         );
        customerRepo.save(customerEntity);
        return customerEntity.getCustomerName() + " saved with ID: " + customerEntity.getCustomerId();

    }

    @Override
    public String updateCustomer(CustomerUpdateRequestDto customerUpdateRequestDto) {


/*//udathiyana customer repo kiyana object eka haraha  (exisitsBYId) eka clss ethule thiyana method ekak call karanawa  ekn (thiyana id hoyanna pluwn)
        ui eken aapu dto eken  getcustomer id set nam eya phalata yanawa*/
        if (customerRepo.existsById(customerUpdateRequestDto.getCustomerId())){

            //customer entity eka haraha customer repo eke thiyana getby id method eke  ara fontend eke idala aapu id eka aragannawa
            CustomerEntity customerEntity = customerRepo.getById(customerUpdateRequestDto.getCustomerId());

            /*customer entity eken  (set)method eka ganne update karana hindha
            ita passe frontend eken idan yawanne Request dto ekn ekn aapu data eka mekata set wenawa  */
           customerEntity.setCustomerName(customerUpdateRequestDto.getCustomerName());
           customerEntity.setCustomerAddress(customerUpdateRequestDto.getCustomerAddress());
           customerEntity.setCustomerSalary(customerUpdateRequestDto.getCustomerSalary());
           customerEntity.setContactNumbers(customerUpdateRequestDto.getContactNumbers());
           customerEntity.setNic(customerUpdateRequestDto.getNic());
           //boolean wala getmethod eka widihata use karnne is eka
           customerEntity.setActiveState(customerUpdateRequestDto.isActiveState());
           //update ekak unata  mekth save method eken thama yawanne aluthen add wena widihata
           return customerRepo.save(customerEntity).getCustomerName() + "updated";
        }
        else{
            System.out.println("Customer id does not exist");
            return "Customer id does not in Database";
        }
    }

    @Override
    public CustomerDTO getCustomerBy(int id) {

        //genarics use karala data okkoma ganna ona hindha
        Optional<CustomerEntity> customerEntity = customerRepo.findById(id);
        if(customerEntity.isPresent()){








            /*//meke object ekak newei constracter call karana ekak
            CustomerDTO customerDTO = new CustomerDTO(
            //optional use karanakota data ganna get use kranawa
             customerEntity.get().getCustomerId(),
             customerEntity.get().getCustomerName(),
             customerEntity.get().getCustomerAddress(),
             customerEntity.get().getCustomerSalary(),
             customerEntity.get().getContactNumbers(),
             customerEntity.get().getNic(),
                     customerEntity.get().isActiveState()
             );
            return customerDTO;*/

            //optional dmmnam get eka aniwren danna ona neththm ganna ba data //meke model maper use karala hadagaththma easy
            CustomerDTO customerDTO = modelMapper.map(customerEntity.get(), CustomerDTO.class);
            return customerDTO;
        }else {
            return null;
        }


    }

}
