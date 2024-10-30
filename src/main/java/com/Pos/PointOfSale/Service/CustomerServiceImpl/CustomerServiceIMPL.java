package com.Pos.PointOfSale.Service.CustomerServiceImpl;

import com.Pos.PointOfSale.Entity.CustomerEntity;
import com.Pos.PointOfSale.Service.CustomerService;
import com.Pos.PointOfSale.dto.CustomerDTO;
import com.Pos.PointOfSale.dto.request.CustomerSaveRequestDto;
import com.Pos.PointOfSale.dto.request.CustomerUpdateRequestDto;
import com.Pos.PointOfSale.dto.response.ResponseActiveCustomerDto;
import com.Pos.PointOfSale.repository.CustomerRepo;
import com.Pos.PointOfSale.util.mappers.CustomerMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomerMapper customerMapper;


    @Override
    public String addCustomer(CustomerSaveRequestDto customerDTO) {
        CustomerEntity customerEntity = new CustomerEntity(

                customerDTO.getCustomerName(), customerDTO.getCustomerAddress(), customerDTO.getCustomerSalary(), customerDTO.getContactNumbers(), customerDTO.getNic(), true);
        customerRepo.save(customerEntity);
        return customerEntity.getCustomerName() + " saved with ID: " + customerEntity.getCustomerId();

    }

    @Override
    public String updateCustomer(CustomerUpdateRequestDto customerUpdateRequestDto) {


/*//udathiyana customer repo kiyana object eka haraha  (exisitsBYId) eka clss ethule thiyana method ekak call karanawa  ekn (thiyana id hoyanna pluwn)
        ui eken aapu dto eken  getcustomer id set nam eya phalata yanawa*/
        if (customerRepo.existsById(customerUpdateRequestDto.getCustomerId())) {

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
        } else {
            System.out.println("Customer id does not exist");
            return "Customer id does not in Database";
        }
    }

    @Override
    public CustomerDTO getCustomerById(int id) {

        //genarics use karala data okkoma ganna ona hindha
        Optional<CustomerEntity> customerEntity = customerRepo.findById(id);
        if (customerEntity.isPresent()) {


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

           /* //optional dmmnam get eka aniwren danna ona neththm ganna ba data //meke model maper use karala hadagaththma easy
            CustomerDTO customerDTO = modelMapper.map(customerEntity.get(), CustomerDTO.class);*/

            //mapstruck
            CustomerDTO customerDTO = customerMapper.entityToDto(customerEntity.get());

            return customerDTO;
        } else {
            return null;
        }


    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<CustomerEntity> getCustomers = customerRepo.findAll();
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        /*for (CustomerEntity c : getCustomers) {
            CustomerDTO customerDto = new CustomerDTO(
                    c.getCustomerId(),
                    c.getCustomerName(),
                    c.getCustomerAddress(),
                    c.getCustomerSalary(),
                    c.getContactNumbers(),
                    c.getNic(),
                    c.isActiveState()

            );
            customerDTOList.add(customerDto);


        }*/
        List<CustomerDTO> customerDTOS = modelMapper.map(getCustomers, new TypeToken<List<CustomerDTO>>() {
        }.getType());


        return customerDTOS;
    }

    @Override
    public boolean deleteCustomer(int id) throws ChangeSetPersister.NotFoundException {
        if (customerRepo.existsById(id)) {
            customerRepo.deleteById(id);
        } else {
            throw new ChangeSetPersister.NotFoundException();
        }
        return true;
    }

    @Override
    public List<CustomerDTO> getByName(String customerName) throws ChangeSetPersister.NotFoundException {
        //meken boru namk gahala eka customer repo ekata yawala ethen apita
        // onade suggest karala (mata ona name eken idintify karanna )
        //erthakota repo eken find kiyala danakota customer name sugst wenawa  ethana eka hadala metha evila ctrl ekai space ekai ebuwama sugst wenawae
        List<CustomerEntity> customerEntities= customerRepo.findAllByCustomerNameEquals(customerName);
        //meken niyanne entity size 0 nttm athulata yanna nththm else ekata yanna
        if(customerEntities.size()!=0){
            List<CustomerDTO> customerDTOS = modelMapper.
                    map(customerEntities, new TypeToken<List<CustomerDTO>>() {
            }.getType());
            return customerDTOS;
        }else {
            throw new ChangeSetPersister.NotFoundException();
        }

    }

    @Override
    public List<CustomerDTO> getAllCustomersByActiveState() throws ChangeSetPersister.NotFoundException {
        //active customersla ganna thama true use karnne inactive nam false
      List<CustomerEntity> customerEntities = customerRepo.findAllByActiveStateEquals(true);
      if(customerEntities.size()!=0){
          //ud thiyana customerEntities thama perameter widihata yawanne
          List<CustomerDTO> customerDTOS = customerMapper.entityListToDto(customerEntities);
          return customerDTOS;
      }else {
          throw new ChangeSetPersister.NotFoundException();
      }


    }

    @Override
    public List<ResponseActiveCustomerDto> getAllCustomersByActiveStateOnlyName() throws ChangeSetPersister.NotFoundException {
        //active customersla ganna thama true use karnne inactive nam false
        //uda use karapu findAll ma mekata use karanna puluwan
        List<CustomerEntity> customerEntities = customerRepo.findAllByActiveStateEquals(true);
        if (customerEntities.size() != 0) {
            //ud thiyana customerEntities thama perameter widihata yawanne
            List<ResponseActiveCustomerDto> responseActiveCustomerDtos = customerMapper.entityListToResponseDto(customerEntities);
            return responseActiveCustomerDtos;
        } else {
            throw new ChangeSetPersister.NotFoundException();
        }

    }

    }
