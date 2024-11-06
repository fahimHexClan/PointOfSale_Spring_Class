package com.Pos.PointOfSale.Controller;

import com.Pos.PointOfSale.Service.OrdersService;
import com.Pos.PointOfSale.dto.request.RequestOrderSaveDto;
import com.Pos.PointOfSale.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/Order")
public class OrderController {
    @Autowired
    private OrdersService ordersService;

    @PostMapping(path = "/save")

    //Spring eke thiyanawa respoce entity kiyala ekak eken wenne http request ekata return ekak denna use karanne
    public ResponseEntity<StandardResponse> saveItem(@RequestBody RequestOrderSaveDto requestOrderSaveDto) {
    String id = ordersService.addOrders(requestOrderSaveDto);


        //return type eka ResponseEntity dila genaric eke api create karapu StandardResponseclass eka dala
        // a class eke attributes tika fill karala okkoma create unama created kiyana eka danawa
        return new ResponseEntity<StandardResponse>(new StandardResponse(201, id + "Item Succesfully saved  : ", id), HttpStatus.CREATED//data ekak aluthen create karama create kiyala return karanawa
        );
    }

}
