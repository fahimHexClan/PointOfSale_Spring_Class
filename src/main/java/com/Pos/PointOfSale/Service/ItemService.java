package com.Pos.PointOfSale.Service;

import com.Pos.PointOfSale.dto.ItemDto;
import com.Pos.PointOfSale.dto.request.ItemSaveRequestDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ItemService {
    String addItem(ItemSaveRequestDto itemSaveRequestDto);


    List<ItemDto> getAllItems();

    List<ItemDto> getAllItemsByStateType(boolean status);
}
