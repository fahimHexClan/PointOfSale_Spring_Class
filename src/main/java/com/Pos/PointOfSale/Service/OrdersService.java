package com.Pos.PointOfSale.Service;

import com.Pos.PointOfSale.dto.request.RequestOrderSaveDto;

public interface OrdersService {


    String addOrders(RequestOrderSaveDto requestOrderSaveDto);
}
