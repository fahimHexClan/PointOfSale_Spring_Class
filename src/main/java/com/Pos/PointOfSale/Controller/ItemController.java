package com.Pos.PointOfSale.Controller;

import com.Pos.PointOfSale.dto.ItemDto;
import com.Pos.PointOfSale.dto.request.ItemSaveRequestDto;
import com.Pos.PointOfSale.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/item")
public class ItemController {

    @Autowired
    private com.Pos.PointOfSale.Service.ItemService itemService;

    @PostMapping(path = "/save")

    //Spring eke thiyanawa respoce entity kiyala ekak eken wenne http request ekata return ekak denna use karanne
    public ResponseEntity<StandardResponse> saveItem(@RequestBody ItemSaveRequestDto itemSaveRequestDto) {
        String id = itemService.addItem(itemSaveRequestDto);

        //return type eka ResponseEntity dila genaric eke api create karapu StandardResponseclass eka dala
        // a class eke attributes tika fill karala okkoma create unama created kiyana eka danawa
        return new ResponseEntity<StandardResponse>(new StandardResponse(201, id + "Item Succesfully saved", id), HttpStatus.CREATED//data ekak aluthen create karama create kiyala return karanawa
        );
    }

    @GetMapping(path = {"/get_All_Item"})
    public ResponseEntity<StandardResponse> getAllItem() {
        List<ItemDto> allItems = itemService.getAllItems();
        return new ResponseEntity<StandardResponse>(new StandardResponse(200, " Succesfully get  ", allItems), HttpStatus.OK//data ekak aluthen get karama ok kiyala return karanawa
        );

    }

    //active inactive all items balanna use karnna method ekak
    @GetMapping(path = {"/get_All_Item-by-State"}, params = {"state"})
    public ResponseEntity<StandardResponse> getAllItemByStates(@RequestParam(value = "state") String state) {
        if (state.equalsIgnoreCase("active") | state.equalsIgnoreCase("inactive")) {

      /*  boolean status= false;
        if (state.equalsIgnoreCase("active")){
            status= true;
        }*/
            boolean status = state.equalsIgnoreCase("active");


            List<ItemDto> allItems = itemService.getAllItemsByStateType(status);
            return new ResponseEntity<StandardResponse>(new StandardResponse(200, " Succesfully get  ", allItems), HttpStatus.OK//data ekak aluthen get karama ok kiyala return karanawa
            );
        } else {
            List<ItemDto> allItems = itemService.getAllItems();
            return new ResponseEntity<StandardResponse>(new StandardResponse(200, " Succesfully get  ", allItems), HttpStatus.OK//data ekak aluthen get karama ok kiyala return karanawa
            );

        }

    }

}












