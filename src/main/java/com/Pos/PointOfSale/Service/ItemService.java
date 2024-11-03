package com.Pos.PointOfSale.Service;

import com.Pos.PointOfSale.dto.ItemDto;
import com.Pos.PointOfSale.dto.Paginated.PaginatedResponseItemDto;
import com.Pos.PointOfSale.dto.request.ItemSaveRequestDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ItemService {
    String addItem(ItemSaveRequestDto itemSaveRequestDto);


    List<ItemDto> getAllItems();

    List<ItemDto> getAllItemsByStateType(boolean status);


    int countAllItems();

    PaginatedResponseItemDto getAllItemsPaginated(int page, int size);

    PaginatedResponseItemDto getAllActiveItemsPaginated(int page, int size, boolean activeState);

}
