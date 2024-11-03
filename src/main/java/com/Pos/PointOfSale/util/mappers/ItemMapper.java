package com.Pos.PointOfSale.util.mappers;

import com.Pos.PointOfSale.Entity.ItemEntity;
import com.Pos.PointOfSale.dto.request.ItemSaveRequestDto;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface ItemMapper {
ItemEntity RequesDtoToEntity(ItemSaveRequestDto itemSaveRequestDto);
}
