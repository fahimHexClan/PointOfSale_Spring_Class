package com.Pos.PointOfSale.Controller;

import com.Pos.PointOfSale.Service.CustomerService;
import com.Pos.PointOfSale.Service.ItemService;
import com.Pos.PointOfSale.dto.request.CustomerSaveRequestDto;
import com.Pos.PointOfSale.dto.request.ItemSaveRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/item")
public class ItemController {

    @Autowired
    private com.Pos.PointOfSale.Service.ItemService itemService;

    @PostMapping(path = "/save")
    public String saveItem(@RequestBody ItemSaveRequestDto itemSaveRequestDto) {
        String id = itemService.addCustomer(itemSaveRequestDto);
        return id;
    }

}
