package com.Pos.PointOfSale.util.mappers;

import com.Pos.PointOfSale.Entity.ItemEntity;
import com.Pos.PointOfSale.Entity.enums.MeasuringUnitType;
import com.Pos.PointOfSale.dto.ItemDto;
import com.Pos.PointOfSale.dto.request.ItemSaveRequestDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-06T22:02:25+0530",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class ItemMapperImpl implements ItemMapper {

    @Override
    public ItemEntity RequesDtoToEntity(ItemSaveRequestDto itemSaveRequestDto) {
        if ( itemSaveRequestDto == null ) {
            return null;
        }

        ItemEntity itemEntity = new ItemEntity();

        itemEntity.setItemName( itemSaveRequestDto.getItemName() );
        if ( itemSaveRequestDto.getMeasuringUnit() != null ) {
            itemEntity.setMeasuringUnit( Enum.valueOf( MeasuringUnitType.class, itemSaveRequestDto.getMeasuringUnit() ) );
        }
        itemEntity.setBalanceQty( itemSaveRequestDto.getBalanceQty() );
        itemEntity.setSupplierPrice( itemSaveRequestDto.getSupplierPrice() );
        itemEntity.setSellingPrice( itemSaveRequestDto.getSellingPrice() );

        return itemEntity;
    }

    @Override
    public List<ItemDto> pageToList(Page<ItemEntity> page) {
        if ( page == null ) {
            return null;
        }

        List<ItemDto> list = new ArrayList<ItemDto>();
        for ( ItemEntity itemEntity : page ) {
            list.add( itemEntityToItemDto( itemEntity ) );
        }

        return list;
    }

    protected ItemDto itemEntityToItemDto(ItemEntity itemEntity) {
        if ( itemEntity == null ) {
            return null;
        }

        ItemDto itemDto = new ItemDto();

        itemDto.setItemId( itemEntity.getItemId() );
        itemDto.setItemName( itemEntity.getItemName() );
        itemDto.setMeasuringUnit( itemEntity.getMeasuringUnit() );
        itemDto.setBalanceQty( itemEntity.getBalanceQty() );
        itemDto.setSupplierPrice( itemEntity.getSupplierPrice() );
        itemDto.setSellingPrice( itemEntity.getSellingPrice() );
        itemDto.setActiveState( itemEntity.isActiveState() );

        return itemDto;
    }
}
