package com.Pos.PointOfSale.util.mappers;

import com.Pos.PointOfSale.Entity.ItemEntity;
import com.Pos.PointOfSale.dto.ItemDto;
import com.Pos.PointOfSale.dto.request.ItemSaveRequestDto;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface ItemMapper {
    ItemEntity RequesDtoToEntity(ItemSaveRequestDto itemSaveRequestDto);

    List<ItemDto> pageToList(Page<ItemEntity>page);
}
