package com.Pos.PointOfSale.util.mappers;

import com.Pos.PointOfSale.Entity.ItemEntity;
import com.Pos.PointOfSale.Entity.enums.MeasuringUnitType;
import com.Pos.PointOfSale.dto.request.ItemSaveRequestDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-02T23:14:52+0530",
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
}
