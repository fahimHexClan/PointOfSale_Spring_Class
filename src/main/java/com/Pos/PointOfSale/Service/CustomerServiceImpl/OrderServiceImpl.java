package com.Pos.PointOfSale.Service.CustomerServiceImpl;

import com.Pos.PointOfSale.Entity.OrderDetailsEntity;
import com.Pos.PointOfSale.Entity.OrderEntity;
import com.Pos.PointOfSale.Service.OrdersService;
import com.Pos.PointOfSale.dto.request.RequestOrderSaveDto;
import com.Pos.PointOfSale.repository.CustomerRepo;
import com.Pos.PointOfSale.repository.ItemRepo;
import com.Pos.PointOfSale.repository.OrderRepo;
import com.Pos.PointOfSale.repository.OrdetDetailsRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrdersService {
    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private OrdetDetailsRepo ordetDetailsRepo;

    @Autowired
    private ItemRepo itemRepo;

    @Override
    @Transactional
    public String addOrders(RequestOrderSaveDto requestOrderSaveDto) {
        OrderEntity orderEntity = new OrderEntity(customerRepo.getById(requestOrderSaveDto.getCustomer()), requestOrderSaveDto.getDate(), requestOrderSaveDto.getTotal()
        );
        orderRepo.save(orderEntity);

        if (orderRepo.existsById(orderEntity.getOrderId())) {

            List<OrderDetailsEntity> orderDetailsEntities = modelMapper.map(requestOrderSaveDto.getOrderDetails(), new TypeToken<List<OrderDetailsEntity>>() {
        }.getType());


            for(int i = 0; i < orderDetailsEntities.size(); i++){
                orderDetailsEntities.get(i).setOrders(orderEntity);
                orderDetailsEntities.get(i).setItems(itemRepo.getById(requestOrderSaveDto.getOrderDetails().get(i).getItems()));


            }


            if (orderDetailsEntities.size()>0){
    ordetDetailsRepo.saveAll(orderDetailsEntities);

            }
            return "Saved";
        }
      return null;
    }

}
